package com.albedo.testproject3.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.albedo.testproject3.data.models.UserDataUIState
import com.albedo.testproject3.data.repository.UsersRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.shareIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(private val repository : UsersRepository) : ViewModel()  {

    private val TAG = "MainActivityViewModel"


    //ITEMS
    val data: Flow<List<UserDataUIState>> = repository.getItemListFlow().asLiveDataFlow()

    private var _showItems : List<UserDataUIState> = emptyList()
    val showItems: List<UserDataUIState> get() = _showItems

    private var _mainItems : List<UserDataUIState> = listOf()
    val mainItems: List<UserDataUIState> get() = _mainItems// this list isn't for showing and not sorted

    private fun <T> Flow<T>.asLiveDataFlow() = shareIn(viewModelScope, SharingStarted.Lazily, replay = 1)



    fun setListInViewModel(list : List<UserDataUIState>) {
        Log.d(TAG, "setListInViewModel : list - $list")
        _mainItems = list
    }

    fun filterItems(filterType: String) {
        _showItems = when (filterType) {
            "None" -> emptyList()
            "All" -> _mainItems
            "Reversed" -> _mainItems.reversed()
            else -> _mainItems
        }
    }

    fun refreshData(){
        viewModelScope.launch {
            async {  repository.updatePermissionUpdate(false)}.await()
            async {  repository.refreshItemsData()}.await()
        }
    }

}
