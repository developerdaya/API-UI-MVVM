package com.sop.restuarnt.util
import android.content.Context
import android.util.Log
import android.widget.Toast
import com.sop.restuarnt.util.GsonUtil.getGsonInstance
import retrofit2.HttpException
import java.net.ConnectException
import java.net.SocketTimeoutException
import java.net.UnknownHostException

object ErrorUtil {
    val TAG = ErrorUtil::class.simpleName
    fun handlerGeneralError(context: Context?, throwable: Throwable) {
        Log.e(TAG, "Error: ${throwable.message}")
        throwable.printStackTrace()
        if (context == null) return
        when (throwable) {

            /*:::::For Display Toast:::::*/
            is ConnectException -> {
                Toast.makeText(context, "Network error pLease again try later.", Toast.LENGTH_SHORT).show()
            }
            is SocketTimeoutException ->
                    Toast.makeText(context, "Connection lost pLease again try later.", Toast.LENGTH_SHORT).show()

            is UnknownHostException, is InternalError ->

            Toast.makeText(context, "Server error pLease try again later.", Toast.LENGTH_SHORT).show()
                    is HttpException -> {
                try {
                    when (throwable.code()) {
                        401 -> {
                            /*:::::Logout:::::*/
                            Toast.makeText(context, "Something went wrong , Please Sign In Again", Toast.LENGTH_SHORT).show()

                        }
                         403-> {
                            /*:::::Testing:::::*/
                             Toast.makeText(context, "Invalid Credential", Toast.LENGTH_SHORT).show()
                         }

                        422->
                           {
                            /*:::::Testing:::::*/
                             Toast.makeText(context, "User already registered", Toast.LENGTH_SHORT).show()
                         }



                        else -> {
                            displayError(context, throwable)
                        }
                    }
                } catch (exception: Exception) {
                    Log.e("error", exception.toString())
                }
            }
            else -> {
                Toast.makeText(context, "Something went wrong please retry", Toast.LENGTH_SHORT).show()
               }
            }
    }

    private fun displayError(context: Context, exception: HttpException) {
        Log.i(TAG, "displayError()")
        try {
            val errorBody = getGsonInstance().fromJson(
                exception.response()!!.errorBody()?.charStream(), ErrorBean::class.java
            )

            if (!errorBody.error.isNullOrEmpty()){
                Toast.makeText(context, errorBody.error, Toast.LENGTH_SHORT).show()

            }
            else
            {
                Toast.makeText(context, errorBody.message, Toast.LENGTH_SHORT).show()

            }

        } catch (e: Exception) {
            Log.e("MyExceptions", e.message!!)
            Toast.makeText(context, "Something went wrong please retry", Toast.LENGTH_SHORT).show()

        }
    }
}

data class ErrorBean(var message: String, var error: String)


