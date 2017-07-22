package net.radityalabs.aredux.ui.fragment.chat

import net.radityalabs.aredux.data.network.RestHelper
import net.radityalabs.aredux.data.network.RestService
import net.radityalabs.aredux.di.Module

/**
 * Created by radityagumay on 7/22/17.
 */
class ChatBodyModule : Module() {

    override fun load() {
        val store: ChatBodyStore = store()

        provide(store, ChatBodyStore::class.java)
        provide(actionCreator(RestHelper.restService(), store), ChatBodyActionCreator::class.java)
    }

    private fun store(): ChatBodyStore {
        return ChatBodyStore(ChatBodyStateTransformer())
    }

    private fun actionCreator(service: RestService,
                              store: ChatBodyStore): ChatBodyActionCreator {
        return ChatBodyActionCreator(service, store)
    }
}