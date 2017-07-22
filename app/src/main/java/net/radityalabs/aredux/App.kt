package net.radityalabs.aredux

import android.app.Application
import android.content.Context
import net.radityalabs.aredux.di.Injector
import net.radityalabs.aredux.di.Module
import net.radityalabs.aredux.di.submodule.NetworkModule
import net.radityalabs.aredux.redux.base.StateListener

class App : Application() {

    companion object {
        private val states: MutableMap<Class<out StateListener>, MutableCollection<out StateListener>> = hashMapOf()

        fun <T : StateListener> addState(clazz: Class<T>) {
            val collection = states[clazz] as MutableCollection<out StateListener>
            states.put(clazz, collection)
        }

        fun <T : StateListener> removeState(clazz: Class<T>) {
            for (listener in states) {
                states.remove(clazz)
            }
        }

        fun <T : StateListener> getStateListener(clazz: Class<T>) = states[clazz] as MutableCollection<*>

        fun clearState() {
            states.clear()
        }
    }

    lateinit var instance: Context

    override fun onCreate() {
        super.onCreate()
        instance = this
        Injector.load(NetworkModule::class.java)
    }
}