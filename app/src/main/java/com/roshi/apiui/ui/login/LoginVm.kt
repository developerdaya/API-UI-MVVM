package com.roshi.apiui.ui.login

import androidx.lifecycle.MutableLiveData
import com.roshi.apiui.modelResp.LoginResp
import com.sop.restuarnt.base.BaseViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class LoginVm() :BaseViewModel() {
    lateinit var disposable: Disposable
    val mSuccess = MutableLiveData<LoginResp>()
    val mError = MutableLiveData<Throwable>()
    val mProgress = MutableLiveData<Boolean>()

    fun hitLogin(
        country_code: String,
        mobile_number: String,
        password: String,
        latitude: String,
        longitude: String,
    ) {

        disposable = api.hitLogin(
            country_code,
            mobile_number,
            password,
            latitude,
            longitude
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