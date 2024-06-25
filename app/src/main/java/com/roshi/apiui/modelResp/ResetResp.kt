package com.roshi.apiui.modelResp


import com.google.gson.annotations.SerializedName

data class ResetResp(
    @SerializedName("message")
    val message: String,
    @SerializedName("response")
    val response: Response,
    @SerializedName("status")
    val status: Boolean
) {
    class Response
}