package com.roshi.apiui.ui.reset

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.PasswordTransformationMethod
import androidx.lifecycle.ViewModelProvider
import com.roshi.apiui.R
import com.roshi.apiui.ui.home.HomeActivity
import com.roshi.apiui.ui.login.LoginActivity
import com.roshi.apiui.util.AppConstant
import com.roshi.apiui.util.moveScreen
import com.roshi.apiui.util.showToast
import com.sop.restuarnt.base.BaseActivity
import com.sop.restuarnt.util.ErrorUtil
import com.sop.restuarnt.util.ProgressDialogUtils
import kotlinx.android.synthetic.main.activity_reset.*
import kotlinx.android.synthetic.main.activity_reset.mEnterConfirmPass
import kotlinx.android.synthetic.main.activity_reset.mEnterPass
import kotlinx.android.synthetic.main.activity_reset.mPass1
import kotlinx.android.synthetic.main.activity_reset.mPass2
import kotlinx.android.synthetic.main.activity_signup.*

class ResetActivity : BaseActivity() {
    lateinit var mResetVm: ResetVm
    var mPassBoolean = true
    var mConfirmPassBoolean = true
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reset)
       initViews()
        initControl()
        observer()


    }

    override fun initViews() {
        mResetVm = ViewModelProvider(this)[ResetVm::class.java]

    }

    private fun mValidation(): Boolean {


        if (mEnterPass.text.toString().isEmpty()) {
            mEnterPass.error = "Please enter the password"
            return false
        }

        if (!AppConstant.PASSWORD_PATTERN.toRegex().matches(mEnterPass.text.toString())) {
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

            mSubmitReset.setOnClickListener {
                if (mValidation())
                {
                    mResetVm.hitReset(access_token = prefs.accessToken, password = mEnterPass.text.toString())

                }
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

    }

    override fun observer() {
        mResetVm.mSuccess.observe(this)
        {
            showToast(it.message)
            moveScreen(LoginActivity())

        }
        mResetVm.mError.observe(this)
        {
            ErrorUtil.handlerGeneralError(this,it)
        }
        mResetVm.mProgress.observe(this)
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