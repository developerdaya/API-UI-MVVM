package com.roshi.apiui.ui.reset

import androidx.lifecycle.MutableLiveData
import com.roshi.apiui.modelResp.LoginResp
import com.roshi.apiui.modelResp.OtpResp
import com.roshi.apiui.modelResp.ResetResp
import com.sop.restuarnt.base.BaseViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class ResetVm() :BaseViewModel() {
    lateinit var disposable: Disposable
    val mSuccess = MutableLiveData<ResetResp>()
    val mError = MutableLiveData<Throwable>()
    val mProgress = MutableLiveData<Boolean>()

    fun hitReset(access_token: String, password: String) {

        disposable = api.hitReset(access_token, password)
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