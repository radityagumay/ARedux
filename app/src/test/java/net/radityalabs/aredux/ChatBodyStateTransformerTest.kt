package net.radityalabs.aredux

import junit.framework.Assert
import net.radityalabs.aredux.presentation.ui.fragment.chat.*
import org.junit.Test

/**
 * Created by radityagumay on 7/23/17.
 */
class ChatBodyStateTransformerTest {

    @Test
    fun testSendMessageText() {
        val msg = "Hello World"
        val msgObj = MessageObject(ChatMessageType.ME_TEXT, MessageTypeText(msg))
        val expectedState = ChatBodyState(chatTask = ChatTask.APPEND_NEW_MESSAGE, messageObject = msgObj)
        val resultState = ChatBodyStateTransformer().transform(
                ChatBodyState(), ChatBodyAction.SEND_MESSAGE(ChatTask.APPEND_NEW_MESSAGE, msgObj))
        Assert.assertEquals(expectedState, resultState)
    }

    @Test
    fun testEmptyAfterSendMessageText() {
        val expectedState = ChatBodyState(chatTask = ChatTask.EMPTY_EDIT_TEXT)
        val resultState = ChatBodyStateTransformer().transform(
                ChatBodyState(), ChatBodyAction.VIEW(ChatTask.EMPTY_EDIT_TEXT))
        Assert.assertEquals(expectedState, resultState)
    }

    @Test
    fun testShowEmoticonAfterClick(){
        val expectedState = ChatBodyState(chatTask = ChatTask.SHOW_EMOTICON)
        val resultState = ChatBodyStateTransformer().transform(
                ChatBodyState(), ChatBodyAction.VIEW(ChatTask.SHOW_EMOTICON))
        Assert.assertEquals(expectedState, resultState)
    }

    @Test
    fun testHideEmoticonAfterBackKeyPressClick(){
        val expectedState = ChatBodyState(chatTask = ChatTask.HIDE_EMOTICON)
        val resultState = ChatBodyStateTransformer().transform(
                ChatBodyState(), ChatBodyAction.VIEW(ChatTask.HIDE_EMOTICON))
        Assert.assertEquals(expectedState, resultState)
    }

    @Test
    fun testShowSoftKeyboardAfterClick(){
        val expectedState = ChatBodyState(chatTask = ChatTask.SHOW_KEYBOARD)
        val resultState = ChatBodyStateTransformer().transform(
                ChatBodyState(), ChatBodyAction.VIEW(ChatTask.SHOW_KEYBOARD))
        Assert.assertEquals(expectedState, resultState)
    }

    @Test
    fun testHideSoftKeyboardAfterBackKeyPressClick(){
        val expectedState = ChatBodyState(chatTask = ChatTask.HIDE_KEYBOARD)
        val resultState = ChatBodyStateTransformer().transform(
                ChatBodyState(), ChatBodyAction.VIEW(ChatTask.HIDE_KEYBOARD))
        Assert.assertEquals(expectedState, resultState)
    }
}