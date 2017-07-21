package net.radityalabs.aredux.ui.activity

import android.os.Bundle
import net.radityalabs.aredux.*
import net.radityalabs.aredux.ui.fragment.chat.ChatFragment

class ChatActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat)
    }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        addFragment(R.id.container, ChatFragment.newInstance())
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }
}
