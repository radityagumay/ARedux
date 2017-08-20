package net.radityalabs.aredux.presentation.di.module

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import dagger.Module
import dagger.Provides
import net.radityalabs.aredux.BuildConfig
import net.radityalabs.aredux.data.network.ApiConstant
import net.radityalabs.aredux.data.network.RestService
import net.radityalabs.aredux.presentation.di.qualifier.DefaultUrl
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
class NetworkModule {
    @Singleton
    @Provides
    fun provideRetrofitBuilder(): Retrofit.Builder = Retrofit.Builder()

    @Singleton
    @Provides
    fun provideOkHttpBuilder(): OkHttpClient.Builder = OkHttpClient.Builder()

    @Singleton
    @Provides
    @DefaultUrl
    fun provideRetrofit(builder: Retrofit.Builder, client: OkHttpClient): Retrofit {
        return builder.baseUrl(ApiConstant.BASE_URL)
                .client(client)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
    }

    @Singleton
    @Provides
    fun provideClient(builder: OkHttpClient.Builder): OkHttpClient {
        if (BuildConfig.DEBUG) {
            val loggingInterceptor = HttpLoggingInterceptor()
            loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
            builder.addInterceptor(loggingInterceptor)
        }
        builder.connectTimeout(ApiConstant.CONNECTION_TIMEOUT, TimeUnit.SECONDS)
        builder.readTimeout(ApiConstant.READ_TIMEOUT, TimeUnit.SECONDS)
        builder.writeTimeout(ApiConstant.WRITE_TIMEOUT, TimeUnit.SECONDS)
        builder.retryOnConnectionFailure(true)
        return builder.build()
    }

    @Singleton
    @Provides
    fun provideRestService(@DefaultUrl retrofit: Retrofit) =
            retrofit.create<RestService>(RestService::class.java)
}