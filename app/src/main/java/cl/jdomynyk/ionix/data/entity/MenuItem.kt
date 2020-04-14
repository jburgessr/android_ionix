package cl.jdomynyk.ionix.data.entity

import com.google.gson.annotations.SerializedName

data class MenuItem(
    @SerializedName("title") private val title: String,
    @SerializedName("icon") private val icon: String
)