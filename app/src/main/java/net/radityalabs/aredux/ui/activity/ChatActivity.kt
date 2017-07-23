package net.radityalabs.aredux.ui.activity

import android.os.Bundle
import android.support.v4.app.Fragment
import net.radityalabs.aredux.*
import net.radityalabs.aredux.ui.fragment.chat.ChatFragment

class ChatActivity : BaseActivity() {

    private var fragment: Fragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat)
    }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        fragment = ChatFragment.newInstance()
        addFragment(R.id.container, fragment as ChatFragment)
    }

    override fun onBackPressed() {
        val cFragment = fragment as ChatFragment
        if (cFragment.isMediaShown()) {
            cFragment.hideMedia()
            return
        }
        if (cFragment.isKeyboardShown()) {
            cFragment.hideKeyboard()
            return
        }

        super.onBackPressed()
        finish()
    }
}
