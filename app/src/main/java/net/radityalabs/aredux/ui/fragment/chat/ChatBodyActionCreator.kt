package net.radityalabs.aredux.ui.fragment.chat

import net.radityalabs.aredux.data.network.RestService
import net.radityalabs.aredux.di.Injector

/**
 * Created by radityagumay on 7/22/17.
 */

class ChatBodyActionCreator(
        private val service: RestService = Injector.get(RestService::class.java),
        private val store: ChatBodyStore = Injector.get(ChatBodyStore::class.java)) {

    fun submitAction(action: ChatBodyAction) {
        when (action) {
            ChatBodyAction.INIT -> store.dispatch(action)
            ChatBodyAction.SEND_MESSAGE -> store.dispatch(action)
        }
    }
}