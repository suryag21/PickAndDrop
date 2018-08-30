package rider.redant.com.myapplication.ApiCalls


import com.google.gson.JsonObject
import retrofit2.Call

import retrofit2.http.GET
import retrofit2.http.Query

interface APIInterface {

    @GET("otp")
    fun checkServer(): Call<JsonObject>

}