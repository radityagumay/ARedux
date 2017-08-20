package net.radityalabs.aredux.presentation.ui.fragment.chat

import io.reactivex.Single
import net.radityalabs.aredux.data.network.RestService
import net.radityalabs.aredux.di.Injector
import net.radityalabs.aredux.presentation.extension.singleNewThread

/**
 * Created by radityagumay on 7/25/17.
 */

class ChatBodyActionUseCase(
        private val service: RestService = Injector.get(RestService::class.java)) {

    fun onLoadMessage(userId: Int): Single<List<MessageObject>> {
        return service.onLoadMessage(userId).compose(singleNewThread())
    }
}