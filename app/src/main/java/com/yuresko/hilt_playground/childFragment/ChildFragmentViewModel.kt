package com.yuresko.hilt_playground.childFragment

import android.os.Bundle
import androidx.lifecycle.AbstractSavedStateViewModelFactory
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.savedstate.SavedStateRegistryOwner
import com.yuresko.hilt_playground.IRouter
import com.yuresko.hilt_playground.IViewModel
import com.yuresko.hilt_playground.Repository
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject

interface IChildFragmentViewModel : IViewModel

class ChildFragmentViewModel @AssistedInject constructor(
    @Assisted private val savedStateHandle: SavedStateHandle,
    @Assisted private val router: IRouter,
    private val repository: Repository
) : ViewModel(), IChildFragmentViewModel {

    @AssistedFactory
    interface ChildFragmentViewModelFactory {

        fun create(
            savedStateHandle: SavedStateHandle,
            router: IRouter
        ): ChildFragmentViewModel
    }

    companion object {
        fun provideFactory(
            assistedFactory: ChildFragmentViewModelFactory,
            owner: SavedStateRegistryOwner,
            defaultArgs: Bundle? = null,
            router: IRouter
        ): AbstractSavedStateViewModelFactory =
            object : AbstractSavedStateViewModelFactory(owner, defaultArgs) {
                @Suppress("UNCHECKED_CAST")
                override fun <T : ViewModel> create(
                    key: String,
                    modelClass: Class<T>,
                    handle: SavedStateHandle
                ): T {
                    return assistedFactory.create(handle, router) as T
                }
            }
    }

    init {
        println("1")
    }

    override fun onCleared() {
        super.onCleared()
    }
}