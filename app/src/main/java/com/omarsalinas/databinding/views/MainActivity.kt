package com.omarsalinas.databinding.views

import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.omarsalinas.databinding.BR
import com.omarsalinas.databinding.R
import com.omarsalinas.databinding.databinding.ActivityMainBinding
import com.omarsalinas.databinding.models.MainViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel : MainViewModel = MainViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        this.binding.setVariable(BR.model, this.viewModel)
        this.binding.executePendingBindings()
    }
}
