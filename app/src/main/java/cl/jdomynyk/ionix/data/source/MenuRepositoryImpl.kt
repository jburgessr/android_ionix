package cl.jdomynyk.ionix.data.source

import cl.jdomynyk.ionix.data.entity.MenuItem
import cl.jdomynyk.ionix.data.source.local.menu.MenuLocal
import cl.jdomynyk.ionix.data.source.remote.MenuService
import cl.jdomynyk.ionix.domain.RemoteResult
import cl.jdomynyk.ionix.domain.repository.MenuRepository
import java.lang.NullPointerException

class MenuRepositoryImpl(
    private val menuService: MenuService,
    private val menuLocal: MenuLocal
) : MenuRepository {
    override suspend fun getRemote(): RemoteResult<List<MenuItem>> {
        try {
            val result = menuService.getMenuAsync().await()
            if (result.isSuccessful) {
                val items = result.body()?.list
                return if (items != null)
                    RemoteResult.Success(items)
                else
                    RemoteResult.Exception(NullPointerException())
            }
            return RemoteResult.Error(result.code(), result.message())
        } catch (exception: Exception) {
            return RemoteResult.Exception(exception)
        }
    }

    override suspend fun insertAll(list: List<MenuItem>) = menuLocal.insertAllSync(list)

    override suspend fun getLocal(): List<MenuItem> = menuLocal.getAll()

}