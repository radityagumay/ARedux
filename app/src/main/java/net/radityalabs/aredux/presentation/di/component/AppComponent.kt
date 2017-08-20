package net.radityalabs.aredux.presentation.di.component

import android.content.Context
import dagger.Component
import net.radityalabs.aredux.data.database.RealmHelper
import net.radityalabs.aredux.data.network.RestHelper
import net.radityalabs.aredux.presentation.di.module.AppModule
import net.radityalabs.aredux.presentation.di.module.NetworkModule
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(AppModule::class, NetworkModule::class))
interface AppComponent {
    fun context(): Context

    fun realmHelper(): RealmHelper

    fun restHelper(): RestHelper
}