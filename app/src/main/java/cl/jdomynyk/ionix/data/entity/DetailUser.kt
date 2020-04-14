package cl.jdomynyk.ionix.data.entity

import com.google.gson.annotations.SerializedName

data class DetailUser(
    @SerializedName("email") private val email: String,
    @SerializedName("phone_number") private val phoneNumber: Int
)