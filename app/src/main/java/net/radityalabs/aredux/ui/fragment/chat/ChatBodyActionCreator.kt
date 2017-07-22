package net.radityalabs.aredux.ui.fragment.chat

import net.radityalabs.aredux.data.network.RestService
import net.radityalabs.aredux.di.Module

/**
 * Created by radityagumay on 7/22/17.
 */

class ChatBodyActionCreator(
        private val service: RestService,
        private val store: ChatBodyStore) : Module() {
    override fun load() {

    }
}