package net.radityalabs.aredux.ui.fragment.chat

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import net.radityalabs.aredux.R
import net.radityalabs.aredux.extension.addedName
import net.radityalabs.aredux.ui.fragment.BaseFragment

/**
 * Created by radityagumay on 7/21/17.
 */

class ChatFragment : BaseFragment() {
    companion object {
        fun newInstance() = ChatFragment()
    }

    private val nested = arrayOf<Pair<String, Int>>(
            Pair(ChatToolbarFragment.TAG, R.id.chat_toolbar_container),
            Pair(ChatBodyFragment.TAG, R.id.chat_body_container)
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.fragment_chat, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        nested.forEach {
            val (name, layout) = it
            addChildFragment(layout, (Class.forName(addedName("chat.".plus(name))).newInstance() as Fragment))
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}