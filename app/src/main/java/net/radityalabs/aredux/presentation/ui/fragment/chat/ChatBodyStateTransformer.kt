package net.radityalabs.aredux.presentation.ui.fragment.chat

/**
 * Created by radityagumay on 7/22/17.
 */

class ChatBodyStateTransformer {
    fun transform(oldState: ChatBodyState, action: ChatBodyAction): ChatBodyState {
        when (action) {
            is ChatBodyAction.VIEW -> return oldState.copy(chatTask = action.chatTask)
            is ChatBodyAction.SEND_MESSAGE -> return oldState.copy(chatTask = action.chatTask, messageObject = action.messageObject)
        }
        return oldState.copy(messageObject = null)
    }
}