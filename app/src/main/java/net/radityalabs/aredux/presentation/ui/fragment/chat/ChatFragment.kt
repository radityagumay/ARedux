package net.radityalabs.aredux.presentation.ui.fragment.chat

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import net.radityalabs.aredux.R
import net.radityalabs.aredux.di.Injector
import net.radityalabs.aredux.presentation.extension.addedName
import net.radityalabs.aredux.presentation.ui.fragment.BaseFragment

/**
 * Created by radityagumay on 7/21/17.
 */

class ChatFragment : BaseFragment(), ChatBodyStateListener {

    companion object {
        fun newInstance() = ChatFragment()
    }

    private var isMediaShown = false
    private var isKeyboardShown = false

    private val store: ChatBodyStore by lazy {
        Injector.get(ChatBodyStore::class.java)
    }

    private val actionCreator: ChatBodyActionCreator by lazy {
        Injector.get(ChatBodyActionCreator::class.java)
    }

    private val nested = arrayOf<Pair<String, Int>>(
            Pair(ChatToolbarFragment.TAG, R.id.chat_toolbar_container),
            Pair(ChatBodyFragment.TAG, R.id.chat_body_container)
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Injector.load(ChatBodyModule::class.java)
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.fragment_chat, container, false)
    }

    override fun onStart() {
        super.onStart()
        store.register(this)
    }

    override fun onStop() {
        super.onStop()
        store.unregister(this)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        nested.forEach {
            val (name, layout) = it
            addChildFragment(layout, (Class.forName(addedName("chat.".plus(name))).newInstance() as Fragment))
        }
    }

    override fun onStateChanges(state: ChatBodyState) {
        when (state.chatTask) {
            ChatTask.SHOW_EMOTICON -> {
                isMediaShown = true
            }

            ChatTask.HIDE_MEDIA_BOTTOM -> {
                isMediaShown = false
            }

            ChatTask.SHOW_KEYBOARD -> {
                isKeyboardShown = true
            }
        }
    }

    fun isKeyboardShown() = isKeyboardShown

    fun isMediaShown() = isMediaShown

    fun hideKeyboard() {
        actionCreator.submitAction(ChatBodyAction.VIEW(ChatTask.HIDE_KEYBOARD))
    }

    fun hideMedia() {
        actionCreator.submitAction(ChatBodyAction.VIEW(ChatTask.HIDE_MEDIA_BOTTOM))
    }
}