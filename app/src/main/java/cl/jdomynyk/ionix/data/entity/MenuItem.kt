package cl.jdomynyk.ionix.data.entity

import androidx.room.Entity
import com.google.gson.annotations.SerializedName

@Entity(tableName = "menu")
data class MenuItem(
    @SerializedName("title") val name: String,
    @SerializedName("icon") val icon: String
)