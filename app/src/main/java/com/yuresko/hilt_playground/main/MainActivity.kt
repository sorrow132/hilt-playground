package com.yuresko.hilt_playground.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentContainerView
import com.google.android.material.button.MaterialButton
import com.yuresko.hilt_playground.BaseActivity
import com.yuresko.hilt_playground.R
import com.yuresko.hilt_playground.fragment1.Fragment1
import dagger.hilt.android.AndroidEntryPoint
import java.util.*

@AndroidEntryPoint
class MainActivity : BaseActivity<IMainViewModel>() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val openFragmentBtn: MaterialButton = findViewById(R.id.open_fragment)
        val fragmentContainer: FragmentContainerView = findViewById(R.id.fragment_container)
        openFragmentBtn.setOnClickListener {
            val text = UUID.randomUUID().toString()
            supportFragmentManager
                .beginTransaction()
                .replace(fragmentContainer.id, Fragment1().apply {
                    arguments = Bundle().apply {
                        putString("text", text)
                    }
                })
                .addToBackStack(text)
                .commit()
        }
    }

    override fun getViewModelClass(): Class<out MainViewModel> {
        return MainViewModel::class.java
    }
}