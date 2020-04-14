package cl.jdomynyk.ionix.data.source.remote.response

import com.google.gson.annotations.SerializedName

class BaseResponse<T>(
    @SerializedName("responseCode")
    val success: Int,
    @SerializedName("description")
    var message: String,
    @SerializedName("result")
    var data: T
)
