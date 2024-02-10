package com.albedo.testproject3.data.source.local

import com.albedo.testproject3.data.models.UserUIState
import kotlinx.coroutines.flow.Flow

interface UsersDataSource {

        fun getListItemsFlow(): Flow<List<UserUIState>>
        suspend fun getListItems(): List<UserUIState>

        fun getItemByIdFlow(id : String) : Flow<UserUIState?>
        suspend fun getItemById(id : String) : UserUIState?

        suspend fun updateListItems(list: List<UserUIState>)
        suspend fun deleteAllItems()

    }