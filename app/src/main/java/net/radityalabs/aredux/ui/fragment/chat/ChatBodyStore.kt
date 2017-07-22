package net.radityalabs.aredux.ui.fragment.chat

import net.radityalabs.aredux.redux.base.Store
import net.radityalabs.aredux.redux.base.StoreDispatch

/**
 * Created by radityagumay on 7/22/17.
 */

class ChatBodyStore(private val transformer: ChatBodyStateTransformer) :
        Store<ChatBodyStateListener>,
        StoreDispatch<ChatBodyAction, ChatBodyState> {

    override fun updateState(action: ChatBodyAction) {
    }

    override fun dispatch(action: ChatBodyAction) {
    }

    override fun beforeDispatch(action: ChatBodyAction, oldState: ChatBodyState) {
    }

    override fun afterDispatch(action: ChatBodyAction, newState: ChatBodyState) {
    }

    override fun register(stateListener: ChatBodyStateListener) {
    }

    override fun unregister(stateListener: ChatBodyStateListener) {
    }
}