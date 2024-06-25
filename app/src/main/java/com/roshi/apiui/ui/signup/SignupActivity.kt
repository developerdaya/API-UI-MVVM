package com.roshi.apiui.ui.signup

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.PasswordTransformationMethod
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.roshi.apiui.R
import com.roshi.apiui.ui.home.HomeActivity
import com.roshi.apiui.ui.login.LoginActivity
import com.roshi.apiui.util.AppConstant.EMAIL_PATTERN
import com.roshi.apiui.util.AppConstant.PASSWORD_PATTERN
import com.roshi.apiui.util.moveScreen
import com.roshi.apiui.util.showToast
import com.sop.restuarnt.base.BaseActivity
import com.sop.restuarnt.util.ErrorUtil
import com.sop.restuarnt.util.ProgressDialogUtils
import kotlinx.android.synthetic.main.activity_signup.*

class SignupActivity : BaseActivity() {
    lateinit var mSignupVm: SignupVm
    var mPassBoolean = true
    var mConfirmPassBoolean = true
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
        initViews()
        initControl()
        observer()
    }

    override fun initViews() {
        mSignupVm = ViewModelProvider(this)[SignupVm::class.java]
    }

    override fun initControl() {
        mPass1.setOnClickListener {
            if (mPassBoolean) {
                mEnterPass.transformationMethod = null
                mPassBoolean = false
                mPass1.setImageResource(R.drawable.visibility_on)
                mEnterPass.setSelection(mEnterPass.length())
            } else {
                mEnterPass.transformationMethod = PasswordTransformationMethod()
                mPassBoolean = true
                mPass1.setImageResource(R.drawable.visibility_off)
                mEnterPass.setSelection(mEnterPass.length())

            }
        }

        mPass2.setOnClickListener {
            if (mConfirmPassBoolean) {
                mEnterConfirmPass.transformationMethod = null
                mConfirmPassBoolean = false
                mPass2.setImageResource(R.drawable.visibility_on)
                mEnterConfirmPass.setSelection(mEnterConfirmPass.length())
            } else {
                mEnterConfirmPass.transformationMethod = PasswordTransformationMethod()
                mConfirmPassBoolean = true
                mPass2.setImageResource(R.drawable.visibility_off)
                mEnterConfirmPass.setSelection(mEnterConfirmPass.length())
            }
        }

        mContinueSignup.setOnClickListener {
            if (mValidation()) {
                mSignupVm.hitSignup(
                    userName = mEnterName.text.toString(),
                    email = mEnterEmail.text.toString(),
                    country_code = "+91",
                    mobile_number = mEnterMobile.text.toString(),
                    password = mEnterPass.text.toString(),
                    confirm_password = mEnterPass.text.toString(),
                    device_type = "1",
                    device_token = "aaa",
                    deliveryType = "1")
            }
        }
        mLogin22.setOnClickListener {
            moveScreen(LoginActivity())
        }

    }

    override fun observer() {
        mSignupVm.mSuccess.observe(this)
        {
            showToast(it.message)
            moveScreen(HomeActivity())

        }
            mSignupVm.mError.observe(this)
        {
            ErrorUtil.handlerGeneralError(this,it)
        }
            mSignupVm.mProgress.observe(this)
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

    private fun mValidation(): Boolean {
        if (mEnterEmail.text.toString().isEmpty()) {
            mEnterEmail.error = "Please enter the email"
            return false
        }

        if (!EMAIL_PATTERN.toRegex().matches(mEnterEmail.text.toString())) {
            mEnterEmail.error = "Please enter a valid email"
            return false
        }


        if (mEnterName.text.toString().isEmpty()) {
            mEnterName.error = "Please enter the name"
            return false
        }

        if (mEnterMobile.text.toString().isEmpty()) {
            mEnterMobile.error = "Please enter the mobile number"
            return false
        }


        if (mEnterPass.text.toString().isEmpty()) {
            mEnterPass.error = "Please enter the password"
            return false
        }

        if (!PASSWORD_PATTERN.toRegex().matches(mEnterPass.text.toString())) {
            mEnterPass.error = "Password should be at least 8 alphanumeric,capital & special characters"

            return false
        }



        if (mEnterConfirmPass.text.toString().isEmpty()) {
            mEnterConfirmPass.error = "PLease enter the comfort password"
            return false
        }

        if (mEnterPass.text.toString()!=mEnterConfirmPass.text.toString()) {
            mEnterConfirmPass.error = "Password mismatched"
            return false
        }



        return true

    }
}
