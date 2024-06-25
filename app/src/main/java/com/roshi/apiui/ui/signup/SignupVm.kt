package com.roshi.apiui.ui.signup

import androidx.lifecycle.MutableLiveData
import com.roshi.apiui.modelResp.LoginResp
import com.roshi.apiui.modelResp.OtpResp
import com.roshi.apiui.modelResp.ResetResp
import com.roshi.apiui.modelResp.SignupResp
import com.sop.restuarnt.base.BaseViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class SignupVm() :BaseViewModel() {
    lateinit var disposable: Disposable
    val mSuccess = MutableLiveData<SignupResp>()
    val mError = MutableLiveData<Throwable>()
    val mProgress = MutableLiveData<Boolean>()

    fun hitSignup(
        userName: String,
        email: String,
        country_code: String,
        mobile_number: String,
        password: String,
        confirm_password: String,
        device_type: String,
        device_token: String,
        deliveryType: String,
    ) {

        disposable = api.hitSignup(
            userName,
            email,
            country_code,
            mobile_number,
            password ,
            confirm_password,
            device_type,
            device_token,
            deliveryType
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