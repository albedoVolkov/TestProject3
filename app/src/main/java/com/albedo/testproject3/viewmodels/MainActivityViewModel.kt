package com.albedo.testproject3.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.albedo.testproject3.data.models.UserUIState
import com.albedo.testproject3.data.repository.UsersRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.shareIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(private val repository : UsersRepository) : ViewModel()  {

    private val TAG = "MainActivityViewModel"


    //ITEMS
    val data: Flow<List<UserUIState>> = repository.getItemListFlow().asLiveDataFlow()

    private var _showItems : List<UserUIState> = emptyList()
    val showItems: List<UserUIState> get() = _showItems

    private var _mainItems : List<UserUIState> = listOf()
    val mainItems: List<UserUIState> get() = _mainItems// this list isn't for showing and not sorted

    private var _errorData: MutableStateFlow<String> = MutableStateFlow("")
    val errorData: MutableStateFlow<String> get() = _errorData

    private fun <T> Flow<T>.asLiveDataFlow() = shareIn(viewModelScope, SharingStarted.Lazily, replay = 1)



    init {
       refreshData()
    }


    fun setListInViewModel(list : List<UserUIState>) {
        Log.d(TAG, "setListInViewModel : list - $list")
        _mainItems = list
    }

    private fun refreshData(){
        viewModelScope.launch {
            _errorData.value = async {  repository.refreshItemsData()}.await()
        }
    }

    fun refreshDataByBtn(){
        viewModelScope.launch {
            async {  repository.updatePermissionUpdate(false)}.await()
           refreshData()
        }
    }

}
