package com.albedo.testproject3.data.repository

import com.albedo.testproject3.data.models.UserDataUIState
import kotlinx.coroutines.flow.Flow

interface UsersRepoInterface  {

    suspend fun updatePermissionUpdate(permission : Boolean)
    suspend fun refreshItemsData()

    fun getItemListFlow(): Flow<List<UserDataUIState>>
    suspend fun getItemList(): List<UserDataUIState>
    fun getItemByIdFlow(id : String) : Flow<UserDataUIState?>
    suspend fun getItemById(id : String) : UserDataUIState?
}