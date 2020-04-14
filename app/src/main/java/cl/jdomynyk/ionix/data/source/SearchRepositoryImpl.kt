package cl.jdomynyk.ionix.data.source

import cl.jdomynyk.ionix.data.entity.User
import cl.jdomynyk.ionix.data.source.remote.SearchService
import cl.jdomynyk.ionix.domain.RemoteResult
import cl.jdomynyk.ionix.domain.repository.SearchRepository
import java.lang.NullPointerException

class SearchRepositoryImpl(
    private val searchService: SearchService
) : SearchRepository {
    override suspend fun search(rut: String): RemoteResult<List<User>> {
        try {
            val result = searchService.getUserDetailAsync(rut).await()
            if (result.isSuccessful) {
                val items = result.body()?.data
                return if (items != null)
                    RemoteResult.Success(items.list)
                else
                    RemoteResult.Exception(NullPointerException())
            }
            return RemoteResult.Error(result.code(), result.message())
        } catch (exception: Exception) {
            return RemoteResult.Exception(exception)
        }
    }

}