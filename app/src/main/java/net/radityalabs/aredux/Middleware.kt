package net.radityalabs.aredux

interface MiddleWare {
    fun doBeforeNewState(action: ChatAction, oldState: ChatState)
    fun doAfterNewState(action: ChatAction, newState: ChatState)
}
