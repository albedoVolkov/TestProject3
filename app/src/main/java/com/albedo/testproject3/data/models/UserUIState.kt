package com.albedo.testproject3.data.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.albedo.testproject3.services.ConstantsSource
import com.google.gson.Gson
import com.google.gson.annotations.SerializedName
import java.util.Date

@Entity(tableName = ConstantsSource.USERS_ROOM_TABLE_NAME)
data class UserUIState(

    @PrimaryKey
    @SerializedName("id")
    val id : String = "",

    @SerializedName("gender")
    val gender : String = "",

    @SerializedName("first")
    val first : String = "",

    @SerializedName("last")
    val last : String = "",

    @SerializedName("title")
    val title : String = "",

    @ColumnInfo(name = "streetNumber")
    val streetNumber : Int = 0,

    @ColumnInfo(name = "streetName")
    val streetName : String = "",

    @ColumnInfo(name = "city")
    val city : String = "",

    @ColumnInfo(name = "state")
    val state : String = "",

    @ColumnInfo(name = "country")
    val country : String = "",

    @ColumnInfo(name = "postcode")
    val postcode : String = "",

    @ColumnInfo(name = "locationLatitude")
    val locationLatitude : Double = 0.0,

    @ColumnInfo(name = "locationLongitude")
    val locationLongitude : Double = 0.0,

    @ColumnInfo(name = "offset")
    val timeZoneOffset : String = "",

    @ColumnInfo(name = "timeZoneDescription")
    val timeZoneDescription : String = "",

    @SerializedName("email")
    val email : String = "",

    @ColumnInfo(name = "uuid")
    val uuid : String = "",

    @ColumnInfo(name = "username")
    val username : String = "",

    @ColumnInfo(name = "password")
    val password : String = "",

    @ColumnInfo(name = "salt")
    val salt : String = "",

    @ColumnInfo(name = "md5")
    val md5 : String = "",

    @ColumnInfo(name = "sha1")
    val sha1 : String = "",

    @ColumnInfo(name = "sha256")
    val sha256 : String = "",

    @ColumnInfo(name = "bodDate")
    val bodDate : Date = Date(0L),

    @ColumnInfo(name = "bodAge")
    val bodAge : Int = 0,

    @ColumnInfo(name = "registrationDate")
    val registrationDate : Date = Date(0L),

    @ColumnInfo(name = "registrationAge")
    val registrationAge : Int = 0,

    @SerializedName("phone")
    val phone : String = "",

    @SerializedName("cell")
    val cell : String = "",

    @ColumnInfo(name = "large")
    val large : String = "",

    @ColumnInfo(name = "medium")
    val medium : String = "",

    @ColumnInfo(name = "thumbnail")
    val thumbnail : String = "",

    @SerializedName("nat")
    val nat : String = "",
    ){
        override fun toString(): String {
            return Gson().toJson(this)
        }
    }

    fun fromStringToUserUIStateItem(string: String): UserUIState? {
        return try {
            Gson().fromJson(string, UserUIState::class.java)
        }catch(e : Exception){ null }
    }
