package cl.jdomynyk.ionix.data.entity

import com.google.gson.annotations.SerializedName

data class User(
    @SerializedName("name") val name: String,
    @SerializedName("detail") val detail: DetailUser
)