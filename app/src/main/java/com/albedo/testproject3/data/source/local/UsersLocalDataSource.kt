package com.albedo.testproject3.data.source.local

import javax.inject.Inject
import android.util.Log
import com.albedo.testproject3.data.models.UserDataUIState
import com.albedo.testproject3.di.IoDispatcher
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext

class UsersLocalDataSource @Inject internal constructor(
        private val dao: UsersDao,
        @IoDispatcher private val ioDispatcher: CoroutineDispatcher
    ) : UsersDataSource {

        private val TAG = "UsersLocalDataSource"

        override fun getListItemsFlow(): Flow<List<UserDataUIState>> = dao.getAllFlow()

        override suspend fun getListItems(): List<UserDataUIState> = withContext(ioDispatcher) {
            try {
                return@withContext dao.getAll()
            } catch (e: Exception) {
                return@withContext listOf()
            }
        }




        override fun getItemByIdFlow(id : String) : Flow<UserDataUIState?> = dao.getItemByIdFlow(id)


        override suspend fun getItemById(id : String) : UserDataUIState? = withContext(ioDispatcher) {
            try {
                return@withContext dao.getItemById(id)
            } catch (e: Exception) {
                return@withContext null
            }
        }

        override suspend fun updateListItems(list: List<UserDataUIState>) : Unit = withContext(ioDispatcher) {
            Log.d(TAG, "list = $list")
            dao.clear()
            dao.insertList(list)
        }

        override suspend fun deleteAllItems(): Unit = withContext(ioDispatcher) {
            dao.clear()
        }
    }