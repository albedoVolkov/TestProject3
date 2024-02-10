package com.albedo.testproject3.services

import androidx.room.Insert
import androidx.room.TypeConverter
import com.albedo.testproject3.data.models.CoordinatesInner
import com.albedo.testproject3.data.models.DodInner
import com.albedo.testproject3.data.models.IdInner
import com.albedo.testproject3.data.models.LocationInner
import com.albedo.testproject3.data.models.LoginInner
import com.albedo.testproject3.data.models.NameInner
import com.albedo.testproject3.data.models.PictureInner
import com.albedo.testproject3.data.models.RegisteredInner
import com.albedo.testproject3.data.models.StreetInner
import com.albedo.testproject3.data.models.TimeZoneInner
import com.albedo.testproject3.data.models.UserDataUIState
import com.albedo.testproject3.data.models.fromStringToCoordinatesInnerItem
import com.albedo.testproject3.data.models.fromStringToDodInnerItem
import com.albedo.testproject3.data.models.fromStringToIdInnerItem
import com.albedo.testproject3.data.models.fromStringToLocationInnerItem
import com.albedo.testproject3.data.models.fromStringToLoginInnerItem
import com.albedo.testproject3.data.models.fromStringToNameInnerItem
import com.albedo.testproject3.data.models.fromStringToPictureInnerItem
import com.albedo.testproject3.data.models.fromStringToRegisteredInnerItem
import com.albedo.testproject3.data.models.fromStringToStreetInnerItem
import com.albedo.testproject3.data.models.fromStringToTimeZoneInnerItem
import com.albedo.testproject3.data.models.fromStringToUserDataUIStateItem
import javax.inject.Inject

class ListTypeConverter @Inject constructor(){
    @TypeConverter
    fun fromStringListToString(value: List<String>): String {
        return value.joinToString(separator = "||,||")
    }
    @TypeConverter
    fun fromStringToStringList(value: String): List<String> {

        if (value == "" || value == "[]" || value == "null"){
            return listOf()
        }
        return value.split("||,||").map { it }
    }



    @TypeConverter
    fun fromStringToIntList(value: String): List<Int> {
        if (value == ""){
            return listOf()
        }
        return value.split("||,||").map { it.toInt() }
    }
    @TypeConverter
    fun fromIntListToString(value: List<Int>): String {
        return value.joinToString(separator = "||,||")
    }




    @TypeConverter
    fun fromUserDataUIStateListToString(value: List<UserDataUIState>): String {
        return value.joinToString(separator = "||,||")
    }
    @TypeConverter
    fun fromStringToUserDataUIStateList(value: String): List<UserDataUIState> {
        if (value == "" || value == "[]" || value == "null"){
            return listOf()
        }
        return value.split("||,||").map { fromStringToUserDataUIStateItem(it)!! }
    }


    @TypeConverter
    fun fromUserDataUIStateToString(value: UserDataUIState): String { return value.toString() }

    @TypeConverter
    fun fromStringToUserDataUIState(value: String): UserDataUIState { return fromStringToUserDataUIStateItem(value)!! }




//    NameInner::class,
//    LocationInner::class,
//    StreetInner::class,
//    CoordinatesInner::class,
//    TimeZoneInner::class,
//    DodInner::class,
//    LoginInner::class,
//    RegisteredInner::class,
//    IdInner::class,
//    PictureInner::class


    @TypeConverter
    fun fromNameInnerToString(value: NameInner): String { return value.toString() }
    @TypeConverter
    fun fromStringToNameInner(value: String): NameInner { return fromStringToNameInnerItem(value)!! }

    @TypeConverter
    fun fromLocationInnerToString(value: LocationInner): String { return value.toString() }
    @TypeConverter
    fun fromStringToLocationInner(value: String): LocationInner { return fromStringToLocationInnerItem(value)!! }

    @TypeConverter
    fun fromStreetInnerToString(value: StreetInner): String { return value.toString() }
    @TypeConverter
    fun fromStringToStreetInner(value: String): StreetInner { return fromStringToStreetInnerItem(value)!! }

    @TypeConverter
    fun fromCoordinatesInnerToString(value: CoordinatesInner): String { return value.toString() }
    @TypeConverter
    fun fromStringToCoordinatesInner(value: String): CoordinatesInner { return fromStringToCoordinatesInnerItem(value)!! }

    @TypeConverter
    fun fromTimeZoneInnerString(value: TimeZoneInner): String { return value.toString() }
    @TypeConverter
    fun fromStringToTimeZoneInner(value: String): TimeZoneInner { return fromStringToTimeZoneInnerItem(value)!! }

    @TypeConverter
    fun fromDodInnerToString(value: DodInner): String { return value.toString() }
    @TypeConverter
    fun fromStringToDodInner(value: String): DodInner { return fromStringToDodInnerItem(value)!! }

    @TypeConverter
    fun fromLoginInnerToString(value: LoginInner): String { return value.toString() }
    @TypeConverter
    fun fromStringToLoginInner(value: String): LoginInner { return fromStringToLoginInnerItem(value)!! }

    @TypeConverter
    fun fromRegisteredInnerToString(value: RegisteredInner): String { return value.toString() }
    @TypeConverter
    fun fromStringToRegisteredInner(value: String): RegisteredInner { return fromStringToRegisteredInnerItem(value)!! }

    @TypeConverter
    fun fromIdInnerToString(value: IdInner): String { return value.toString() }
    @TypeConverter
    fun fromStringToIdInner(value: String): IdInner { return fromStringToIdInnerItem(value)!! }

    @TypeConverter
    fun fromPictureInnerToString(value: PictureInner): String { return value.toString() }
    @TypeConverter
    fun fromStringToPictureInner(value: String): PictureInner { return fromStringToPictureInnerItem(value)!! }




}