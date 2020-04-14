package cl.jdomynyk.ionix.data.source.local

import androidx.room.Database
import androidx.room.RoomDatabase
import cl.jdomynyk.ionix.data.entity.MenuItem
import cl.jdomynyk.ionix.data.source.local.menu.MenuDao

@Database(
    entities = [MenuItem::class],
    version = 1, exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun getMenuDao(): MenuDao
}