package com.yuresko.hilt_playground.childFragment

import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.textview.MaterialTextView
import com.yuresko.hilt_playground.fragment1.Fragment1ViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class ChildFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory: ChildFragmentViewModel.ChildFragmentViewModelFactory

    private lateinit var viewModel: IChildFragmentViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val parentVm =
            ViewModelProvider(requireParentFragment()).get(Fragment1ViewModel::class.java)

        viewModel = ViewModelProvider(
            this,
            ChildFragmentViewModel.provideFactory(
                viewModelFactory,
                this,
                arguments,
                parentVm.router
            )
        ).get(getViewModelClass())

        return MaterialTextView(requireContext()).apply {
            id = View.generateViewId()
            layoutParams = ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
            )
            gravity = Gravity.CENTER
            text = arguments?.getString("text")
        }
    }

    fun getViewModelClass(): Class<out ChildFragmentViewModel> {
        return ChildFragmentViewModel::class.java
    }
}