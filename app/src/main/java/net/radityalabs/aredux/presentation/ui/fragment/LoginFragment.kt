package net.radityalabs.aredux.presentation.ui.fragment

import android.support.annotation.IdRes
import android.text.Editable
import android.text.TextWatcher
import kotlinx.android.synthetic.main.fragment_login.*
import net.radityalabs.aredux.R
import net.radityalabs.aredux.presentation.di.module.LoginModule
import net.radityalabs.aredux.presentation.redux.login.*
import javax.inject.Inject
import kotlin.properties.Delegates

class LoginFragment : BaseFragment(), LoginStateListener {
    @Inject
    lateinit var store: LoginStore
    @Inject
    lateinit var actionCreator: LoginActionCreator

    private var mUsername by Delegates.notNull<String>()
    private var mPassword by Delegates.notNull<String>()

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
        username.addTextChangedListener(textWatcher(R.id.username))
        password.addTextChangedListener(textWatcher(R.id.password))

        submit.setOnClickListener {
            actionCreator.create(LoginAction(LoginActionType.SUBMIT_CREDENTIAL, Credential(mUsername, mPassword)))
        }
    }

    override fun setupData() {
        store.subscribe(this)
    }

    override fun onSubscribeChange(state: LoginState) {

    }


    private fun textWatcher(@IdRes id: Int): TextWatcher {
        return object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                when (id) {
                    R.id.username -> mUsername = p0.toString()
                    R.id.password -> mPassword = p0.toString()
                }
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }
        }
    }
}