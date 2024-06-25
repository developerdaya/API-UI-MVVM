package com.roshi.apiui.ui.forget

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.roshi.apiui.R
import com.roshi.apiui.ui.home.HomeActivity
import com.roshi.apiui.ui.otp.OtpActivity
import com.roshi.apiui.util.moveScreen
import com.roshi.apiui.util.showToast
import com.sop.restuarnt.base.BaseActivity
import com.sop.restuarnt.util.ErrorUtil
import com.sop.restuarnt.util.ProgressDialogUtils
import kotlinx.android.synthetic.main.activity_forget.*
import kotlinx.android.synthetic.main.activity_otp.*

class ForgetActivity : BaseActivity() {
    lateinit var mForgetVm: ForgetVm
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forget)
        initViews()
        initControl()
        observer()
    }

    override fun initViews() {
        mForgetVm = ViewModelProvider(this)[ForgetVm::class.java]
    }

    override fun initControl() {
        mForgotPasswordSubmit.setOnClickListener {
            if (validation()) {

                mForgetVm.hitForget(
                    mobile_number = mEnterEmail.text.toString(),
                    country_code = "+91"
                )
            }
        }
    }
    private fun validation(): Boolean {
        if (mEnterEmail.text.toString().isEmpty()) {
            mEnterEmail.error = "Please enter the mobile number"
            return false
        }
        return true

    }

    override fun observer() {
        mForgetVm.mSuccess.observe(this)
        {
            prefs.accessToken = it.response.accessToken
            showToast(it.message)
            moveScreen(OtpActivity())

        }
        mForgetVm.mError.observe(this)
        {
            ErrorUtil.handlerGeneralError(this,it)
        }
        mForgetVm.mProgress.observe(this)
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