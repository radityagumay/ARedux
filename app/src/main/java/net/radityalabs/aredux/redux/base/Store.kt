package net.radityalabs.aredux.redux.base

/**
 * Created by radityagumay on 7/20/17.
 */

interface Store<U> {
    fun register(stateListener: U)
    fun unregister(stateListener: U)
}