package cl.jdomynyk.ionix.domain.usecase

import cl.jdomynyk.ionix.data.entity.MenuItem
import cl.jdomynyk.ionix.domain.RemoteResult
import cl.jdomynyk.ionix.domain.repository.MenuRepository

class MenuUseCase(private val repository: MenuRepository) {
    suspend fun getMenu(): RemoteResult<List<MenuItem>> {
        return repository.getMenu()
    }
}