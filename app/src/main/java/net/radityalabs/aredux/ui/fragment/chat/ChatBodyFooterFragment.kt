package net.radityalabs.aredux.ui.fragment.chat

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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
        ChatBodyStateListener, View.OnClickListener {

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
        Log.d(TAG, "onStateChanges")
    }

    override fun onClick(view: View?) {
        actionCreator.submitAction(ChatBodyAction.SEND_MESSAGE(MessageObject(ChatMessageType.TEXT, MessageTypeText(typeMessage))))
    }

    override fun onStart() {
        super.onStart()
        store.register(this)
    }

    override fun onStop() {
        super.onStop()
        store.unregister(this)
    }

    private fun initView() {
        with(message) {
            etMessage.addTextChangedListener(this@ChatBodyFooterFragment)
            ivSend.setOnClickListener(this@ChatBodyFooterFragment)
        }
    }
}

data class MessageObject(
        val messageType: ChatMessageType? = null,
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