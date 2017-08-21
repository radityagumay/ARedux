package net.radityalabs.aredux.presentation.di.module;

import dagger.Module
import dagger.Provides
import net.radityalabs.aredux.data.network.RestService
import net.radityalabs.aredux.presentation.redux.login.*
import javax.inject.Singleton

@Module
class LoginModule {
    @Provides
    @Singleton
    fun provideLoginReducer(state: LoginState, action: LoginAction) =
            LoginReducer(state, action)

    @Provides
    @Singleton
    fun provideLoginStore(reducer: LoginReducer) = LoginStore(reducer)

    @Provides
    @Singleton
    fun provideActionCreator(store: LoginStore, restService: RestService) =
            LoginActionCreator(store, restService)
}
