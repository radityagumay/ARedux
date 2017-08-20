package net.radityalabs.aredux.presentation.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import net.radityalabs.aredux.R

class LoginFragment : BaseFragment() {
    companion object {
        val TAG = LoginFragment::class.java.simpleName
        fun newInstance() = LoginFragment()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?) =
            inflater?.inflate(R.layout.fragment_login, container, false)
}