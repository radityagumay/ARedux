package net.radityalabs.aredux.extension

import android.support.v7.widget.RecyclerView
import android.view.View
import net.radityalabs.aredux.data.database.table.ChatObject
import net.radityalabs.aredux.ui.fragment.chat.ChatMessageType
import net.radityalabs.aredux.ui.fragment.chat.viewholder.ChatTextViewHolder

/**
 * Created by radityagumay on 7/21/17.
 */

fun RecyclerView.setup(): RecyclerView {
    return apply {

    }
}

fun RecyclerView.ViewHolder.transform(itemView: View, chat: ChatObject) {
    when (chat.messageType) {
        ChatMessageType.TEXT -> {
            if (this is ChatTextViewHolder) {
                bind()
            }
        }
    }
}