package net.radityalabs.aredux.presentation.di.module.base;

import dagger.Module
import dagger.Provides
import net.radityalabs.aredux.App
import net.radityalabs.aredux.data.database.RealmHelper
import net.radityalabs.aredux.data.network.RestHelper
import net.radityalabs.aredux.data.network.RestService
import javax.inject.Singleton

@Module
class AppModule(val app: App? = null) {
    @Singleton
    @Provides
    fun provideAppContext() = app

    @Provides
    @Singleton
    fun provideRealmHelper() = RealmHelper()

    @Provides
    @Singleton
    fun provideRestHelper(restService: RestService) = RestHelper(restService)
}
