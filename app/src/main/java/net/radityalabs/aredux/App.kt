package net.radityalabs.aredux

import android.app.Application
import android.content.Context
import net.radityalabs.aredux.di.Injector
import net.radityalabs.aredux.di.Module
import net.radityalabs.aredux.di.submodule.NetworkModule
import net.radityalabs.aredux.redux.base.StateListener

class App : Application() {

    lateinit var instance: Context

    override fun onCreate() {
        super.onCreate()
        instance = this
        Injector.load(NetworkModule::class.java)
    }
}