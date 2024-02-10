package com.albedo.testproject3.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.albedo.testproject3.data.models.UserUIState
import com.albedo.testproject3.data.repository.UsersRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class UserInformationActivityViewModel  @Inject constructor(private val repository : UsersRepository) : ViewModel()  {

    private val TAG = "UserInformationActivityViewModel"

    //ITEM
    private var _data: MutableStateFlow<UserUIState> = MutableStateFlow(UserUIState())
    val data: MutableStateFlow<UserUIState> get() = _data

    private var _mainItem : UserUIState = UserUIState()
    val mainItem: UserUIState get() = _mainItem


    fun setItemInViewModel(id : String) {
        viewModelScope.launch {
            data.value = async {  repository.getItemById(id)}.await() ?: UserUIState()
            _mainItem = data.value
            Log.d(TAG, "setItemInViewModel : id - $id, item - $_mainItem")
        }
    }
}
