package com.sop.restuarnt.util
import com.roshi.apiui.modelResp.*
import io.reactivex.Observable
import retrofit2.http.*

interface ApiInterface {

    @FormUrlEncoded
    @POST("delivery/signup")
    fun hitSignup(
        @Field("userName")userName:String,
        @Field("email")email:String,
        @Field("country_code")country_code:String,
        @Field("mobile_number")mobile_number:String,
        @Field("password")password:String,
        @Field("confirm_password")confirm_password:String,
        @Field("device_type")device_type:String,
        @Field("device_token")device_token:String,
        @Field("deliveryType")deliveryType:String,
    ):Observable<SignupResp>



    @FormUrlEncoded
    @POST("delivery/login")
    fun hitLogin(
        @Field("country_code")country_code:String,
        @Field("mobile_number")mobile_number:String,
        @Field("password")password:String,
        @Field("latitude")latitude:String,
        @Field("longitude")longitude:String
    ):Observable<LoginResp>


       @FormUrlEncoded
    @POST("delivery/forgetPassword")
    fun hitForget(
        @Field("mobile_number")mobile_number:String,
        @Field("country_code")country_code:String
    ):Observable<ForgetResp>


   @FormUrlEncoded
    @POST("delivery/otpVerification")
    fun hitOtp(
       @Header("access_token")access_token:String,
       @Field("otp")otp:String
    ):Observable<OtpResp>


   @FormUrlEncoded
    @POST("delivery/resetPassword")
    fun hitReset(
       @Header("access_token")access_token:String,
       @Field("password")password:String
    ):Observable<ResetResp>





}