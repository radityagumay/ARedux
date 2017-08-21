package net.radityalabs.aredux.presentation.redux.login

import net.radityalabs.aredux.data.network.RestService

class LoginActionCreator(val store: LoginStore,
                         val service: RestService) {
    fun create(action: LoginAction) {
        when (action.type) {
            LoginActionType.SUBMIT_CREDENTIAL -> validateCredential(action)
        }
    }

    private fun validateCredential(action: LoginAction) {
        action.credential?.let {
            with(action.credential) {
                var valid = true
                if (username.isEmpty()) {
                    store.dispatch(action = LoginAction(LoginActionType.USERNAME_EMPTY))
                    valid = false
                }
                if (password.isEmpty()) {
                    store.dispatch(action = LoginAction(LoginActionType.PASSWORD_EMPTY))
                    valid = false
                }

                if (valid) {
                    service.login(action.credential)
                }
            }
        }
    }
}

