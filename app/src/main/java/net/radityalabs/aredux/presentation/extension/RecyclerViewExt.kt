package net.radityalabs.aredux.presentation.extension

import android.content.Context
import android.support.v7.widget.RecyclerView
import net.radityalabs.aredux.data.database.table.ChatObject
import net.radityalabs.aredux.presentation.ui.fragment.chat.ChatMessageType
import net.radityalabs.aredux.presentation.ui.fragment.chat.viewholder.ChatTextViewHolder
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import net.radityalabs.aredux.presentation.listener.OnLoadListener
import net.radityalabs.aredux.presentation.listener.OnLoadPreviousListener

/**
 * Created by radityagumay on 7/21/17.
 */

class RecyclerViewExt {
    companion object {
        val TAG = RecyclerViewExt::class.java.simpleName
    }
}

fun RecyclerView.loadPrevious(action: () -> Unit) {
    addOnScrollListener(OnLoadPreviousListener {
        Log.d(RecyclerViewExt.TAG, "loadPrevious")
        action.invoke()
        OnLoadPreviousListener.loading = false
    })
}

fun RecyclerView.listener(act1: () -> Unit, act2: () -> Unit) {
    addOnScrollListener(OnLoadListener({
        act1.invoke()
    }, {
        act2.invoke()
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