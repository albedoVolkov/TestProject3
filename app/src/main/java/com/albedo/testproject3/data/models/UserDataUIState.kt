package com.albedo.testproject3.data.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.Gson
import com.google.gson.annotations.SerializedName
import java.util.Date

@Entity(tableName = "users")
data class UserDataUIState(
    @SerializedName("gender")
    @ColumnInfo(name = "gender")
    val gender : String = "",

    @SerializedName("name")
    @ColumnInfo(name = "name")
    val name : NameInner? = null,

    @SerializedName("location")
    @ColumnInfo(name = "location")
    val location : LocationInner? = null,

    @SerializedName("email")
    @ColumnInfo(name = "email")
    val email : String = "",

    @SerializedName("login")
    @ColumnInfo(name = "login")
    val login : LoginInner? = null,

    @SerializedName("dob")
    @ColumnInfo(name = "dob")
    val dob : DodInner? = null,

    @SerializedName("registered")
    @ColumnInfo(name = "registered")
    val registered : RegisteredInner? = null,

    @SerializedName("phone")
    @ColumnInfo(name = "phone")
    val phone : String = "",

    @SerializedName("cell")
    @ColumnInfo(name = "cell")
    val cell : String = "",

    @PrimaryKey
    @SerializedName("id")
    @ColumnInfo(name = "id")
    val id : IdInner? = null,

    @SerializedName("picture")
    @ColumnInfo(name = "picture")
    val picture : PictureInner? = null,

    @SerializedName("nat")
    @ColumnInfo(name = "nat")
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
)

data class LocationInner(
    @SerializedName("street")
    @ColumnInfo(name = "street")
    val street : StreetInner? = null,

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
    val coordinates : CoordinatesInner? = null,

    @SerializedName("timezone")
    @ColumnInfo(name = "timezone")
    val timezone : TimeZoneInner? = null,
)
data class StreetInner(
    @SerializedName("number")
    @ColumnInfo(name = "number")
    val number : Int = 0,

    @SerializedName("name")
    @ColumnInfo(name = "name")
    val name : String = "",
)
data class CoordinatesInner(
    @SerializedName("latitude")
    @ColumnInfo(name = "latitude")
    val latitude : Double = 0.0,

    @SerializedName("longitude")
    @ColumnInfo(name = "longitude")
    val longitude : Double = 0.0,
)
data class TimeZoneInner(
    val offset : String = "",
    val description : String = "",
)
data class DodInner(
    val date : Date? = null,
    val age : Int = 0,
)

data class LoginInner(
    val uuid : String = "",
    val username : String = "",
    val password : String = "",
    val salt : String = "",
    val md5 : String = "",
    val sha1 : String = "",
    val sha256 : String = "",
)

data class RegisteredInner(
    val date : Date? = null,
    val age : Int = 0,
)

data class IdInner(
    val name : String = "",
    val value : String = "",
)

data class PictureInner(
    val large : String = "",
    val medium : String = "",
    val thumbnail : String = "",
)



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