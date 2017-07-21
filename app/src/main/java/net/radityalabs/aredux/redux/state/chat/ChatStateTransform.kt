package net.radityalabs.aredux.redux.state.chat

import net.radityalabs.aredux.redux.action.chat.ChatAction

class ChatStateTransform {

    fun transform(oldState: ChatState, action: ChatAction): ChatState {
        return ChatState()
    }
}