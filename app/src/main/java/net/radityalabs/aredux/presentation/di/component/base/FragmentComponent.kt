package net.radityalabs.aredux.presentation.di.component.base

import android.app.Activity
import dagger.Component
import net.radityalabs.aredux.presentation.di.component.LoginComponent
import net.radityalabs.aredux.presentation.di.module.LoginModule
import net.radityalabs.aredux.presentation.di.module.base.FragmentModule
import net.radityalabs.aredux.presentation.di.scope.FragmentScope

@FragmentScope
@Component(dependencies = arrayOf(AppComponent::class),
        modules = arrayOf(FragmentModule::class))
interface FragmentComponent {
    fun activity(): Activity

    fun plus(module: LoginModule): LoginComponent
}
