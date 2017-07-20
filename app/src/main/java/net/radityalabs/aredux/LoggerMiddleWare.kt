package net.radityalabs.aredux

import android.util.Log

/**
 * Created by radityagumay on 7/20/17.
 */

class LoggerMiddleWare : MiddleWare {
    companion object {
        private val TAG = "Ride"
    }

    override fun doBeforeNewState(action: ChatAction, oldState: ChatState) {
        Log.d(TAG, "Action: " + action.toString() + ", Old state: " + oldState)
    }

    override fun doAfterNewState(action: ChatAction, newState: ChatState) {
        Log.d(TAG, "Action: " + action.toString() + ", New state: " + newState)
    }
}
