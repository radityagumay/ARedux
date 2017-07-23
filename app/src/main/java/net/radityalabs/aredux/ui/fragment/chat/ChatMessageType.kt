package net.radityalabs.aredux.ui.fragment.chat

import android.support.annotation.IntDef

/**
 * Created by radityagumay on 7/20/17.
 */

class ChatMessageType {
    companion object Type {
        @IntDef(ME_TEXT, ME_IMAGE, ME_VIDEO, ME_AUDIO, ME_STICKER)
        @Retention(AnnotationRetention.SOURCE)
        annotation class ChatMessageTypeDef

        const val ME_TEXT = 0L
        const val ME_IMAGE = 1L
        const val ME_VIDEO = 2L
        const val ME_AUDIO = 3L
        const val ME_STICKER = 4L
    }
}