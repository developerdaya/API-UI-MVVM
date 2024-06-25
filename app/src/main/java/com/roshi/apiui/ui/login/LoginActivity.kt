package com.roshi.apiui.ui.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.PasswordTransformationMethod
import androidx.lifecycle.ViewModelProvider
import com.roshi.apiui.R
import com.roshi.apiui.ui.forget.ForgetActivity
import com.roshi.apiui.ui.home.HomeActivity
import com.roshi.apiui.ui.otp.OtpActivity
import com.roshi.apiui.ui.signup.SignupActivity
import com.roshi.apiui.util.moveScreen
import com.roshi.apiui.util.showToast
import com.sop.restuarnt.base.BaseActivity
import com.sop.restuarnt.util.ErrorUtil
import com.sop.restuarnt.util.ProgressDialogUtils
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_login.mEnterEmail
import kotlinx.android.synthetic.main.activity_login.mEnterPass
import kotlinx.android.synthetic.main.activity_login.mLogin22
import kotlinx.android.synthetic.main.activity_login.mPass1
import kotlinx.android.synthetic.main.activity_signup.*

class LoginActivity : BaseActivity() {
    var  mPassBoolean =true
    lateinit var mLoginVm: LoginVm
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        initViews()
        observer()
        mForgotPassword.setOnClickListener {
            moveScreen(ForgetActivity())
        }
        mLogin22.setOnClickListener {
            moveScreen(SignupActivity())
            moveScreen(SignupActivity())
        }
        initControl()

    }

    override fun initViews() {
        mLoginVm = ViewModelProvider(this)[LoginVm::class.java]
    }

    override fun initControl() {
        mPass1.setOnClickListener {
            if (mPassBoolean)
            {
                mEnterPass.transformationMethod = null
                mPassBoolean = false
                mPass1.setImageResource(R.drawable.visibility_on)
                mEnterPass.setSelection(mEnterPass.length())
            }
            else
            {
                mEnterPass.transformationMethod = PasswordTransformationMethod()
                mPassBoolean = true
                mPass1.setImageResource(R.drawable.visibility_off)
                mEnterPass.setSelection(mEnterPass.length())

            }
        }

        mLogin.setOnClickListener {
           if (validation())
           {
            mLoginVm.hitLogin(
                country_code = "+91",
                mobile_number = mEnterEmail.text.toString(),
                password = mEnterPass.text.toString(),
                latitude = "10.00",
                longitude = "10.00"
            )
        }}

    }

    private fun validation(): Boolean {
        if (mEnterEmail.text.toString().isEmpty()) {
            mEnterEmail.error = "Please enter the phone number"
            return false
        }

          if (mEnterPass.text.toString().isEmpty()) {
              mEnterPass.error = "Please enter the password"
            return false
        }



        return true
    }

    override fun observer() {
        mLoginVm.mSuccess.observe(this)
        {
            showToast(it.message)
            moveScreen(HomeActivity())

        }
        mLoginVm.mError.observe(this)
        {
            ErrorUtil.handlerGeneralError(this,it)
        }
        mLoginVm.mProgress.observe(this)
        {
            if (it)
            {
                ProgressDialogUtils.getInstance().showProgress(this,false)
            }
            else
            {
                ProgressDialogUtils.getInstance().hideProgress()

            }
        }


    }
}