package net.radityalabs.aredux

import io.reactivex.Single

/**
 * Created by radityagumay on 7/20/17.
 */

class ChatRepositoryImpl : ChatRepository<ChatObject> {
    override fun loadLocalMessage(id: Int): Single<ChatObject> {
        return Single.create<ChatObject> { emitter ->
            emitter.onSuccess(load(ChatObject::class.java, "chat-dummy.json"))
        }.compose(singleIo())
    }
}