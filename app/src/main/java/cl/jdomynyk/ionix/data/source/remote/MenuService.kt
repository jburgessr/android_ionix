package cl.jdomynyk.ionix.data.source.remote

import cl.jdomynyk.ionix.data.source.remote.response.MenuItemResponse
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET

interface MenuService {
    @GET("ionix_android/-/raw/master/json/json_menu.json")
    fun getMenuAsync(): Deferred<Response<MenuItemResponse>>
}