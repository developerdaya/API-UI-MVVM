package com.sop.restuarnt.util

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences
import android.util.Log

class SharedPreferenceUtility
private constructor(context: Context) {
    val TAG = SharedPreferenceUtility::class.java.simpleName
    private val sharedPreferences: SharedPreferences =
        context.getSharedPreferences("sop Restaurant", Context.MODE_PRIVATE)
    val editor: SharedPreferences.Editor = sharedPreferences.edit()

    companion object {

        @SuppressLint("StaticFieldLeak")
        private var instance: SharedPreferenceUtility? = null

        fun getInstance(context: Context): SharedPreferenceUtility {
            if (instance == null) {
                instance = SharedPreferenceUtility(context)
            }
            return instance!!
        }
    }

    /*...................Project Utility Info.........................*/

    var mStartDuty: Boolean
        get() = sharedPreferences["mStartDuty",false]!!
        set(value) = sharedPreferences.set("mStartDuty", value)


    var mRestEmail: String
        get() = sharedPreferences["mRestEmail"]!!
        set(value) = sharedPreferences.set("mRestEmail", value)

    var mRestPhone: String
        get() = sharedPreferences["mRestPhone"]!!
        set(value) = sharedPreferences.set("mRestPhone", value)

    var mRestCountryCode: Int
        get() = sharedPreferences["mRestCountryCode"]!!
        set(value) = sharedPreferences.set("mRestCountryCode", value)


  var mDriverName: String
        get() = sharedPreferences["mDriverName"]!!
        set(value) = sharedPreferences.set("mDriverName", value)

  var mQuantity: Int
        get() = sharedPreferences["mQuantity",0]!!
        set(value) = sharedPreferences.set("mQuantity", value)

  var isLogin: Boolean
        get() = sharedPreferences["isLogin",false]!!
        set(value) = sharedPreferences.set("isLogin", value)

      var isHomePageVisible: Boolean
        get() = sharedPreferences["isHomePageVisible",false]!!
        set(value) = sharedPreferences.set("isHomePageVisible", value)




     var isLoginFromRest: Boolean
        get() = sharedPreferences["isLoginFromRest",false]!!
        set(value) = sharedPreferences.set("isLoginFromRest", value)

 var restaurantLocation: String
        get() = sharedPreferences["restaurantLocation",""]!!
        set(value) = sharedPreferences.set("restaurantLocation", value)



  var isLocationFirst: Boolean
        get() = sharedPreferences["isLocationFirst",true]!!
        set(value) = sharedPreferences.set("isLocationFirst", value)

  var isCreateProfileFirst: Boolean
        get() = sharedPreferences["isCreateProfileFirst",true]!!
        set(value) = sharedPreferences.set("isCreateProfileFirst", value)


  var isAddressFirst: Boolean
        get() = sharedPreferences["isAddressFirst",false]!!
        set(value) = sharedPreferences.set("isAddressFirst", value)


// Save Driver data
var mDriverProfileImg: String
    get() = sharedPreferences["mDriverProfileImg"]!!
    set(value) = sharedPreferences.set("mDriverProfileImg", value)

var mDriverFullName: String
    get() = sharedPreferences["mDriverFullName"]!!
    set(value) = sharedPreferences.set("mDriverFullName", value)

var mDriverPhoneNo: String
    get() = sharedPreferences["mDriverPhoneNo"]!!
    set(value) = sharedPreferences.set("mDriverPhoneNo", value)

var mDriverEmail: String
    get() = sharedPreferences["mDriverEmail"]!!
    set(value) = sharedPreferences.set("mDriverEmail", value)

var mDriverDOB: String
    get() = sharedPreferences["mDriverDOB"]!!
    set(value) = sharedPreferences.set("mDriverDOB", value)



var mHouseNum: String
    get() = sharedPreferences["mHouseNum"]!!
    set(value) = sharedPreferences.set("mHouseNum", value)

var mBuildingTower: String
    get() = sharedPreferences["mBuildingTower"]!!
    set(value) = sharedPreferences.set("mBuildingTower", value)

var mLocality: String
    get() = sharedPreferences["mLocality"]!!
    set(value) = sharedPreferences.set("mLocality", value)

var mZipCode: String
    get() = sharedPreferences["mZipCode"]!!
    set(value) = sharedPreferences.set("mZipCode", value)

    var isVehicleDetailsFirst: Boolean
        get() = sharedPreferences["isVehicleDetailsFirst",true]!!
        set(value) = sharedPreferences.set("isVehicleDetailsFirst", value)









    var vehicleImages1: String
        get() = sharedPreferences["vehicleImages"]!!
        set(value) = sharedPreferences.set("vehicleImages", value)




       var vehicleImages2: String
        get() = sharedPreferences["vehicleImages"]!!
        set(value) = sharedPreferences.set("vehicleImages", value)

       var vehicleImages3: String
        get() = sharedPreferences["vehicleImages"]!!
        set(value) = sharedPreferences.set("vehicleImages", value)

       var vehicleImages4: String
        get() = sharedPreferences["vehicleImages"]!!
        set(value) = sharedPreferences.set("vehicleImages", value)



    var vehicleType: String
        get() = sharedPreferences["vehicleType", ""]!!
        set(value) = sharedPreferences.set("vehicleType", value)


    var registrationNumber: String
        get() = sharedPreferences["registrationNumber", ""]!!
        set(value) = sharedPreferences.set("registrationNumber", value)

     var registrationExpiry: String
        get() = sharedPreferences["registrationNumber", ""]!!
        set(value) = sharedPreferences.set("registrationNumber", value)


    var mInsuranceName: String
        get() = sharedPreferences["mInsuranceName", ""]!!
        set(value) = sharedPreferences.set("mInsuranceName", value)


    var mInsuranceExpiry: String
        get() = sharedPreferences["mInsuranceExpiry", ""]!!
        set(value) = sharedPreferences.set("mInsuranceExpiry", value)

  var mDrivingLicenceNum: String
        get() = sharedPreferences["mDrivingLicenceNum", ""]!!
        set(value) = sharedPreferences.set("mDrivingLicenceNum", value)


      var mDrivingLicenceExpiry: String
        get() = sharedPreferences["mDrivingLicenceExpiry", ""]!!
        set(value) = sharedPreferences.set("mDrivingLicenceExpiry", value)





    var isFrom: String
        get() = sharedPreferences["isFrom", ""]!!
        set(value) = sharedPreferences.set("isFrom", value)

      var isFromDelChangePass: Boolean
        get() = sharedPreferences["isFromDelChangePass", false]!!
        set(value) = sharedPreferences.set("isFromDelChangePass", value)



    var mProfileType: String
        get() = sharedPreferences["mProfileType", ""]!!
        set(value) = sharedPreferences.set("mProfileType", value)

    var isForEditProfile: Boolean
        get() = sharedPreferences["isForEditProfile", false]!!
        set(value) = sharedPreferences.set("isForEditProfile", value)




 var isFromChangePass: Boolean
        get() = sharedPreferences["isFromChangePass", false]!!
        set(value) = sharedPreferences.set("isFromChangePass", value)

    var isFromAfterCreated: Boolean
        get() = sharedPreferences["isFromAfterCreated", false]!!
        set(value) = sharedPreferences.set("isFromAfterCreated", value)



var isFromForgotPass: Boolean
        get() = sharedPreferences["isFromForgotPass", false]!!
        set(value) = sharedPreferences.set("isFromForgotPass", value)


    var isRestaurantFirst: Boolean
        get() = sharedPreferences["isRestaurantFirst", false]!!
        set(value) = sharedPreferences.set("isRestaurantFirst", value)


  var isFromRestaurant: Boolean
        get() = sharedPreferences["isFromRestaurant", false]!!
        set(value) = sharedPreferences.set("isFromRestaurant", value)





    var pastTimeMillis: String
        get() = sharedPreferences["pastTimeMillis", ""]!!
        set(value) = sharedPreferences.set("pastTimeMillis", value)

    var accessToken: String
        get() = sharedPreferences["accessToken", ""]!!
        set(value) = sharedPreferences.set("accessToken", value)

        var accessTokenFix: String
        get() = sharedPreferences["accessTokenFix", ""]!!
        set(value) = sharedPreferences.set("accessTokenFix", value)



    var isDutyOn: Boolean
        get() = sharedPreferences["isDutyOn", true]!!
        set(value) = sharedPreferences.set("isDutyOn", value)

    var latitude: String?
        get() = sharedPreferences["latitude", ""]!!
        set(value) = sharedPreferences.set("latitude", value)

    var longitude: String?
        get() = sharedPreferences["longitude", ""]!!
        set(value) = sharedPreferences.set("longitude", value)

    var driverProfilePicture: String?
        get() = sharedPreferences["driverProfilePicture", ""]!!
        set(value) = sharedPreferences.set("driverProfilePicture", value)

    var driverProfilePictureServer: String?
        get() = sharedPreferences["driverProfilePicture"]!!
        set(value) = sharedPreferences.set("driverProfilePicture", value)

    var fromSignup: String // for OTP Screen
        get() = sharedPreferences["fromSignup", ""]!!
        set(value) = sharedPreferences.set("fromSignup", value)



    var rememberMeCheck: Boolean
        get() = sharedPreferences["rememberMeCheck", false]!!
        set(value) = sharedPreferences.set("rememberMeCheck", value)

    var rememberEmail: String?
        get() = sharedPreferences["rememberEmail", ""]!!
        set(value) = sharedPreferences.set("rememberEmail", value)

    var rememberPassword: String?
        get() = sharedPreferences["rememberPassword", ""]!!
        set(value) = sharedPreferences.set("rememberPassword", value)

    var isAddressLocationFirst: Boolean
        get() = sharedPreferences["isAddressLocationFirst", true]!!
        set(value) = sharedPreferences.set("isAddressLocationFirst", value)

    var isProfileDetailsFirst: Boolean
        get() = sharedPreferences["isProfileDetailsFirst", true]!!
        set(value) = sharedPreferences.set("isProfileDetailsFirst", value)


    /* ...............................................................*/


    /* ..................Save Driver-Signup Data......................*/


    var driverId: String
        get() = sharedPreferences["userId", ""]!!
        set(value) = sharedPreferences.set("userId", value)

    var driverFirstName: String
        get() = sharedPreferences["driverFirstName", ""]!!
        set(value) = sharedPreferences.set("driverFirstName", value)

    var driverLastName: String
        get() = sharedPreferences["driverLastName", ""]!!
        set(value) = sharedPreferences.set("driverLastName", value)


    var driverMobile: String
        get() = sharedPreferences["mobileNumber", ""]!!
        set(value) = sharedPreferences.set("mobileNumber", value)

    var driverEmail: String
        get() = sharedPreferences["emailId", ""]!!
        set(value) = sharedPreferences.set("emailId", value)

    var driverCountryCode: String
        get() = sharedPreferences["countryCode", ""]!!
        set(value) = sharedPreferences.set("countryCode", value)

    /* ...............................................................*/


    /* ..................Save Driver Location......................*/


    var addressLocation: String?
        get() = sharedPreferences["addressLocation", ""]!!
        set(value) = sharedPreferences.set("addressLocation", value)


    var buildingNo: String?
        get() = sharedPreferences["buildingNo", ""]!!
        set(value) = sharedPreferences.set("buildingNo", value)

    var landmark: String?
        get() = sharedPreferences["landmark", ""]!!
        set(value) = sharedPreferences.set("landmark", value)

    var sector: String
        get() = sharedPreferences["sector", ""]!!
        set(value) = sharedPreferences.set("sector", value)

    var city: String
        get() = sharedPreferences["city", ""]!!
        set(value) = sharedPreferences.set("city", value)

    var state: String
        get() = sharedPreferences["state", ""]!!
        set(value) = sharedPreferences.set("state", value)

    var postalCode: String
        get() = sharedPreferences["postalCode"]!!
        set(value) = sharedPreferences.set("postalCode", value)

    var countryName: String
        get() = sharedPreferences["countryName", ""]!!
        set(value) = sharedPreferences.set("countryName", value)
    /* ...............................................................*/


    operator fun SharedPreferences.set(key: String, value: Any?) {
        when (value) {
            is String? -> edit { it.putString(key, value) }
            is Int -> edit { it.putInt(key, value) }
            is Boolean -> edit { it.putBoolean(key, value) }
            is Float -> edit { it.putFloat(key, value) }
            is Long -> edit { it.putLong(key, value) }
            else -> Log.e(TAG, "Setting shared pref failed for key: $key and value: $value ")
        }
    }

    private inline fun SharedPreferences.edit(operation: (SharedPreferences.Editor) -> Unit) {
        val editor = this.edit()
        operation(editor)
        editor.apply()
    }


    inline operator fun <reified T : Any> SharedPreferences.get(
        key: String,
        defaultValue: T? = null
    ): T? {
        return when (T::class) {
            String::class -> getString(key, defaultValue as? String) as T?
            Int::class -> getInt(key, defaultValue as? Int ?: -1) as T?
            Boolean::class -> getBoolean(key, defaultValue as? Boolean ?: false) as T?
            Float::class -> getFloat(key, defaultValue as? Float ?: -1f) as T?
            Long::class -> getLong(key, defaultValue as? Long ?: -1) as T?
            else -> throw UnsupportedOperationException("Not yet implemented")
        }
    }



    fun deletePreferences() {
        editor.clear()
        editor.apply()
        editor.commit()
    }
}