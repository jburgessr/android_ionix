package cl.jdomynyk.ionix.data.source.local.menu

import cl.jdomynyk.ionix.data.entity.MenuItem

class MenuLocalImpl(private val menuDao: MenuDao) :
    MenuLocal {
    override suspend fun insertAllSync(list: List<MenuItem>) = menuDao.insertAll(list)
    override suspend fun getAll(): List<MenuItem> = menuDao.getAll()
    override suspend fun delete() = menuDao.delete()
}