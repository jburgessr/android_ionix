package cl.jdomynyk.ionix.data.source.local.menu

import androidx.room.*
import cl.jdomynyk.ionix.data.entity.MenuItem

@Dao
interface MenuDao {
    @Query("SELECT * FROM menu")
    suspend fun getAll(): List<MenuItem>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(entities: List<MenuItem>)

    @Query("DELETE FROM menu")
    suspend fun delete()
}