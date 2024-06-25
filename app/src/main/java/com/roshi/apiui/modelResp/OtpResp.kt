package com.roshi.apiui.modelResp


import com.google.gson.annotations.SerializedName

data class OtpResp(
    @SerializedName("message")
    val message: String,
    @SerializedName("response")
    val response: Response,
    @SerializedName("status")
    val status: Boolean
) {
    class Response
}