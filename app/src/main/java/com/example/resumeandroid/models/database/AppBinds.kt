package com.example.resumeandroid.models.database

import com.example.resumeandroid.models.appinterface.CustomerInterface
import com.example.resumeandroid.models.appinterface.UserInterface
import com.example.resumeandroid.models.database.repository.CustomerRepository
import com.example.resumeandroid.models.database.repository.UserRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * Using all app. Every where want get user information.
 * Declare @InstallIn(SingletonComponent::class)
 */
@InstallIn(SingletonComponent::class)
@Module
abstract class AppBinds {
    @Singleton
    @Binds
    abstract fun providerUserBinds(impl: UserRepository): UserInterface

    @Singleton
    @Binds
    abstract fun provideCustomerBinds(customerRepository: CustomerRepository) : CustomerInterface
}