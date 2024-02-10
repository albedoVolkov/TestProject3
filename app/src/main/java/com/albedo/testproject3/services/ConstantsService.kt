package com.albedo.testproject3.services

object ConstantsSource {

    //dataBase
    const val USERS_ROOM_TABLE_NAME = "UsersListRoom"

    //sessionManager
    const val USER_SESSION_DATA = "UserSessionData"
    const val NoNeedToUpdate = "NoNeedToUpdate"

    //internetConnection
    const val INTERNET_TRANSPORT_CELLULAR = "NetworkCapabilities.TRANSPORT_CELLULAR"
    const val INTERNET_TRANSPORT_WIFI = "NetworkCapabilities.TRANSPORT_WIFI"
    const val INTERNET_TRANSPORT_ETHERNET = "NetworkCapabilities.TRANSPORT_ETHERNET"
    const val ERROR_CONNECTION = "NoConnection"


    //RETROFIT API
    const val START_USERS_URL_LINK = "https://randomuser.me/"
    const val END_USERS_URL_LINK = "api/?results=10"
}