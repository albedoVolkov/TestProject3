package com.albedo.testproject3.services

import androidx.room.TypeConverter
import com.albedo.testproject3.data.models.UserDataUIState
import com.albedo.testproject3.data.models.fromStringToUserDataUIStateItem

class ListTypeConverter {
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




}