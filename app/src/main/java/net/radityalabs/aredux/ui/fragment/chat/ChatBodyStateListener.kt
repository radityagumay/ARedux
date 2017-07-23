package net.radityalabs.aredux.ui.fragment.chat

import net.radityalabs.aredux.redux.base.StateListener

/**
 * Created by radityagumay on 7/22/17.
 */

interface ChatBodyStateListener : StateListener {
    fun onStateChanges(state: ChatBodyState)
}