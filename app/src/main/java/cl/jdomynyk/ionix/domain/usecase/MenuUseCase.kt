package cl.jdomynyk.ionix.domain.usecase

import cl.jdomynyk.ionix.data.entity.MenuItem
import cl.jdomynyk.ionix.domain.RemoteResult
import cl.jdomynyk.ionix.domain.repository.MenuRepository

class MenuUseCase(private val repository: MenuRepository) {
    suspend fun getRemote(): RemoteResult<List<MenuItem>> = repository.getRemote()

    suspend fun getLocal(): List<MenuItem> = repository.getLocal()

    suspend fun insertAll(list: List<MenuItem>) = repository.insertAll(list)
}