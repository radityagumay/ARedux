package net.radityalabs.aredux.redux

import net.radityalabs.aredux.redux.action.chat.ChatAction
import net.radityalabs.aredux.redux.state.chat.ChatState

interface MiddleWare {
    fun doBeforeNewState(action: ChatAction, oldState: ChatState)
    fun doAfterNewState(action: ChatAction, oldState: ChatState)
}
