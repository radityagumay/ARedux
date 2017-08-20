package net.radityalabs.aredux.presentation.ui.fragment

import net.radityalabs.aredux.R
import net.radityalabs.aredux.presentation.di.module.LoginModule

class LoginFragment : BaseFragment() {
    companion object {
        val TAG = LoginFragment::class.java.simpleName
        fun newInstance() = LoginFragment()
    }

    override fun setupInjection() {
        fragmentComponent.plus(LoginModule()).inject(this)
    }

    override fun setupEvent() {
    }

    override fun getLayoutId() = R.layout.fragment_login

    override fun setupView() {
    }

    override fun setupData() {
    }
}