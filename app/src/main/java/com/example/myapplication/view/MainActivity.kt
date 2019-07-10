package com.example.myapplication.view

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.myapplication.R


class MainActivity : AppCompatActivity() {
    val TAG = MainActivity::class.java.simpleName


    val viewModelTest by lazy { ViewModelProviders.of(this).get(ViewModelTest::class.java) }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initObservers()

    }


    private fun initObservers() {

        viewModelTest.state.observe(this, Observer {

            Log.d(TAG, "initObservers: $it   ${it.data}")
        })


    }


}
