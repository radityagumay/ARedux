package net.radityalabs.aredux.data.network

import io.reactivex.Single
import net.radityalabs.aredux.ui.fragment.chat.MessageObject
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by radityagumay on 7/21/17.
 */

interface RestService {
    @GET
    fun onLoadMessage(@Query("id") userId: Int): Single<List<MessageObject>>
}