package net.radityalabs.aredux

/**
 * Created by radityagumay on 7/20/17.
 */
interface ChatStateListener : StateListener {
    fun onNewState(state: ChatState)
}