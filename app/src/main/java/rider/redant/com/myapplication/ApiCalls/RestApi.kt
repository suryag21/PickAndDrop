package rider.redant.com.myapplication.ApiCalls

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory


class RestApi {

    companion object {
        private val gson = GsonBuilder()
                .setLenient()
                .create()

        var retrofit: Retrofit? = null

        val BASE_URL:String = "https://otp.genfaremobile.com/"
        fun create(type: Int): APIInterface {
                retrofit = Retrofit.Builder()
                        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                        .addConverterFactory(GsonConverterFactory.create(gson))
                        .baseUrl(BASE_URL)
                        .build()


            return retrofit!!.create(APIInterface::class.java)
        }
    }
}