package net.radityalabs.aredux

class ChatStore(private val chatStateTransform: ChatStateTransform,
                private val middleware: List<MiddleWare>) {

}