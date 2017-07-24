package net.radityalabs.aredux.data.database.table

import net.radityalabs.aredux.extension.empty

/**
 * Created by radityagumay on 7/20/17.
 */

data class ChatObject(
        val chatId: Int,
        val messageType: Long?,
        val message: String? = empty(),
        val image: String? = empty(),
        val sticker: String? = empty(),
        val isMe: Boolean = false,
        val user: UserObject? = null
)
