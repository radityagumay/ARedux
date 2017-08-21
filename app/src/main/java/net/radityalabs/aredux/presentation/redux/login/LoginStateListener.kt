package net.radityalabs.aredux.presentation.redux.login

interface LoginStateListener {
    fun onSubscribeChange(state: LoginState)
}