package net.radityalabs.aredux

sealed class ChatAction {
    data class INIT(val chatScreen: ChatScreen,
                    val isKeyboardVisible: Boolean) : ChatAction()

    object BUTTON_PRESS_SENDING : ChatAction()
    object BUTTON_PRESS_BACK : ChatAction()
    object BUTTON_PICK_IMAGE : ChatAction()

    object CLEAR_STATE : ChatAction()

    data class BUTTON_PICK_MEDIA_RESULT(val chatPickImageResult: ChatPickImageResult,
                                        val reason: String?) : ChatAction()

    data class MESSAGE_STATUS_DELIVERY(val chatDeliveryType: ChatDeliveryType) : ChatAction()
}