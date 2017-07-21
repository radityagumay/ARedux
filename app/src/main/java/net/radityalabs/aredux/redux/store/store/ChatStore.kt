package net.radityalabs.aredux.redux.store.store

import net.radityalabs.aredux.App
import net.radityalabs.aredux.redux.MiddleWare
import net.radityalabs.aredux.redux.base.Store
import net.radityalabs.aredux.redux.base.StoreDispatch
import net.radityalabs.aredux.redux.action.chat.ChatAction
import net.radityalabs.aredux.redux.state.chat.ChatState
import net.radityalabs.aredux.redux.state.chat.ChatStateListener
import net.radityalabs.aredux.redux.state.chat.ChatStateTransform

class ChatStore(private val stateTransform: ChatStateTransform,
                private val middleware: List<MiddleWare>) :
        Store<ChatStateListener>,
        StoreDispatch<ChatAction, ChatState> {

    private var state: ChatState = ChatState()

    override fun register(stateListener: ChatStateListener) {
        App.addState(stateListener.javaClass)
    }

    override fun unregister(stateListener: ChatStateListener) {
        App.removeState(stateListener.javaClass)
    }

    override fun updateState(action: ChatAction) {
        state = stateTransform.transform(state, action)
        for (item in App.getStateListener(ChatStateListener::class.java)) {
            (item as ChatStateListener).onNewState(state)
        }
    }

    override fun dispatch(action: ChatAction) {
        beforeDispatch(action, state)

        updateState(action)

        afterDispatch(action, state)
    }

    override fun beforeDispatch(action: ChatAction, oldState: ChatState) {

    }

    override fun afterDispatch(action: ChatAction, newState: ChatState) {
    }
}