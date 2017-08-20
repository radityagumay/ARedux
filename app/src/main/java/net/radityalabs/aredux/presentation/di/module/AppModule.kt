package net.radityalabs.aredux.presentation.di.module;

import android.content.Context
import dagger.Module
import dagger.Provides
import net.radityalabs.aredux.data.database.RealmHelper
import net.radityalabs.aredux.data.network.RestHelper
import net.radityalabs.aredux.data.network.RestService
import javax.inject.Singleton

@Module
class AppModule(val context: Context) {
    @Provides
    @Singleton
    fun provideContext() = context

    @Provides
    @Singleton
    fun provideRealmHelper() = RealmHelper()

    @Provides
    @Singleton
    fun provideRestHelper(restService: RestService) = RestHelper(restService)
}
