package net.radityalabs.aredux

import junit.framework.Assert
import net.radityalabs.aredux.ui.fragment.chat.*
import org.junit.Test

/**
 * Created by radityagumay on 7/23/17.
 */
class ChatBodyStateTransformerTest {
    @Test
    fun testSendMessageText() {
        val msg = "Hello world"
        val msgObj = MessageObject(ChatMessageType.ME_TEXT, MessageTypeText(msg))
        val expectedState = ChatBodyState(chatTask = ChatTask.APPEND_NEW_MESSAGE, messageObject = msgObj)
        val resultState = ChatBodyStateTransformer().transform(
                ChatBodyState(), ChatBodyAction.SEND_MESSAGE(ChatTask.APPEND_NEW_MESSAGE, msgObj))
        Assert.assertEquals(expectedState, resultState)
    }
}