package net.radityalabs.aredux.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import net.radityalabs.aredux.R

/**
 * Created by radityagumay on 7/21/17.
 */

class ChatBodyFragment : BaseFragment(), IChildChatFragment {

    companion object {
        val TAG = ChatBodyFragment::class.java.simpleName

        fun newInstance() = ChatBodyFragment()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.fragment_chat_body, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onDestroyView() {
        super.onDestroyView()
    }

    override fun onDestroy() {
        super.onDestroy()
    }

    override fun add(layoutId: Int) {
        addChildFragment(layoutId, ChatBodyFragment.newInstance())
    }
}