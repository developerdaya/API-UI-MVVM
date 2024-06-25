package com.roshi.apiui.ui.otp

import androidx.lifecycle.MutableLiveData
import com.roshi.apiui.modelResp.LoginResp
import com.roshi.apiui.modelResp.OtpResp
import com.sop.restuarnt.base.BaseViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class OtpVm() :BaseViewModel() {
    lateinit var disposable: Disposable
    val mSuccess = MutableLiveData<OtpResp>()
    val mError = MutableLiveData<Throwable>()
    val mProgress = MutableLiveData<Boolean>()

    fun hitOtp(
        access_token: String,
        otp: String
    ) {

        disposable = api.hitOtp(
            access_token , otp

        )
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe {
                mProgress.value = true
            }
            .doOnTerminate {
                mProgress.value = false
            }
            .subscribe(
                {
                    mSuccess.value = it
                },
                {
                    mError.value = it
                }
            )
    }
}