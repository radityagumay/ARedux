package net.radityalabs.aredux.ui.fragment.chat

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import net.radityalabs.aredux.R
import net.radityalabs.aredux.data.database.table.ChatObject
import net.radityalabs.aredux.extension.transform
import net.radityalabs.aredux.ui.fragment.chat.viewholder.ChatTextViewHolder

/**
 * Created by radityagumay on 7/21/17.
 */

class ChatAdapter(private var items: List<ChatObject>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        holder.transform(items[position])
    }

    override fun getItemCount(): Int = if (items.isNotEmpty()) items.size else 0

    override fun getItemViewType(position: Int): Int {
        return viewType(items[position])
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        when (viewType.toLong()) {
            ChatMessageType.ME_TEXT -> {
                return ChatTextViewHolder(LayoutInflater
                        .from(parent.context)
                        .inflate(R.layout.fragment_chat_item_me_text, parent, false))
            }
            ChatMessageType.ME_VIDEO -> {
                return ChatTextViewHolder(LayoutInflater
                        .from(parent.context)
                        .inflate(R.layout.fragment_chat_item_me_text, parent, false))
            }
        }
        return ChatTextViewHolder(LayoutInflater
                .from(parent.context)
                .inflate(R.layout.fragment_chat_item_me_text, parent, false))
    }
}