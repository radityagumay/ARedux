package net.radityalabs.aredux.presentation.redux.base

interface Store<U> {
    fun register(listener: U)
}