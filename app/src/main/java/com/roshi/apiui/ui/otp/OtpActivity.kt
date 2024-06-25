package com.roshi.apiui.ui.otp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.roshi.apiui.R
import com.roshi.apiui.ui.reset.ResetActivity
import com.roshi.apiui.util.moveScreen
import com.roshi.apiui.util.showToast
import com.sop.restuarnt.base.BaseActivity
import com.sop.restuarnt.util.ErrorUtil
import com.sop.restuarnt.util.ProgressDialogUtils
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_otp.*

class OtpActivity : BaseActivity() {
    lateinit var mOtpVm: OtpVm
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_otp)
        initViews()
        initControl()
        observer()
    }

    override fun initViews() {
        mOtpVm = ViewModelProvider(this)[OtpVm::class.java]
    }

    override fun initControl() {
        mOtp.setOnClickListener {
            if (validation())
            {
            mOtpVm.hitOtp(access_token = prefs.accessToken, otp = pinViewOtp.text.toString())
        }}

    }
    private fun validation(): Boolean {
        if (pinViewOtp.text.toString().isEmpty()) {
            showToast("Please enter the OTP")
            return false
        }
        return true

    }

    override fun observer() {
        mOtpVm.mSuccess.observe(this)
        {
            showToast(it.message)
            moveScreen(ResetActivity())

        }
        mOtpVm.mError.observe(this)
        {
            ErrorUtil.handlerGeneralError(this,it)
        }
        mOtpVm.mProgress.observe(this)
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