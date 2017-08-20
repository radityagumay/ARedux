package net.radityalabs.aredux.presentation.ui.fragment

import android.support.v4.app.Fragment

abstract class BaseFragment : Fragment() {
    protected fun addChildFragment(containerId: Int, fragment: Fragment, isAddToBackStack: Boolean = false) {
        childFragmentManager.beginTransaction()
                .add(containerId, fragment, fragment.tag)
                .addToBackStack(if (isAddToBackStack) fragment.tag else null)
                .commit()
    }

    protected fun replaceChildFragment(containerId: Int, fragment: Fragment, isAddToBackStack: Boolean = false) {
        childFragmentManager.beginTransaction()
                .replace(containerId, fragment, fragment.tag)
                .addToBackStack(if (isAddToBackStack) fragment.tag else null)
                .commit()
    }
}