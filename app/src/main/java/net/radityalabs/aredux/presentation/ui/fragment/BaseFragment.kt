package net.radityalabs.aredux.presentation.ui.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import net.radityalabs.aredux.App
import net.radityalabs.aredux.presentation.di.component.base.DaggerFragmentComponent
import net.radityalabs.aredux.presentation.di.component.base.FragmentComponent
import net.radityalabs.aredux.presentation.di.module.base.FragmentModule

abstract class BaseFragment : Fragment() {

    protected val fragmentComponent: FragmentComponent
        get() = DaggerFragmentComponent.builder()
                .appComponent(App.appComponent)
                .fragmentModule(FragmentModule(this))
                .build()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupInjection()
        setupEvent()
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?) =
            inflater?.inflate(getLayoutId(), container, false)

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupView()
        setupData()
    }

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

    protected abstract fun setupInjection()

    protected abstract fun setupEvent()

    protected abstract fun getLayoutId(): Int

    protected abstract fun setupView()

    protected abstract fun setupData()
}