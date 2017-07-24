package net.radityalabs.aredux.ui.fragment.chat

import net.radityalabs.aredux.data.network.RestService
import net.radityalabs.aredux.di.Injector
import net.radityalabs.aredux.di.Module

/**
 * Created by radityagumay on 7/22/17.
 */
class ChatBodyModule : Module() {

    override fun load() {
        val store: ChatBodyStore = store()
        val service: RestService = Injector.get(RestService::class.java)
        val usecase: ChatBodyActionUseCase = ChatBodyActionUseCase(service)

        provide(store, ChatBodyStore::class.java)
        provide(actionUseCase(service), ChatBodyActionUseCase::class.java)
        provide(actionCreator(usecase, store), ChatBodyActionCreator::class.java)
    }

    private fun store(): ChatBodyStore =
            ChatBodyStore(ChatBodyStateTransformer())

    private fun actionCreator(usecase: ChatBodyActionUseCase,
                              store: ChatBodyStore): ChatBodyActionCreator =
            ChatBodyActionCreator(usecase, store)

    private fun actionUseCase(service: RestService) =
            ChatBodyActionUseCase(service)
}