package net.radityalabs.aredux.presentation.ui.fragment.chat

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import net.radityalabs.aredux.R
import net.radityalabs.aredux.di.Injector
import net.radityalabs.aredux.presentation.ui.fragment.BaseFragment
import android.support.design.widget.BottomSheetBehavior
import android.widget.LinearLayout
import kotlinx.android.synthetic.main.fragment_chat_body_emoticon.*

/**
 * Created by radityagumay on 7/21/17.
 */

class ChatBodyEmoticonFragment : BaseFragment() {
    companion object {
        val TAG = ChatBodyEmoticonFragment::class.java.simpleName

        fun newInstance() = ChatBodyEmoticonFragment()
    }

    private var bottomSheetBehavior: BottomSheetBehavior<*>? = null

    private val store: ChatBodyStore by lazy {
        Injector.get(ChatBodyStore::class.java)
    }

    private val actionCreator: ChatBodyActionCreator by lazy {
        Injector.get(ChatBodyActionCreator::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.fragment_chat_body_emoticon, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        main_content.visibility = View.VISIBLE
        bottomSheetBehavior = BottomSheetBehavior.from(view?.findViewById<LinearLayout>(R.id.bottom_sheet))
        bottomSheetBehavior?.state = BottomSheetBehavior.STATE_EXPANDED
    }

    fun collapsedView() {
        bottomSheetBehavior?.state = BottomSheetBehavior.STATE_COLLAPSED
        main_content.visibility = View.GONE
    }
}