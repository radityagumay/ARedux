package net.radityalabs.aredux.di

/**
 * Created by radityagumay on 7/21/17.
 */
abstract class Module {

    abstract fun load()

    fun extend(vararg modules: Class<out Module>) {
        for (m in modules) {
            Injector.load(m, false)
        }
    }

    fun provide(instance: Any, clazz: Class<*>) {
        Injector.add(instance, clazz)
    }

    fun provide(instance: Any) {
        Injector.add(instance)
    }
}