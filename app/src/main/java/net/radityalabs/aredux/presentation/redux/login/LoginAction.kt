package net.radityalabs.aredux.presentation.redux.login

data class LoginAction(val type: LoginActionType? = null,
                       val credential: Credential? = null)

data class Credential(val username: String,
                      val password: String)