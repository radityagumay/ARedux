package net.radityalabs.aredux.presentation.ui.activity

import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity

abstract class BaseActivity : AppCompatActivity() {
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