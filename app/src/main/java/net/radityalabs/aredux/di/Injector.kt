@file:Suppress("UNCHECKED_CAST")

package net.radityalabs.aredux.di

/**
 * Created by radityagumay on 7/21/17.
 */

import android.util.Log
import java.util.HashMap

object Injector {

    private val TAG = Injector::class.java.simpleName

    private val instances: MutableMap<Class<*>, Any> = HashMap()

    fun <T> get(clazz: Class<T>): T {
        val o = instances[clazz] ?: throw IllegalStateException("Instance not found for class : '" + clazz.simpleName + "'"
        )
        return o as T
    }

    fun <T> getOrNull(clazz: Class<T>): T? {
        val t = instances[clazz] as T
        if (t != null)
            Log.v(TAG, "getOrNull " + clazz.simpleName + " :: " + t)
        else
            Log.v(TAG, "no instance for class:" + clazz)
        return t
    }

    fun add(o: Any?) {
        if (o != null) {
            add(o, o.javaClass)
        }
    }

    fun add(o: Any?, clazz: Class<*>?) {
        Log.v(TAG, "Add/Replace instance:" + o + " class:" + clazz!!.simpleName)
        val existingInstance = getOrNull(clazz)
        if (existingInstance != null) {
            remove(clazz)
        }
        if (o != null && clazz != null) {
            Log.v(TAG, "Add instance for " + clazz.simpleName)
            instances.put(clazz, o)
        } else {
            throw IllegalStateException("can't add instance for : object:$o & class:$clazz")
        }
    }

    @JvmOverloads
    fun load(module: Class<out Module>, clearBefore: Boolean = false) {
        if (clearBefore) {
            clear()
        }

        Log.v(TAG, "loading definition : " + module)
        try {
            val mod = module.newInstance()
            mod.load()
        } catch (e: Throwable) {
            throw IllegalStateException("Module prepare " + module.simpleName + " error : " + e)
        }

    }

    fun remove(clazz: Class<*>) {
        Log.v(TAG, "Remove class : " + clazz.simpleName)
        instances.remove(clazz)
    }

    fun remove(o: Any) {
        val simpleName = o.javaClass.simpleName
        Log.v(TAG, "Remove class : " + simpleName)
        instances.remove(Class.forName(simpleName))
    }

    fun clear() {
        Log.v(TAG, "Clear All instances !")
        instances.clear()
    }
}