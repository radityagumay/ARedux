package net.radityalabs.aredux.ui.fragment.chat

import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import net.radityalabs.aredux.R
import net.radityalabs.aredux.ui.fragment.BaseFragment
import kotlinx.android.synthetic.main.fragment_chat_body.*
import net.radityalabs.aredux.data.database.table.ChatObject
import net.radityalabs.aredux.di.Injector
import net.radityalabs.aredux.extension.addedName
import net.radityalabs.aredux.extension.loadPrevious
import net.radityalabs.aredux.extension.setup
import java.util.*
import android.R.id.edit
import android.content.Context.INPUT_METHOD_SERVICE
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit


/**
 * Created by radityagumay on 7/21/17.
 */

class ChatBodyFragment : BaseFragment(), ChatBodyStateListener {

    companion object {
        val TAG = ChatBodyFragment::class.java.simpleName
    }

    private lateinit var chatAdapter: ChatAdapter

    private var currentMediaFragment: Fragment? = null

    private val store: ChatBodyStore by lazy {
        Injector.get(ChatBodyStore::class.java)
    }

    private val actionCreator: ChatBodyActionCreator by lazy {
        Injector.get(ChatBodyActionCreator::class.java)
    }

    private var chatList: MutableList<ChatObject> = mutableListOf()

    private val nested = arrayOf<Pair<String, Int>>(
            Pair(ChatBodyFooterFragment.TAG, R.id.chat_footer_container)
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        actionCreator.submitAction(ChatBodyAction.INIT)
    }

    override fun onStart() {
        super.onStart()
        store.register(this)
    }

    override fun onStop() {
        super.onStop()
        store.unregister(this)
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.fragment_chat_body, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        initChildFragment()
    }

    override fun onStateChanges(state: ChatBodyState) {
        when (state.chatTask) {
            ChatTask.APPEND_NEW_MESSAGE -> {
                Log.d(TAG, state.messageObject?.text?.message)
                chatList.add(ChatObject(Random().nextInt(1000), state.messageObject?.messageType, state.messageObject?.text?.message))
                chats.scrollToPosition(chatAdapter.itemCount - 1)
                chatAdapter.notifyItemInserted(chatList.size - 1)
                actionCreator.submitAction(ChatBodyAction.VIEW(ChatTask.EMPTY_EDIT_TEXT))
            }
            ChatTask.SHOW_EMOTICON -> {
                actionCreator.submitAction(ChatBodyAction.VIEW(ChatTask.HIDE_KEYBOARD))
                Observable.timer(100, TimeUnit.MILLISECONDS, Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe {
                            chat_media_container.visibility = View.VISIBLE
                            currentMediaFragment = ChatBodyEmoticonFragment.newInstance()
                            addChildFragment(R.id.chat_media_container, currentMediaFragment as ChatBodyEmoticonFragment)
                        }
            }
            ChatTask.HIDE_MEDIA_BOTTOM -> {
                currentMediaFragment?.let {
                    (currentMediaFragment as ChatBodyEmoticonFragment).collapsedView()
                    chat_media_container.visibility = View.INVISIBLE
                }
            }
        }
    }

    private fun initView() {
        chatAdapter = ChatAdapter(chatList)
        setupRecycleView()
    }

    private fun setupRecycleView() {
        chats.setup(chatAdapter)
        chats.loadPrevious {}
    }

    private fun initChildFragment() {
        nested.forEach {
            val (name, layout) = it
            addChildFragment(layout, ((Class.forName(addedName("chat.".plus(name))).newInstance() as Fragment)))
        }
    }
}