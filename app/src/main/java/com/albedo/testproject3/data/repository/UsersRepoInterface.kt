package com.albedo.testproject3.data.repository

import com.albedo.testproject3.data.models.UserUIState
import kotlinx.coroutines.flow.Flow

interface UsersRepoInterface  {

    suspend fun updatePermissionUpdate(permission : Boolean)
    suspend fun refreshItemsData(): String

    fun getItemListFlow(): Flow<List<UserUIState>>
    suspend fun getItemList(): List<UserUIState>
    fun getItemByIdFlow(id : String) : Flow<UserUIState?>
    suspend fun getItemById(id : String) : UserUIState?
}