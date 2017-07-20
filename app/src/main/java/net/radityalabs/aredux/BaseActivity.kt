package net.radityalabs.aredux

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

/**
 * Created by radityagumay on 7/20/17.
 */

abstract class BaseActivity : AppCompatActivity() {
    protected var states: MutableList<StateListener> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    protected fun addState(state: StateListener) {
        states.add(state)
    }

    protected fun removeState(state: StateListener) {
        states.remove(state)
    }

    protected fun clearState() {
        states.clear()
    }
}