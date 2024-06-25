package com.sop.restuarnt.base

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import com.sop.restuarnt.util.SharedPreferenceUtility


abstract class BaseActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

    }
    open val prefs by lazy {
        SharedPreferenceUtility.getInstance(this)
    }


    // Initialization only view and set text views
    abstract fun initViews()

    // Set Listeners or events and methods
    abstract fun initControl()

    // user for observer
    abstract fun observer()
}