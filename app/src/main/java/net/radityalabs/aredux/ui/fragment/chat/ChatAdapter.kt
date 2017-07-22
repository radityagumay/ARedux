package net.radityalabs.aredux.ui.fragment.chat

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import net.radityalabs.aredux.R
import net.radityalabs.aredux.data.database.table.ChatObject
import net.radityalabs.aredux.extension.transform
import net.radityalabs.aredux.ui.fragment.chat.viewholder.ChatTextViewHolder
import net.radityalabs.aredux.ui.fragment.chat.viewholder.ChatViewHolder

/**
 * Created by radityagumay on 7/21/17.
 */

class ChatAdapter(private var items: List<ChatObject>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private lateinit var itemView: View

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = items[position]
        holder.transform(itemView, item)
    }

    override fun getItemCount(): Int = if (items.isNotEmpty()) items.size else 0

    override fun getItemViewType(position: Int): Int {
        return viewType(items[position])
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChatViewHolder {
        itemView = LayoutInflater.from(parent.context).inflate(R.layout.fragment_chat_list_item, parent, false)
        return ChatViewHolder(itemView)
    }
}