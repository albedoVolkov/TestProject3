package com.albedo.testproject3.data.source.local

import javax.inject.Inject
import android.util.Log
import com.albedo.testproject3.data.models.UserUIState
import com.albedo.testproject3.di.IoDispatcher
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext

class UsersLocalDataSource @Inject internal constructor(
        private val dao: UsersDao,
        @IoDispatcher private val ioDispatcher: CoroutineDispatcher
    ) : UsersDataSource {

        private val TAG = "UsersLocalDataSource"

        override fun getListItemsFlow(): Flow<List<UserUIState>> = dao.getAllFlow()

        override suspend fun getListItems(): List<UserUIState> = withContext(ioDispatcher) {
            try {
                return@withContext dao.getAll()
            } catch (e: Exception) {
                return@withContext listOf()
            }
        }




        override fun getItemByIdFlow(id : String) : Flow<UserUIState?> = dao.getItemByIdFlow(id)


        override suspend fun getItemById(id : String) : UserUIState? = withContext(ioDispatcher) {
            try {
                return@withContext dao.getItemById(id)
            } catch (e: Exception) {
                return@withContext null
            }
        }

        override suspend fun updateListItems(list: List<UserUIState>) : Unit = withContext(ioDispatcher) {
            Log.d(TAG, "list = $list")
            dao.clear()
            dao.insertList(list)
        }

        override suspend fun deleteAllItems(): Unit = withContext(ioDispatcher) {
            dao.clear()
        }
    }