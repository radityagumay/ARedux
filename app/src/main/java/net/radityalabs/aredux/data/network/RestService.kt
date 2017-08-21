package net.radityalabs.aredux.data.network

import io.reactivex.Single
import net.radityalabs.aredux.presentation.redux.login.Credential
import retrofit2.http.Body
import retrofit2.http.POST

interface RestService {
    @POST(ApiConstant.LOGIN)
    fun login(@Body credential: Credential): Single<Boolean>
}