package com.example.resumeandroid.models.di

import android.content.Context
import com.example.resumeandroid.models.network.MarsApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

@InstallIn(SingletonComponent::class)
@Module
object AppModule {
    private const val BASE_URL = "https://android-kotlin-fun-mars-server.appspot.com/"

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

    @Singleton
    @Provides
    fun provideMoshi(): Moshi = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()

    @Singleton
    @Provides
    fun provideRetrofit(moshi: Moshi): Retrofit = Retrofit.Builder()
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .baseUrl(BASE_URL)
        .build()

    @Provides
    @Singleton
    fun providerService(retrofit: Retrofit): MarsApiService {
        return retrofit.create(MarsApiService::class.java)
    }
}