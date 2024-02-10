package com.albedo.testproject3.ui.userinformation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.albedo.testproject3.R
import dagger.hilt.EntryPoint
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class UserInformationActivity : AppCompatActivity() {

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_main)

        }
    }