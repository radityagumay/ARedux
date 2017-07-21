package net.radityalabs.aredux.ui.activity

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import net.radityalabs.aredux.StateListener

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

    protected fun replaceFragment(containerId: Int, fragment: Fragment, isAddToBackStack: Boolean = false) {
        supportFragmentManager.beginTransaction()
                .replace(containerId, fragment, fragment.tag)
                .addToBackStack(if (isAddToBackStack) fragment.tag else null)
                .commit()
    }

    protected fun addFragment(containerId: Int, fragment: Fragment, isAddToBackStack: Boolean = false) {
        supportFragmentManager.beginTransaction()
                .add(containerId, fragment, fragment.tag)
                .addToBackStack(if (isAddToBackStack) fragment.tag else null)
                .commit()
    }

    protected fun removeFragment(fragment: Fragment){
        supportFragmentManager.beginTransaction()
                .remove(fragment)
                .commit()
    }
}