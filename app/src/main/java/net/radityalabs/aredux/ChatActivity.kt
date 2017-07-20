package net.radityalabs.aredux

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem

import kotlinx.android.synthetic.main.activity_main.*

class ChatActivity : AppCompatActivity(), ChatStateListener {

    private lateinit var store: ChatStore
    private lateinit var action: ChatActionCreator

    private var middleware: MutableList<MiddleWare> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initView()
        initMiddleWare()
        initInstance()
    }

    private fun initMiddleWare() {
        middleware.add(LoggerMiddleWare())
    }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
    }

    override fun onStart() {
        super.onStart()
        store.register(this)
    }

    override fun onStop() {
        super.onStop()
        store.unregister(this)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onNewState(state: ChatState) {

    }

    private fun initView() {
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

    }

    private fun initInstance() {
        store = ChatStore(ChatStateTransform(), middleware)
        action = ChatActionCreator()
    }
}
