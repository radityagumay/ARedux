package net.radityalabs.aredux.ui.fragment.chat

import android.os.Bundle
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import net.radityalabs.aredux.R
import net.radityalabs.aredux.ui.fragment.BaseFragment
import kotlinx.android.synthetic.main.fragment_chat_body.*
import net.radityalabs.aredux.extension.setup
import net.radityalabs.aredux.redux.store.store.ChatStore

/**
 * Created by radityagumay on 7/21/17.
 */

class ChatBodyFragment : BaseFragment() {
    companion object {
        val TAG = ChatBodyFragment::class.java.simpleName
    }

    private lateinit var chatAdapter: ChatAdapter

    private val nested = arrayOf<Pair<String, Int>>(
            Pair(ChatBodyFooterFragment.TAG, R.id.chat_toolbar_container),
            Pair(ChatBodyMediaFragment.TAG, R.id.chat_body_container)
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.fragment_chat_body, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    override fun onDestroyView() {
        super.onDestroyView()
    }

    override fun onDestroy() {
        super.onDestroy()
    }

    private fun initView() {
        chats.setup()
    }
}