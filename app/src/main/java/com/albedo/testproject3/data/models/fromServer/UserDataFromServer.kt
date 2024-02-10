package com.albedo.testproject3.data.models.fromServer

import androidx.room.ColumnInfo
import com.google.gson.Gson
import com.google.gson.annotations.SerializedName
import java.util.Date

data class UserDataUIState(

    @SerializedName("gender")
    val gender : String = "",

    @SerializedName("name")
    val name : NameInner = NameInner(),

    @SerializedName("location")
    val location : LocationInner = LocationInner(),

    @SerializedName("email")
    val email : String = "",

    @SerializedName("login")
    val login : LoginInner = LoginInner(),

    @SerializedName("dob")
    val dob : DodInner = DodInner(),

    @SerializedName("registered")
    val registered : RegisteredInner = RegisteredInner(),

    @SerializedName("phone")
    val phone : String = "",

    @SerializedName("cell")
    val cell : String = "",

    @SerializedName("id")
    val id : IdInner = IdInner(),

    @SerializedName("picture")
    val picture : PictureInner = PictureInner(),

    @SerializedName("nat")
    val nat : String = "",
    ){
    override fun toString(): String {
        return Gson().toJson(this)
    }
}

fun fromStringToUserDataUIStateItem(string: String): UserDataUIState? {
    return try {
        Gson().fromJson(string, UserDataUIState::class.java)
    }catch(e : Exception){ null }
}




data class NameInner(
    @SerializedName("title")
    @ColumnInfo(name = "title")
    val title : String = "",

    @SerializedName("first")
    @ColumnInfo(name = "first")
    val first : String = "",

    @SerializedName("last")
    @ColumnInfo(name = "last")
    val last : String = "",
){
    override fun toString(): String {
        return Gson().toJson(this)
    }
}

fun fromStringToNameInnerItem(string: String): NameInner? {
    return try {
        Gson().fromJson(string, NameInner::class.java)
    }catch(e : Exception){ null }
}


data class LocationInner(
    @SerializedName("street")
    @ColumnInfo(name = "street")
    val street : StreetInner = StreetInner(0,""),

    @SerializedName("city")
    @ColumnInfo(name = "city")
    val city : String = "",

    @SerializedName("state")
    @ColumnInfo(name = "state")
    val state : String = "",

    @SerializedName("country")
    @ColumnInfo(name = "country")
    val country : String = "",

    @SerializedName("postcode")
    @ColumnInfo(name = "postcode")
    val postcode : String = "",

    @SerializedName("coordinates")
    @ColumnInfo(name = "coordinates")
    val coordinates : CoordinatesInner = CoordinatesInner(0.0,0.0),

    @SerializedName("timezone")
    @ColumnInfo(name = "timezone")
    val timezone : TimeZoneInner = TimeZoneInner("",""),
){
    override fun toString(): String {
        return Gson().toJson(this)
    }
}

fun fromStringToLocationInnerItem(string: String): LocationInner? {
    return try {
        Gson().fromJson(string, LocationInner::class.java)
    }catch(e : Exception){ null }
}





data class StreetInner(
    @SerializedName("number")
    @ColumnInfo(name = "number")
    val number : Int = 0,

    @SerializedName("name")
    @ColumnInfo(name = "name")
    val name : String = "",
){
    override fun toString(): String {
        return Gson().toJson(this)
    }
}

fun fromStringToStreetInnerItem(string: String): StreetInner? {
    return try {
        Gson().fromJson(string, StreetInner::class.java)
    }catch(e : Exception){ null }
}



data class CoordinatesInner(
    @SerializedName("latitude")
    @ColumnInfo(name = "latitude")
    val latitude : Double = 0.0,

    @SerializedName("longitude")
    @ColumnInfo(name = "longitude")
    val longitude : Double = 0.0,
){
    override fun toString(): String {
        return Gson().toJson(this)
    }
}

fun fromStringToCoordinatesInnerItem(string: String): CoordinatesInner? {
    return try {
        Gson().fromJson(string, CoordinatesInner::class.java)
    }catch(e : Exception){ null }
}




data class TimeZoneInner(
    @SerializedName("offset")
    @ColumnInfo(name = "offset")
    val offset : String = "",
    @SerializedName("description")
    @ColumnInfo(name = "description")
    val description : String = "",
){
    override fun toString(): String {
        return Gson().toJson(this)
    }
}

fun fromStringToTimeZoneInnerItem(string: String): TimeZoneInner? {
    return try {
        Gson().fromJson(string, TimeZoneInner::class.java)
    }catch(e : Exception){ null }
}




data class DodInner(
    @SerializedName("date")
    @ColumnInfo(name = "date")
    val date : Date = Date(0L),
    @SerializedName("age")
    @ColumnInfo(name = "age")
    val age : Int = 0,
){
    override fun toString(): String {
        return Gson().toJson(this)
    }
}

fun fromStringToDodInnerItem(string: String): DodInner? {
    return try {
        Gson().fromJson(string, DodInner::class.java)
    }catch(e : Exception){ null }
}

data class LoginInner(
    @SerializedName("uuid")
    @ColumnInfo(name = "uuid")
    val uuid : String = "",
    @SerializedName("username")
    @ColumnInfo(name = "username")
    val username : String = "",
    @SerializedName("password")
    @ColumnInfo(name = "password")
    val password : String = "",
    @SerializedName("salt")
    @ColumnInfo(name = "salt")
    val salt : String = "",
    @SerializedName("md5")
    @ColumnInfo(name = "md5")
    val md5 : String = "",
    @SerializedName("sha1")
    @ColumnInfo(name = "sha1")
    val sha1 : String = "",
    @SerializedName("sha256")
    @ColumnInfo(name = "sha256")
    val sha256 : String = "",
){
    override fun toString(): String {
        return Gson().toJson(this)
    }
}

fun fromStringToLoginInnerItem(string: String): LoginInner? {
    return try {
        Gson().fromJson(string, LoginInner::class.java)
    }catch(e : Exception){ null }
}

data class RegisteredInner(
    @SerializedName("date")
    @ColumnInfo(name = "date")
    val date : Date = Date(0L),
    @SerializedName("age")
    @ColumnInfo(name = "age")
    val age : Int = 0,
){
    override fun toString(): String {
        return Gson().toJson(this)
    }
}

fun fromStringToRegisteredInnerItem(string: String): RegisteredInner? {
    return try {
        Gson().fromJson(string, RegisteredInner::class.java)
    }catch(e : Exception){ null }
}


data class IdInner(
    @SerializedName("name")
    @ColumnInfo(name = "name")
    val name : String = "",
    @SerializedName("value")
    @ColumnInfo(name = "value")
    val value : String = "",
){
    override fun toString(): String {
        return Gson().toJson(this)
    }
}

fun fromStringToIdInnerItem(string: String): IdInner? {
    return try {
        Gson().fromJson(string, IdInner::class.java)
    }catch(e : Exception){ null }
}

data class PictureInner(
    @SerializedName("large")
    @ColumnInfo(name = "large")
    val large : String = "",
    @SerializedName("medium")
    @ColumnInfo(name = "medium")
    val medium : String = "",
    @SerializedName("thumbnail")
    @ColumnInfo(name = "thumbnail")
    val thumbnail : String = "",
){
    override fun toString(): String {
        return Gson().toJson(this)
    }
}

fun fromStringToPictureInnerItem(string: String): PictureInner? {
    return try {
        Gson().fromJson(string, PictureInner::class.java)
    }catch(e : Exception){ null }
}




//    "gender":"male",
//    "name":{"title":"Mr","first":"Lucas","last":"Lam"},
//    "location":{
//        "street":{"number":4350,"name":"Coastal Highway"},
//        "city":"Field",
//        "state":"Northwest Territories",
//        "country":"Canada",
//        "postcode":"K7W 1T7",
//        "coordinates":{"latitude":"-66.8065","longitude":"-30.7499"},
//        "timezone":{"offset":"-1:00","description":"Azores, Cape Verde Islands"}
//    },
//    "email":"lucas.lam@example.com",
//    "login":{
//        "uuid":"9766456c-71fc-4f98-9d6c-b9b1cb2b2264",
//        "username":"happysnake729",
//        "password":"smackdow",
//        "salt":"Ce0X9MGM",
//        "md5":"3e2090585b55f142fea12a512103da5f",
//        "sha1":"1324582bc4ae6731dedb734d62cf20727a237bc0",
//        "sha256":"b9b0aaf8ab448e9e98b637b1644f0462b717e552ca00d3b2a183e21e63585870"
//    },
//    "dob":{"date":"1979-05-28T14:44:50.118Z","age":44},
//    "registered":{"date":"2017-03-06T06:35:51.613Z","age":6},
//    "phone":"U71 S11-3246",
//    "cell":"Q10 M94-3340",
//    "id":{"name":"SIN","value":"947514337"},
//    "picture":{
//        "large":"https://randomuser.me/api/portraits/men/9.jpg",
//        "medium":"https://randomuser.me/api/portraits/med/men/9.jpg",
//        "thumbnail":"https://randomuser.me/api/portraits/thumb/men/9.jpg"
//    },
//    "nat":"CA"
//},