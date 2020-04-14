package cl.jdomynyk.ionix.data.source.remote.response

import com.google.gson.annotations.SerializedName

class BaseResponse<T> {
    @SerializedName("responseCode")
    var success: Int? = null

    @SerializedName("description")
    var message: String? = null

    @SerializedName("result")
    var data: T? = null
        private set

    override fun toString(): String {
        return "BaseResponse{" +
                "success=" + success +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}'
    }

    fun setData(data: T) {
        this.data = data
    }
}