package net.radityalabs.aredux.ui.fragment.chat

import android.util.Log
import net.radityalabs.aredux.data.network.RestService
import net.radityalabs.aredux.di.Injector

/**
 * Created by radityagumay on 7/22/17.
 */

class ChatBodyActionCreator(
        private val service: RestService = Injector.get(RestService::class.java),
        private val store: ChatBodyStore = Injector.get(ChatBodyStore::class.java)) {

    fun create(action: ChatBodyAction) {
        Log.d("", "")
    }
}