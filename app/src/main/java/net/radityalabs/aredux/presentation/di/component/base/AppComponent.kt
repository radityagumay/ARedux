package net.radityalabs.aredux.presentation.di.component.base

import dagger.Component
import net.radityalabs.aredux.App
import net.radityalabs.aredux.data.database.RealmHelper
import net.radityalabs.aredux.data.network.RestHelper
import net.radityalabs.aredux.presentation.di.module.base.AppModule
import net.radityalabs.aredux.presentation.di.module.base.NetworkModule
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(AppModule::class, NetworkModule::class))
interface AppComponent {
    fun context(): App?

    fun realmHelper(): RealmHelper

    fun restHelper(): RestHelper
}