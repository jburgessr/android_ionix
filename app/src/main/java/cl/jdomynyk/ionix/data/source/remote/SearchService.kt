package cl.jdomynyk.ionix.data.source.remote

import cl.jdomynyk.ionix.data.source.remote.response.BaseResponse
import cl.jdomynyk.ionix.data.source.remote.response.SearchResponse
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface SearchService {
    //@Headers("Content-Type: application/json")
    @GET("search")
    fun getUserDetailAsync(@Query("rut") rut: String): Deferred<Response<BaseResponse<SearchResponse>>>
}