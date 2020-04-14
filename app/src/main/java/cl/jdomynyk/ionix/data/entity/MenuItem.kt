package cl.jdomynyk.ionix.data.entity

import com.google.gson.annotations.SerializedName

data class MenuItem(
    @SerializedName("title") val title: String,
    @SerializedName("icon") val icon: String
)