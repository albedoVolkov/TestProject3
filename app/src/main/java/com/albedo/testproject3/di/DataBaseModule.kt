package com.albedo.testproject3.di

import android.content.Context
import com.albedo.testproject3.AppDataBase
import com.albedo.testproject3.data.source.local.UsersDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class DatabaseModule {

    @Singleton
    @Provides
    fun provideAppDatabase(@ApplicationContext context: Context): AppDataBase {
        return AppDataBase.getDataBase(context)
    }

    @Provides
    fun provideUsersDao(appDatabase: AppDataBase): UsersDao {
        return appDatabase.usersDao()
    }

}