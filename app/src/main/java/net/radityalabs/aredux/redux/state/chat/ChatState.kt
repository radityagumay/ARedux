package net.radityalabs.aredux.redux.state.chat

import net.radityalabs.aredux.ui.fragment.chat.ChatScreen

data class ChatState(
        val currentScreen: ChatScreen = ChatScreen.ME_TEXT
)