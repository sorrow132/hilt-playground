package com.yuresko.hilt_playground.di

import com.yuresko.hilt_playground.IRouter
import com.yuresko.hilt_playground.Router
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
abstract class RouterModule {

    @Binds
    @ViewModelScoped
    abstract fun bindRouter(router: Router): IRouter
}