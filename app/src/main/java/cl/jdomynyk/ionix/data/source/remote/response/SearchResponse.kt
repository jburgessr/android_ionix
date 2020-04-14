package cl.jdomynyk.ionix.data.source.remote.response

import cl.jdomynyk.ionix.data.entity.User
import com.google.gson.annotations.SerializedName

class SearchResponse(
    @SerializedName("items") val list: List<User>
)