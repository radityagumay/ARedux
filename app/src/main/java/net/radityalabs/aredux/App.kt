package net.radityalabs.aredux

import android.app.Application
import net.radityalabs.aredux.presentation.di.component.base.AppComponent
import net.radityalabs.aredux.presentation.di.component.base.DaggerAppComponent
import net.radityalabs.aredux.presentation.di.module.base.AppModule
import net.radityalabs.aredux.presentation.di.module.base.NetworkModule

class App : Application() {
    companion object {
        lateinit var instance: App
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
                .networkModule(NetworkModule())
                .build()
    }
}