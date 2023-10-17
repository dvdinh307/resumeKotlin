package com.example.resumeandroid.models.di

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object AppModule {
    /**
     * Create database with name @DatabaseString.NAME_DB
     */
    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context: Context) = AppDatabase.getInstance(context)

    /**
     * Declare to Dagger 2 how to get User DAO
     */
    @Singleton
    @Provides
    fun provideUserDao(appDao: AppDatabase) = appDao.userDao()

    @Singleton
    @Provides
    fun provideCustomerDao(appDao: AppDatabase) = appDao.getCustomerDao()

//    @Singleton
//    @Provides
//    fun provideAnalyticsService(
//        // Potential dependencies of this type
//    ): AnalyticsService {
//        return Retrofit.Builder()
//            .baseUrl("https://example.com")
//            .build()
//            .create(AnalyticsService::class.java)
//    }
}