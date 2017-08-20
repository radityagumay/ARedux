package net.radityalabs.aredux.presentation.ui.fragment.chat

import net.radityalabs.aredux.presentation.redux.base.StateListener

/**
 * Created by radityagumay on 7/22/17.
 */

interface ChatBodyStateListener : StateListener {
    fun onStateChanges(state: ChatBodyState)
}