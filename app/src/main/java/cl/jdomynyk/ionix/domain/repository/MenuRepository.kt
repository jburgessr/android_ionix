package cl.jdomynyk.ionix.domain.repository

import cl.jdomynyk.ionix.data.entity.MenuItem
import cl.jdomynyk.ionix.domain.RemoteResult

interface MenuRepository {
    suspend fun getRemote(): RemoteResult<List<MenuItem>>
    suspend fun insertAll(list: List<MenuItem>)
    suspend fun getLocal(): List<MenuItem>
    suspend fun delete()
}