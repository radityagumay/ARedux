package net.radityalabs.aredux.ui.fragment.chat

import net.radityalabs.aredux.di.Injector

/**
 * Created by radityagumay on 7/22/17.
 */

class ChatBodyActionCreator(
        private val useCase: ChatBodyActionUseCase = Injector.get(ChatBodyActionUseCase::class.java),
        private val store: ChatBodyStore = Injector.get(ChatBodyStore::class.java)) {

    fun submitAction(action: ChatBodyAction) {
        when (action) {
            ChatBodyAction.INIT -> store.dispatch(action)
            is ChatBodyAction.VIEW -> store.dispatch(action)
            is ChatBodyAction.SEND_MESSAGE -> store.dispatch(action)
            is ChatBodyAction.ON_LOAD_MESSAGE -> {
                useCase.onLoadMessage(action.userId)
                        .subscribe({
                            success ->
                            store.dispatch(ChatBodyAction.ON_LOAD_MESSAGE_SUCCESS(success))
                        }, { error ->
                            store.dispatch(ChatBodyAction.ON_LOAD_MESSAGE_FAILURE(error))
                        })
            }
        }
    }
}