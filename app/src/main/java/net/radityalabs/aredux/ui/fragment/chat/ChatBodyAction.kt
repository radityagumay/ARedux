package net.radityalabs.aredux.ui.fragment.chat

/**
 * Created by radityagumay on 7/22/17.
 */
sealed class ChatBodyAction {
    object INIT : ChatBodyAction()

    data class HIDE_KEYBOARD(val chatTask: ChatTask) : ChatBodyAction()
    data class HIDE_EMOTICON(val chatTask: ChatTask) : ChatBodyAction()
    data class SHOW_EMOTICON(val chatTask: ChatTask) : ChatBodyAction()
    data class EMPTY_EDIT_TEXT(val chatTask: ChatTask) : ChatBodyAction()
    data class SEND_MESSAGE(val chatTask: ChatTask,
                            val messageObject: MessageObject) : ChatBodyAction()
}