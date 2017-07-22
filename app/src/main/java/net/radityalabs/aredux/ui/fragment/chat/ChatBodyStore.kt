package net.radityalabs.aredux.ui.fragment.chat

import net.radityalabs.aredux.redux.base.Store
import net.radityalabs.aredux.redux.base.StoreDispatch

/**
 * Created by radityagumay on 7/22/17.
 */

class ChatBodyStore(private val transformer: ChatBodyStateTransformer) :
        Store<ChatBodyStateListener>,
        StoreDispatch<ChatBodyAction, ChatBodyState> {

    private val states: MutableList<ChatBodyStateListener> = mutableListOf()

    var state: ChatBodyState = ChatBodyState()
        private set

    override fun updateState(action: ChatBodyAction) {
    }

    override fun dispatch(action: ChatBodyAction) {
        states.forEach {
            it.onNewState(state)
        }
    }

    override fun beforeDispatch(action: ChatBodyAction, oldState: ChatBodyState) {
    }

    override fun afterDispatch(action: ChatBodyAction, newState: ChatBodyState) {
    }

    override fun register(stateListener: ChatBodyStateListener) {
        states.add(stateListener)
    }

    override fun unregister(stateListener: ChatBodyStateListener) {
        states.remove(stateListener)
    }
}