package net.radityalabs.aredux.extension

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.View
import net.radityalabs.aredux.data.database.table.ChatObject
import net.radityalabs.aredux.ui.fragment.chat.ChatMessageType
import net.radityalabs.aredux.ui.fragment.chat.viewholder.ChatTextViewHolder
import android.support.v7.widget.LinearLayoutManager
import net.radityalabs.aredux.listener.OnLoadPreviousListener

/**
 * Created by radityagumay on 7/21/17.
 */

fun RecyclerView.loadPrevious(action: () -> Unit) {
    addOnScrollListener(OnLoadPreviousListener(object : OnLoadPreviousListener.Callback {
        override fun onLoadPrevious() {
            action.invoke()
        }
    }))
}

fun RecyclerView.setup(adapter: RecyclerView.Adapter<RecyclerView.ViewHolder>): RecyclerView {
    return apply {
        setHasFixedSize(true)
        setAdapter(adapter)
        layoutManager = linearLayoutManager(context)
    }
}


fun RecyclerView.ViewHolder.transform(chat: ChatObject) {
    when (chat.messageType) {
        ChatMessageType.ME_TEXT -> {
            if (this is ChatTextViewHolder) {
                bind(chat)
            }
        }
    }
}

fun RecyclerView.linearLayoutManager(context: Context): LinearLayoutManager {
    val linearLayoutManager = LinearLayoutManager(context)
    linearLayoutManager.reverseLayout = false
    linearLayoutManager.stackFromEnd = true
    return linearLayoutManager
}