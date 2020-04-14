package cl.jdomynyk.ionix.domain.repository

import cl.jdomynyk.ionix.data.entity.User
import cl.jdomynyk.ionix.domain.RemoteResult

interface SearchRepository {
    suspend fun search(rut: String): RemoteResult<List<User>>
}