package net.radityalabs.aredux.data.network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import com.google.gson.GsonBuilder
import com.google.gson.Gson
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import net.radityalabs.aredux.BuildConfig
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.Retrofit
import java.util.concurrent.TimeUnit


/**
 * Created by radityagumay on 7/22/17.
 */
object RestHelper {

    private val CONNECTION_TIMEOUT = (30 * 1000).toLong()
    private val READ_TIMEOUT = (30 * 1000).toLong()

    fun restService(): RestService {
        val retrofit = buildRetrofit()
        return retrofit.create(RestService::class.java)
    }

    private fun buildRetrofit(): Retrofit {
        return Retrofit.Builder()
                .baseUrl("https://www.google.com")
                .client(buildHttpClient())
                .addConverterFactory(GsonConverterFactory.create(buildGson()))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
    }

    private fun buildGson(): Gson {
        return GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
                .create()
    }

    private fun buildHttpClient(): OkHttpClient {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE
        val httpClient = OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .connectTimeout(CONNECTION_TIMEOUT, TimeUnit.MILLISECONDS)
                .readTimeout(READ_TIMEOUT, TimeUnit.MILLISECONDS)
        return httpClient.build()
    }
}