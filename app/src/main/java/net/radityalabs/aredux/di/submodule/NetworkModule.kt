package net.radityalabs.aredux.di.submodule;

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import net.radityalabs.aredux.BuildConfig
import net.radityalabs.aredux.data.network.RestService
import net.radityalabs.aredux.di.Module
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * Created by radityagumay on 7/22/17.
 */
class NetworkModule : Module() {
    override fun load() {
        provide(restService(), RestService::class.java)
    }

    private val CONNECTION_TIMEOUT = (30 * 1000).toLong()
    private val READ_TIMEOUT = (30 * 1000).toLong()

    private fun restService(): RestService {
        return buildRetrofit().create(RestService::class.java)
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
