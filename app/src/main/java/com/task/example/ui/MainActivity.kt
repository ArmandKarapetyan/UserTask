package com.task.example.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.task.example.databinding.ActivityMainBinding
import com.task.example.utils.viewBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val viewBinding: ActivityMainBinding by viewBinding()
    private val viewModel: MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(viewBinding.root)
    }
}
