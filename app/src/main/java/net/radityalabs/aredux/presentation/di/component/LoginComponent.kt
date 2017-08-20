package net.radityalabs.aredux.presentation.di.component

import dagger.Subcomponent
import net.radityalabs.aredux.presentation.di.module.LoginModule
import net.radityalabs.aredux.presentation.ui.fragment.LoginFragment
import javax.inject.Singleton

@Singleton
@Subcomponent(modules = arrayOf(LoginModule::class))
interface LoginComponent {
    fun inject(fragment: LoginFragment)
}