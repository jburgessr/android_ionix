package cl.jdomynyk.ionix.data.entity

import com.google.gson.annotations.SerializedName

data class User(
    @SerializedName("name") private val name: String,
    @SerializedName("detail") private val detail: DetailUser
)