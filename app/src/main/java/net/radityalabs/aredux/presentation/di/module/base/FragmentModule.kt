package net.radityalabs.aredux.presentation.di.module.base

import android.app.Activity
import android.support.v4.app.Fragment
import dagger.Module
import dagger.Provides
import net.radityalabs.aredux.presentation.di.scope.FragmentScope

@Module
class FragmentModule(private val fragment: Fragment) {
    @Provides
    @FragmentScope
    fun provideActivity(): Activity {
        return fragment.activity
    }
}
