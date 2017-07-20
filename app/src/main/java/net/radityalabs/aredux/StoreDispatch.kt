package net.radityalabs.aredux

/**
 * Created by radityagumay on 7/20/17.
 */

interface StoreDispatch<T, F> {
    fun updateState(action: T)
    fun dispatch(action: T)
    fun beforeDispatch(action: T, oldState: F)
    fun afterDispatch(action: T, newState: F)
}