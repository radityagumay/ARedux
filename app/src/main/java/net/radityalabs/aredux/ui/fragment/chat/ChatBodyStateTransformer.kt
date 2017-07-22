package net.radityalabs.aredux.ui.fragment.chat

/**
 * Created by radityagumay on 7/22/17.
 */

class ChatBodyStateTransformer {
    fun transform(oldState: ChatBodyState, action: ChatBodyAction): ChatBodyState {
        when (action) {
            is ChatBodyAction.SEND_MESSAGE -> {
                return oldState.copy(messageObject = action.messageObject)
            }
        }
        return oldState.copy(messageObject = null)
    }
}