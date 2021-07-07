package com.yuresko.hilt_playground

import android.os.Bundle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

abstract class BaseFragmentWithParentVM<ParentVM: IViewModel, VM : IViewModel> : BaseFragment<VM>() {

    lateinit var parentViewModel: ParentVM

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        parentViewModel = ViewModelProvider(requireParentFragment()).get(getParentViewModelClass()) as ParentVM
    }

    abstract fun getParentViewModelClass(): Class<out ViewModel>
}