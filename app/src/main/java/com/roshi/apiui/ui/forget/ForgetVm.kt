package com.roshi.apiui.ui.forget

import androidx.lifecycle.MutableLiveData
import com.roshi.apiui.modelResp.ForgetResp
import com.roshi.apiui.modelResp.LoginResp
import com.roshi.apiui.modelResp.OtpResp
import com.sop.restuarnt.base.BaseViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class ForgetVm() :BaseViewModel() {
    lateinit var disposable: Disposable
    val mSuccess = MutableLiveData<ForgetResp>()
    val mError = MutableLiveData<Throwable>()
    val mProgress = MutableLiveData<Boolean>()

    fun hitForget(
        mobile_number: String,
        country_code: String
    ) {

        disposable = api.hitForget(
            mobile_number, country_code

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