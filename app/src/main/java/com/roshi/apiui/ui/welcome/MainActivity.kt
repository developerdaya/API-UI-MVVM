package com.roshi.apiui.welcome

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.roshi.apiui.R
import com.roshi.apiui.ui.signup.SignupActivity
import com.roshi.apiui.util.fullScreen
import com.roshi.apiui.util.moveScreen

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        fullScreen()
        Handler().postDelayed({
            moveScreen(SignupActivity())
        },1000)
    }
}