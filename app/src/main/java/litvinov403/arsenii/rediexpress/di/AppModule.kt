package litvinov403.arsenii.rediexpress.di

import android.app.Application
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import litvinov403.arsenii.rediexpress.data.manager.LocalUserManagerImpl
import litvinov403.arsenii.rediexpress.domain.manager.LocalUserManager
import litvinov403.arsenii.rediexpress.domain.usecases.AppEntryUseCases
import litvinov403.arsenii.rediexpress.domain.usecases.ReadAppEntry
import litvinov403.arsenii.rediexpress.domain.usecases.SaveAppEntry
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideLocalUserManager(
        application: Application
    ): LocalUserManager = LocalUserManagerImpl(application)

    @Provides
    @Singleton
    fun provideAppEntryUseCases(
        localUserManager: LocalUserManager
    ) = AppEntryUseCases (
        readAppEntry = ReadAppEntry(localUserManager),
        saveAppEntry = SaveAppEntry(localUserManager)
    )

}