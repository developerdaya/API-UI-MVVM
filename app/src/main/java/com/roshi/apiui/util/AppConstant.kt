package com.roshi.apiui.util

object AppConstant {
    const val BASE_URL = "http://3.105.27.34:3001/"

    const val EMAIL_PATTERN = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9-]{2,3})\$"

    const val WEBSITE_PATTERN = "^[_A-Za-z0-9-]+(\\.[A-Za-z0-9-]{2,3})\$"
    const val PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{4,}$"
    const val NUMBER_PATTERN = "^[0-9]*$"
    const val NAME_PATTERN = "^[A-Za-z ]*$"
}