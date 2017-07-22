package net.radityalabs.aredux.ui.fragment.chat

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import net.radityalabs.aredux.R
import net.radityalabs.aredux.ui.fragment.BaseFragment
import kotlinx.android.synthetic.main.fragment_chat_body.*
import net.radityalabs.aredux.data.database.table.ChatObject
import net.radityalabs.aredux.extension.addedName
import net.radityalabs.aredux.extension.setup

/**
 * Created by radityagumay on 7/21/17.
 */

class ChatBodyFragment : BaseFragment() {
    companion object {
        val TAG = ChatBodyFragment::class.java.simpleName
    }

    private lateinit var chatAdapter: ChatAdapter

    private var chatList: MutableList<ChatObject> = mutableListOf()

    private val nested = arrayOf<Pair<String, Int>>(
            Pair(ChatBodyFooterFragment.TAG, R.id.chat_footer_container),
            Pair(ChatBodyMediaFragment.TAG, R.id.chat_media_container)
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
        initChildFragment()
    }

    private fun initView() {
        chatAdapter = ChatAdapter(chatList)
        chats.setup(chatAdapter)
    }

    private fun initChildFragment() {
        nested.forEach {
            val (name, layout) = it
            addChildFragment(layout, (Class.forName(addedName("chat.".plus(name))).newInstance() as Fragment))
        }
    }
}