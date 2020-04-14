package cl.jdomynyk.ionix.data.source.remote

import cl.jdomynyk.ionix.data.source.remote.response.MenuItemResponse
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET

interface MenuService {
    @GET
    fun getMenuAsync(): Deferred<Response<MenuItemResponse>>
}