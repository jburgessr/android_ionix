package cl.jdomynyk.ionix.data.source.remote

import cl.jdomynyk.ionix.data.source.remote.response.BaseResponse
import cl.jdomynyk.ionix.data.source.remote.response.SearchResponse
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface SearchService {
    //https://sandbox.ionix.cl/test-tecnico/
    @GET("search")
    fun getUserDetailAsync(@Query("rut") rut: String): Deferred<Response<BaseResponse<SearchResponse>>>
}