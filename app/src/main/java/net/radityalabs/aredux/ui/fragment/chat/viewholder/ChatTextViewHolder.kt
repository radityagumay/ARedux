package net.radityalabs.aredux.ui.fragment.chat.viewholder

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import net.radityalabs.aredux.data.database.table.ChatObject
import net.radityalabs.aredux.R

/**
 * Created by radityagumay on 7/21/17.
 */

class ChatTextViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun bind(chat: ChatObject) {
        itemView.findViewById<TextView>(R.id.tv_chat_message).text = chat.message
    }
}