package com.albedo.testproject3.data.source.local

import com.albedo.testproject3.data.models.UserDataUIState
import kotlinx.coroutines.flow.Flow

interface UsersDataSource {

        fun getListItemsFlow(): Flow<List<UserDataUIState>>
        suspend fun getListItems(): List<UserDataUIState>

        fun getItemByIdFlow(id : String) : Flow<UserDataUIState?>
        suspend fun getItemById(id : String) : UserDataUIState?

        suspend fun updateListItems(list: List<UserDataUIState>) : Unit
        suspend fun deleteAllItems(): Unit

    }