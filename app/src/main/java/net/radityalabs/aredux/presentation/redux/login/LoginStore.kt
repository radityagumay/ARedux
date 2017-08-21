package net.radityalabs.aredux.presentation.redux.login

import net.radityalabs.aredux.presentation.redux.base.Store
import net.radityalabs.aredux.presentation.redux.base.StoreDispatch

class LoginStore(val reducer: LoginReducer):
        Store<LoginStateListener>,
        StoreDispatch<LoginAction, LoginState> {
    private lateinit var listener: LoginStateListener

    private var state: LoginState = LoginState()

    override fun register(listener: LoginStateListener) {
        this.listener = listener
    }

    override fun beforeDispatch(action: LoginAction, oldState: LoginState) {
    }

    override fun dispatch(action: LoginAction) {
        state = reducer.reduce(state, action)
        listener.onSubscribeChange(state)
    }

    override fun afterDispatch(action: LoginAction, newState: LoginState) {
    }
}