package com.yuresko.hilt_playground.main

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.yuresko.hilt_playground.IViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

interface IMainViewModel : IViewModel

@HiltViewModel
class MainViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle
): ViewModel(), IMainViewModel {

    init {
        println("1")
    }

    override fun onCleared() {
        super.onCleared()
    }
}