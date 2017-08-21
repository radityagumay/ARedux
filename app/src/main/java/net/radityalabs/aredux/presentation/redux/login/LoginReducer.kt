package net.radityalabs.aredux.presentation.redux.login

class LoginReducer {
    fun reduce(oldState: LoginState, action: LoginAction): LoginState {
        when (action.type) {
            LoginActionType.SUBMIT_CREDENTIAL -> return validateCredential(oldState, action)
        }
    }

    private fun validateCredential(oldState: LoginState, action: LoginAction): LoginState {
        action.credential?.let {
            with(action.credential) {
                if (username.isNotEmpty() && password.isNotEmpty()) {
                    return oldState.copy(LoginActionType.)
                } else {

                }
            }
        }
    }
}