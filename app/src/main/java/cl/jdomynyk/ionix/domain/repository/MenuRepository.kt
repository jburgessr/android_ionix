package cl.jdomynyk.ionix.domain.repository

import cl.jdomynyk.ionix.data.entity.MenuItem
import cl.jdomynyk.ionix.domain.RemoteResult

interface MenuRepository {
    suspend fun getMenu(): RemoteResult<List<MenuItem>>
}