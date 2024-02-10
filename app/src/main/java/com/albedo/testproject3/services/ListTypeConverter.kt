package com.albedo.testproject3.services

import androidx.room.TypeConverter
import com.albedo.testproject3.data.models.UserUIState
import com.albedo.testproject3.data.models.fromStringToUserUIStateItem
import com.google.gson.Gson
import java.util.Date
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
    fun fromUserUIStateListToString(value: List<UserUIState>): String {
        return value.joinToString(separator = "||,||")
    }
    @TypeConverter
    fun fromStringToUserUIStateList(value: String): List<UserUIState> {
        if (value == "" || value == "[]" || value == "null"){
            return listOf()
        }
        return value.split("||,||").map { fromStringToUserUIStateItem(it)!! }
    }


    @TypeConverter
    fun fromUserUIStateToString(value: UserUIState): String { return value.toString() }

    @TypeConverter
    fun fromStringToUserUIState(value: String): UserUIState { return fromStringToUserUIStateItem(value)!! }

    @TypeConverter
    fun fromDateToString(value: Date): String { return Gson().toJson(value,Date::class.java) }

    @TypeConverter
    fun fromStringToDate(value: String): Date { return Gson().fromJson(value,Date::class.java) }


}