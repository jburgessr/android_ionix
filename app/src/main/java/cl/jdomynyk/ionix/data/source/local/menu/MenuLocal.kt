package cl.jdomynyk.ionix.data.source.local.menu

import cl.jdomynyk.ionix.data.entity.MenuItem

interface MenuLocal {
    suspend fun insertAllSync(list: List<MenuItem>)
    suspend fun getAll(): List<MenuItem>
    suspend fun delete()
}