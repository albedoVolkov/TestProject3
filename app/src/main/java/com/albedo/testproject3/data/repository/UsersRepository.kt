package com.albedo.testproject3.data.repository

import android.content.Context
import android.util.Log
import android.widget.Toast
import com.albedo.testproject3.data.models.UserUIState
import com.albedo.testproject3.data.source.local.UsersLocalDataSource
import com.albedo.testproject3.data.source.remote.RetrofitDataSource
import com.albedo.testproject3.services.ItemFactory
import com.albedo.testproject3.services.SessionManager
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


class UsersRepository @Inject constructor(
    private val sessionManager: SessionManager,//main source of data
    private val remoteSource: RetrofitDataSource,//main source of data
    private val localSource: UsersLocalDataSource,//just holder of data
    private val factory: ItemFactory,//just holder of data
    @ApplicationContext private val context: Context
) : UsersRepoInterface {

    companion object{
        const val TAG = "UsersRepository"
    }



    override suspend fun updatePermissionUpdate(permission : Boolean) {
        try{
            sessionManager.updateDataLoginSession(permission)
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
                    val listNew = mutableListOf<UserUIState>()
                    for(item in remoteData.results) {
                        listNew.add(
                            factory.createNewUserUIState(
                                item.gender,
                                item.name,
                                item.location,
                                item.email,
                                item.login,
                                item.dob,
                                item.registered,
                                item.phone,
                                item.cell,
                                item.picture,
                                item.nat
                            )
                        )
                    }
                    Log.d(TAG, "refreshItemsData: listNew - $listNew")
                    localSource.updateListItems(listNew)
                    updatePermissionUpdate(true)
                }
            }
        } catch (e: Exception) {
            Log.d(TAG, "refreshItemsData: error - ${e.message}")
            Toast.makeText(context,"Ошибка при загрузке данных - ${e.message}",Toast.LENGTH_LONG).show()
        }
    }




    override fun getItemListFlow(): Flow<List<UserUIState>> = localSource.getListItemsFlow()
    override suspend fun getItemList(): List<UserUIState> = localSource.getListItems()
    override fun getItemByIdFlow(id: String): Flow<UserUIState?> = localSource.getItemByIdFlow(id)
    override suspend fun getItemById(id: String): UserUIState? = localSource.getItemById(id)
}