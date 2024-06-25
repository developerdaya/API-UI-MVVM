package com.roshi.apiui.util

import android.app.Activity
import android.content.Intent
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

fun AppCompatActivity.moveScreen(activity: Activity)
{
    startActivity(Intent(this,activity::class.java))
}


fun AppCompatActivity.fullScreen()
{
    window.setFlags(512, 512)
}


fun AppCompatActivity.showToast(message:String)
{
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}

