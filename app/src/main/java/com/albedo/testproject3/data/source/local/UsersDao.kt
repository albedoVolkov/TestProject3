package com.albedo.testproject3.data.source.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.albedo.testproject3.data.models.UserUIState
import com.albedo.testproject3.services.ConstantsSource
import kotlinx.coroutines.flow.Flow

@Dao
interface UsersDao  {
        @Insert(UserUIState::class,onConflict = OnConflictStrategy.REPLACE)
        suspend fun insertList(items: List<UserUIState>)

        @Query("delete from ${ConstantsSource.USERS_ROOM_TABLE_NAME}")
        suspend fun clear()

        @Query("SELECT * FROM ${ConstantsSource.USERS_ROOM_TABLE_NAME}")
        fun getAllFlow(): Flow<List<UserUIState>>

        @Query("SELECT * FROM ${ConstantsSource.USERS_ROOM_TABLE_NAME}")
        suspend fun getAll(): List<UserUIState>

        @Query("SELECT * FROM ${ConstantsSource.USERS_ROOM_TABLE_NAME} WHERE id =:idMain LIMIT 1")
        fun getItemByIdFlow(idMain : String): Flow<UserUIState?>

        @Query("SELECT * FROM ${ConstantsSource.USERS_ROOM_TABLE_NAME} WHERE id =:idMain LIMIT 1")
        suspend fun getItemById(idMain : String): UserUIState?

}