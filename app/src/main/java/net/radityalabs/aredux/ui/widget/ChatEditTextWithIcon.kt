package net.radityalabs.aredux.ui.widget

import android.content.Context
import android.support.v7.widget.AppCompatEditText
import android.util.AttributeSet
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import android.widget.RelativeLayout
import net.radityalabs.aredux.R

/**
 * Created by radityagumay on 7/22/17.
 */

class ChatEditTextWithIcon : RelativeLayout {

    private lateinit var imageView: ImageView
    private lateinit var editText: EditText

    constructor(context: Context) : super(context) {
        init()
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        init()
    }

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        init()
    }

    private fun init() {
        inflate(context, R.layout.view_chat_footer_edittext_icon, this)
    }
}
