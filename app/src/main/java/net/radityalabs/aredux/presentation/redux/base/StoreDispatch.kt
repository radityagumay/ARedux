package net.radityalabs.aredux.presentation.redux.base

interface StoreDispatch<T, F> {
    fun dispatch(action: T)
    fun beforeDispatch(action: T, oldState: F)
    fun afterDispatch(action: T, newState: F)
}