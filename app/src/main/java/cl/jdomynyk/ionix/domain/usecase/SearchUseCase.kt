package cl.jdomynyk.ionix.domain.usecase

import cl.jdomynyk.ionix.data.entity.User
import cl.jdomynyk.ionix.domain.RemoteResult
import cl.jdomynyk.ionix.domain.repository.SearchRepository

class SearchUseCase(private val repository: SearchRepository) {
    suspend fun search(rut: String): RemoteResult<List<User>> {
        return repository.search(rut)
    }
}