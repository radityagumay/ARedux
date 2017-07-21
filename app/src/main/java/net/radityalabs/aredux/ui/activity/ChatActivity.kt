package net.radityalabs.aredux.ui.activity

import android.os.Bundle
import kotlinx.android.synthetic.main.activity_chat.*
import net.radityalabs.aredux.*
import net.radityalabs.aredux.ui.fragment.ChatFragment

class ChatActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initView()
    }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        addFragment(R.id.container, ChatFragment.newInstance())
    }

    private fun initView() {
        setContentView(R.layout.activity_chat)
        setSupportActionBar(toolbar)
    }
}
