package net.radityalabs.aredux.presentation.redux.login

data class LoginState (
    val action: LoginActionType? = null,
    val credential: Credential)