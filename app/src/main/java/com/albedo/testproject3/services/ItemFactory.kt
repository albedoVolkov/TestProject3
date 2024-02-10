package com.albedo.testproject3.services

import com.albedo.testproject3.data.models.fromServer.DodInner
import com.albedo.testproject3.data.models.fromServer.LocationInner
import com.albedo.testproject3.data.models.fromServer.LoginInner
import com.albedo.testproject3.data.models.fromServer.NameInner
import com.albedo.testproject3.data.models.fromServer.PictureInner
import com.albedo.testproject3.data.models.fromServer.RegisteredInner
import com.albedo.testproject3.data.models.UserUIState
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ItemFactory @Inject constructor(){

    private val TAG = "ItemFactory"

    private var userId = "0"

    fun createNewUserUIState(
        gender: String,
        name: NameInner,
        location: LocationInner,
        email: String,
        login: LoginInner,
        dob: DodInner,
        registered: RegisteredInner,
        phone: String = "",
        cell: String = "",
        picture: PictureInner,
        nat: String): UserUIState {
        userId = (userId.toInt() + 1).toString()
        return UserUIState(
            userId,
            gender,
            name.first,
            name.last,
            name.title,
            location.street.number,
            location.street.name,
            location.city,
            location.state,
            location.country,
            location.postcode,
            location.coordinates.latitude,
            location.coordinates.longitude,
            location.timezone.offset,
            location.timezone.description,
            email,
            login.uuid,
            login.username,
            login.password,
            login.salt,
            login.md5,
            login.sha1,
            login.sha256,
            dob.date,
            dob.age,
            registered.date,
            registered.age,
            phone,
            cell,
            picture.large,
            picture.medium,
            picture.thumbnail,
            nat)
    }
}