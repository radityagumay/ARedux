package net.radityalabs.aredux.ui.fragment.chat

/**
 * Created by radityagumay on 7/22/17.
 */
sealed class ChatBodyAction {
    object INIT : ChatBodyAction()
    data class SEND_MESSAGE(val messageObject: MessageObject) : ChatBodyAction()
}