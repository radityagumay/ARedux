package net.radityalabs.aredux

import io.reactivex.Single

/**
 * Created by radityagumay on 7/20/17.
 */

interface ChatRepository<T> {
    fun loadLocalMessage(id: Int): Single<T>
}