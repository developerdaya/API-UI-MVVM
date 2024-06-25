package com.roshi.apiui.modelResp


import com.google.gson.annotations.SerializedName

data class SignupResp(
    @SerializedName("message")
    val message: String,
    @SerializedName("response")
    val response: Response,
    @SerializedName("status")
    val status: Boolean
) {
    data class Response(
        @SerializedName("access_token")
        val accessToken: String,
        @SerializedName("address")
        val address: Address,
        @SerializedName("city")
        val city: Any,
        @SerializedName("country_code")
        val countryCode: String,
        @SerializedName("created_on")
        val createdOn: Long,
        @SerializedName("deliveryType")
        val deliveryType: String,
        @SerializedName("deliveryVehicle")
        val deliveryVehicle: Any,
        @SerializedName("device_token")
        val deviceToken: String,
        @SerializedName("device_type")
        val deviceType: Int,
        @SerializedName("dob")
        val dob: Any,
        @SerializedName("email")
        val email: String,
        @SerializedName("full_name")
        val fullName: Any,
        @SerializedName("gender")
        val gender: Any,
        @SerializedName("_id")
        val id: String,
        @SerializedName("isAddedByAdmin")
        val isAddedByAdmin: Boolean,
        @SerializedName("isApprovedByAdmin")
        val isApprovedByAdmin: Int,
        @SerializedName("is_blocked")
        val isBlocked: Boolean,
        @SerializedName("isDutyOn")
        val isDutyOn: Boolean,
        @SerializedName("is_profile_created")
        val isProfileCreated: Int,
        @SerializedName("is_verified")
        val isVerified: Int,
        @SerializedName("latitude")
        val latitude: Any,
        @SerializedName("longitude")
        val longitude: Any,
        @SerializedName("mobile_number")
        val mobileNumber: String,
        @SerializedName("otpInfo")
        val otpInfo: OtpInfo,
        @SerializedName("password")
        val password: String,
        @SerializedName("profile_picture")
        val profilePicture: Any,
        @SerializedName("rejectReason")
        val rejectReason: Any,
        @SerializedName("updateAt")
        val updateAt: Long,
        @SerializedName("userName")
        val userName: String
    ) {
        data class Address(
            @SerializedName("buildingTower")
            val buildingTower: String,
            @SerializedName("houseNumber")
            val houseNumber: String,
            @SerializedName("locality")
            val locality: String,
            @SerializedName("zipCode")
            val zipCode: String
        )

        data class OtpInfo(
            @SerializedName("expTime")
            val expTime: String,
            @SerializedName("otp")
            val otp: String
        )
    }
}