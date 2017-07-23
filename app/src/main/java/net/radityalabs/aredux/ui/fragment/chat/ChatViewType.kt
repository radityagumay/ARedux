package net.radityalabs.aredux.ui.fragment.chat

import net.radityalabs.aredux.data.database.table.ChatObject

/**
 * Created by radityagumay on 7/21/17.
 */

fun ChatAdapter.viewType(chat: ChatObject): Int {
    if (chat.isMe) {
        if (chat.messageType == ChatMessageType.ME_TEXT) {
            return ChatMessageType.ME_TEXT.toInt()
        }
    }
    return ChatMessageType.ME_TEXT.toInt()
}