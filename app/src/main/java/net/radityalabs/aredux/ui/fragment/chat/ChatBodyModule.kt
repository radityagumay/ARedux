package net.radityalabs.aredux.ui.fragment.chat

import net.radityalabs.aredux.data.network.RestHelper
import net.radityalabs.aredux.data.network.RestService
import net.radityalabs.aredux.di.Injector
import net.radityalabs.aredux.di.Module

/**
 * Created by radityagumay on 7/22/17.
 */
object ChatBodyModule : Module() {

    override fun load() {
        val store: ChatBodyStore = store()
        val service: RestService = Injector.get(RestService::class.java)
        provide(store, ChatBodyStore::class.java)
        provide(actionCreator(service, store), ChatBodyActionCreator::class.java)
    }

    private fun store(): ChatBodyStore {
        return ChatBodyStore(ChatBodyStateTransformer())
    }

    private fun actionCreator(service: RestService,
                              store: ChatBodyStore): ChatBodyActionCreator {
        return ChatBodyActionCreator(service, store)
    }
}