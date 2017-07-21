package net.radityalabs.aredux.redux.state.chat

import net.radityalabs.aredux.redux.base.StateListener

/**
 * Created by radityagumay on 7/20/17.
 */
interface ChatStateListener : StateListener {
    fun onNewState(state: ChatState)
}