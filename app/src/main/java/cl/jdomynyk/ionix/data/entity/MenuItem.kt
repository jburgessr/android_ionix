package cl.jdomynyk.ionix.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "menu")
data class MenuItem(
    @PrimaryKey
    @SerializedName("title") val name: String,
    @SerializedName("icon") val icon: String
)