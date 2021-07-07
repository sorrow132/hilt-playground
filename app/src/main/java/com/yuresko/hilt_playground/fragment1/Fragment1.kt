package com.yuresko.hilt_playground.fragment1

import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.FragmentContainerView
import com.google.android.material.button.MaterialButton
import com.google.android.material.textview.MaterialTextView
import com.yuresko.hilt_playground.BaseFragment
import com.yuresko.hilt_playground.childFragment.ChildFragment
import dagger.hilt.android.AndroidEntryPoint
import java.util.*

@AndroidEntryPoint
class Fragment1 : BaseFragment<IFragment1ViewModel>() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return LinearLayout(requireContext()).apply {
            id = View.generateViewId()
            layoutParams = ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
            )
            orientation = LinearLayout.VERTICAL
            gravity = Gravity.CENTER_VERTICAL
            addView(MaterialTextView(requireContext()).apply {
                layoutParams = ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT
                )
                gravity = Gravity.CENTER_HORIZONTAL
                text = arguments?.getString("text")
            })
            val fragmentContainer = FragmentContainerView(context).apply {
                id = View.generateViewId()
                layoutParams = ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.MATCH_PARENT
                )
            }
            val linear = LinearLayout(context).apply {
                orientation = LinearLayout.HORIZONTAL
                layoutParams = ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT
                )
                addView(MaterialButton(context).apply {
                    layoutParams = ViewGroup.LayoutParams(
                        ViewGroup.LayoutParams.WRAP_CONTENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT
                    )
                    text = "Open child fragment"
                    setOnClickListener {
                        val text = UUID.randomUUID().toString()
                        childFragmentManager
                            .beginTransaction()
                            .replace(fragmentContainer.id, ChildFragment().apply {
                                arguments = Bundle().apply {
                                    putString("text", text)
                                }
                            })
                            .addToBackStack(text)
                            .commit()
                    }
                })
                addView(MaterialButton(context).apply {
                    layoutParams = ViewGroup.LayoutParams(
                        ViewGroup.LayoutParams.WRAP_CONTENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT
                    )
                    text = "Pop child fragment"
                    setOnClickListener {
                        childFragmentManager.popBackStack()
                    }
                })
            }
            addView(linear)
            addView(fragmentContainer)
        }
    }

    override fun getViewModelClass(): Class<Fragment1ViewModel> {
        return Fragment1ViewModel::class.java
    }
}