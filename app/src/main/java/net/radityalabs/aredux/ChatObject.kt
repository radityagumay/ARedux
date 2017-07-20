package net.radityalabs.aredux

/**
 * Created by radityagumay on 7/20/17.
 */

data class ChatObject(
        val chatId: Int,
        val messageType: ChatMessageType,
        val message: String,
        val image: String,
        val sticker: String,
        val user: UserObject
)
