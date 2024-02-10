package com.albedo.testproject3.data.repository

import android.util.Log
import com.albedo.testproject3.data.models.UserDataUIState
import com.albedo.testproject3.data.source.local.UsersLocalDataSource
import com.albedo.testproject3.data.source.remote.RetrofitDataSource
import com.albedo.testproject3.services.SessionManager
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


class UsersRepository @Inject constructor(
    private val sessionManager: SessionManager,//main source of data
    private val remoteSource: RetrofitDataSource,//main source of data
    private val localSource: UsersLocalDataSource,//just holder of data
) : UsersRepoInterface {

    companion object{
        const val TAG = "UsersRepository"
    }



    override suspend fun updatePermissionUpdate(noNeedToUpdate : Boolean) {
        try{
            sessionManager.updateDataLoginSession(noNeedToUpdate)
        } catch (e: Exception) {
            Log.d(TAG, "updatePermissionUpdate: error - ${e.message}")
        }
    }



    override suspend fun refreshItemsData() {
        try{
            if(!sessionManager.noNeedToUpdate()) {

                val remoteData = remoteSource.dataAPI.getData()
                Log.d(TAG, "refreshItemsData : items = $remoteData")

                if (remoteData != null) {
                    localSource.updateListItems(remoteData.results)
                    updatePermissionUpdate(true)
                }
            }
        } catch (e: Exception) {
            Log.d(TAG, "refreshItemsData: error - ${e.message}")
        }
    }




    override fun getItemListFlow(): Flow<List<UserDataUIState>> = localSource.getListItemsFlow()
    override suspend fun getItemList(): List<UserDataUIState> = localSource.getListItems()
    override fun getItemByIdFlow(id: String): Flow<UserDataUIState?> = localSource.getItemByIdFlow(id)
    override suspend fun getItemById(id: String): UserDataUIState? = localSource.getItemById(id)
}