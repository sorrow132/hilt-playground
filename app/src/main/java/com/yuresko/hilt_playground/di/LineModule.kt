package com.yuresko.hilt_playground.di

import android.os.Build
import com.yuresko.hilt_playground.LineRepository
import com.yuresko.hilt_playground.Repository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class LineModule {

    @Provides
    @Singleton
    fun provideReader(): Repository {
        return LineRepository()
    }

    @Provides
    @Named("str")
    fun provideString(): String {
        return Build.ID
    }
}