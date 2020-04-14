package cl.jdomynyk.ionix.data.entity

import com.google.gson.annotations.SerializedName

data class DetailUser(
    @SerializedName("email") val email: String,
    @SerializedName("phone_number") val phoneNumber: Int
)