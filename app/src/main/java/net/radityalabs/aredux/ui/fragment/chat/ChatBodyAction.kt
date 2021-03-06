package net.radityalabs.aredux.ui.fragment.chat

/**
 * Created by radityagumay on 7/22/17.
 */
sealed class ChatBodyAction {
    object INIT : ChatBodyAction()

    data class VIEW(val chatTask: ChatTask) : ChatBodyAction()
    data class SEND_MESSAGE(val chatTask: ChatTask,
                            val messageObject: MessageObject) : ChatBodyAction()

    data class ON_LOAD_MESSAGE(val userId: Int) : ChatBodyAction()
    data class ON_LOAD_MESSAGE_SUCCESS(val message: List<MessageObject>) : ChatBodyAction()
    data class ON_LOAD_MESSAGE_FAILURE(val error: Throwable) : ChatBodyAction()
}