package net.radityalabs.aredux

import android.app.Application
import android.content.Context
import net.radityalabs.aredux.di.Injector
import net.radityalabs.aredux.di.Module
import net.radityalabs.aredux.di.submodule.NetworkModule
import net.radityalabs.aredux.presentation.di.component.AppComponent
import net.radityalabs.aredux.presentation.di.module.AppModule
import net.radityalabs.aredux.presentation.di.module.NetworkModule

class App : Application() {
    companion object {
        lateinit var instance: Context
            private set
        lateinit var appComponent: AppComponent
            private set
    }

    override fun onCreate() {
        super.onCreate()
        instance = this

        setupAppComponent()
    }

    private fun setupAppComponent() {
        appComponent = DaggerAppComponent.builder()
                .appModule(AppModule(instance))
                .httpModule(NetworkModule())
                .build()
    }
}