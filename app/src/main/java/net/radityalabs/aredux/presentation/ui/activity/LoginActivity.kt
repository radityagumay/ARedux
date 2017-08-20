package net.radityalabs.aredux.presentation.ui.activity

import android.os.Bundle
import net.radityalabs.aredux.R
import net.radityalabs.aredux.presentation.ui.fragment.LoginFragment

class LoginActivity : BaseActivity() {
    companion object {
        val TAG = LoginActivity::class.java.simpleName
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        addFragment(R.id.login_container, LoginFragment.newInstance())
    }
}