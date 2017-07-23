package net.radityalabs.aredux.ui.fragment.chat

import android.content.Context
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import kotlinx.android.synthetic.main.fragment_chat_body_footer.*
import kotlinx.android.synthetic.main.view_chat_footer_edittext_icon.view.*
import net.radityalabs.aredux.R
import net.radityalabs.aredux.di.Injector
import net.radityalabs.aredux.extension.empty
import net.radityalabs.aredux.ui.fragment.BaseFragment

/**
 * Created by radityagumay on 7/21/17.
 */

class ChatBodyFooterFragment : BaseFragment(), TextWatcher,
        ChatBodyStateListener, View.OnFocusChangeListener {

    companion object {
        val TAG = ChatBodyFooterFragment::class.java.simpleName
    }

    private var typeMessage: String = empty()

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
        return inflater?.inflate(R.layout.fragment_chat_body_footer, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    override fun afterTextChanged(p0: Editable?) {
    }

    override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
    }

    override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
        typeMessage = p0.toString()
    }

    override fun onStateChanges(state: ChatBodyState) {
        when (state.chatTask) {
            ChatTask.EMPTY_EDIT_TEXT -> {
                typeMessage = empty()
                message.etMessage.text.clear()
            }

            ChatTask.HIDE_KEYBOARD -> {
                message.etMessage.clearFocus()
                val inputmanager = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                inputmanager.hideSoftInputFromWindow(message.etMessage.windowToken, 0)
            }
        }
    }

    override fun onStart() {
        super.onStart()
        store.register(this)
    }

    override fun onStop() {
        super.onStop()
        store.unregister(this)
    }

    override fun onFocusChange(view: View?, p1: Boolean) {
        actionCreator.submitAction(ChatBodyAction.VIEW(ChatTask.HIDE_EMOTICON))
    }

    private fun initView() {
        with(message) {
            etMessage.addTextChangedListener(this@ChatBodyFooterFragment)
            etMessage.onFocusChangeListener = this@ChatBodyFooterFragment
            ivSend.setOnClickListener(setOnClickListener(R.id.ivSend))
            ivEmoticon.setOnClickListener(setOnClickListener(R.id.ivEmoticon))
        }
    }

    private fun setOnClickListener(resId: Int): View.OnClickListener {
        return View.OnClickListener {
            when (resId) {
                R.id.ivSend -> {
                    actionCreator.submitAction(ChatBodyAction.SEND_MESSAGE(ChatTask.APPEND_NEW_MESSAGE, MessageObject(ChatMessageType.ME_TEXT, MessageTypeText(typeMessage))))
                }

                R.id.ivEmoticon -> {
                    actionCreator.submitAction(ChatBodyAction.VIEW(ChatTask.SHOW_EMOTICON))
                }
            }
        }
    }
}

data class MessageObject(
        val messageType: Long,
        val text: MessageTypeText? = null,
        val image: MessageTypeImage? = null,
        val video: MessageTypeVideo? = null
)

data class MessageTypeText(
        val message: String
)

data class MessageTypeImage(
        val imageUrl: String
)

data class MessageTypeVideo(
        val videoUrl: String,
        val videoThumbnailUrl: String
)