package net.radityalabs.aredux.ui.activity

import android.os.Bundle
import net.radityalabs.aredux.R
import net.radityalabs.aredux.ui.fragment.LoginFragment

class LoginActivity : BaseActivity() {
    companion object {
        val TAG = LoginActivity::class.java.simpleName
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        addFragment(R.id.container, LoginFragment.newInstance())
    }
}