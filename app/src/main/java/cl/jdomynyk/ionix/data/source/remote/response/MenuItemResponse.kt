package cl.jdomynyk.ionix.data.source.remote.response

import cl.jdomynyk.ionix.data.entity.MenuItem
import com.google.gson.annotations.SerializedName

class MenuItemResponse(
    @SerializedName("menu") val list: List<MenuItem>
)