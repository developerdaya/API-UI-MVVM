package com.sop.restuarnt.base
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sop.restuarnt.util.ApiInterface
import com.sop.restuarnt.util.RetrofitUtils


open class BaseViewModel: ViewModel() {

    val throwable = MutableLiveData<Throwable>()
    val success = MutableLiveData<Any>()

    val api : ApiInterface by lazy {
        RetrofitUtils.createBaseApiService()
    }

}