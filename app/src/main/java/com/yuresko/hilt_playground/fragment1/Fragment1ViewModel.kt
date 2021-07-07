package com.yuresko.hilt_playground.fragment1

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.yuresko.hilt_playground.IRouter
import com.yuresko.hilt_playground.IViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

interface IFragment1ViewModel : IViewModel

@HiltViewModel
class Fragment1ViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    val router: IRouter
) : ViewModel(), IFragment1ViewModel {

    init {
        println("1")
    }

    override fun onCleared() {
        super.onCleared()
    }
}