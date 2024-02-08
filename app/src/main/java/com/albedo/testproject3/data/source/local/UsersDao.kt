package com.albedo.testproject3.data.source.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.albedo.testproject3.data.models.UserDataUIState
import kotlinx.coroutines.flow.Flow

@Dao
interface UsersDao  {
        @Insert(UserDataUIState::class,onConflict = OnConflictStrategy.REPLACE)
        suspend fun insertList(items: List<UserDataUIState>)

        @Query("delete from users")
        suspend fun clear()

        @Query("SELECT * FROM users")
        fun getAllFlow(): Flow<List<UserDataUIState>>

        @Query("SELECT * FROM users")
        suspend fun getAll(): List<UserDataUIState>

        @Query("SELECT * FROM users WHERE id =:id LIMIT 1")
        fun getItemByIdFlow(id : String): Flow<UserDataUIState?>

        @Query("SELECT * FROM users WHERE id =:id LIMIT 1")
        suspend fun getItemById(id : String): UserDataUIState?

}