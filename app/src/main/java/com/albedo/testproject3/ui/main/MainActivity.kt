package com.albedo.testproject3.ui.main

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.lifecycle.viewModelScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.albedo.testproject3.R
import com.albedo.testproject3.data.models.UserDataUIState
import com.albedo.testproject3.databinding.ActivityMainBinding
import com.albedo.testproject3.ui.userinformation.UserInformationActivity
import com.albedo.testproject3.viewmodels.MainActivityViewModel
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import dagger.hilt.EntryPoint
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
//    1. Выводится краткая информация о пользователях (ФИО, фотография, адрес, номер
//    телефона) в виде списка, полученная от https://randomuser.me ;
//    2. По клику на элемент списка на отдельном экране показывается полная информация о
//    выбранном пользователе;
//    3. Данные о пользователях не теряются при перезапуске приложения;
//    4. Нажатие на Email, номер телефона, адрес/координаты отправляет пользователя в
//    приложение, которое может обработать эти данные (почта, звонилка, карты);
//    5. Список пользователей можно обновить принудительно;
//    6. Пользователю выводятся уведомления о возникших ошибках при загрузке данных или
//    работе с ними.


    companion object {
        const val TAG = "MainActivity"
        const val KEY = "DataFromMainActivity"
    }

    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainActivityViewModel by viewModels()
    private lateinit var adapter: ItemMainAdapter



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        viewModel.refreshData()

        setContentView(binding.root)
        init()
    }


    private fun <T> views(block : ActivityMainBinding.() -> T): T? = binding.block()


    private fun init(){
        setAdapter()
        requireData()
        setListeners()
    }



    private fun  requireData() {

        viewModel.data.onEach {
            Log.d(TAG, "mainItems : $it")
            viewModel.setListInViewModel(it)
            setItemListInRecyclerView(it)
        }.launchIn(viewModel.viewModelScope)
    }



    private fun setListeners() {
        views {
            toolBar.btnReloadUsers.setOnClickListener{
                viewModel.refreshData()
            }
        }
    }



    private fun setAdapter() {
        views {
            adapter = ItemMainAdapter(this@MainActivity)
            rclUsers.layoutManager = LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL, false)
            rclUsers.adapter = adapter

            adapter.onClickListener = object : ItemMainAdapter.OnClickListener {

                override fun onClick(itemData: UserDataUIState) {
                    openInfoActivity(itemData)
                }

            }

        }
    }


    private fun openInfoActivity(itemData: UserDataUIState) {
//        val intent = Intent(this, UserInformationActivity::class.java)
//        intent.putExtra(KEY, itemData.toString())
//        startActivity(intent)
    }

    private fun setItemListInRecyclerView(list: List<UserDataUIState>) {
        Log.d(TAG, "setItemListInRecyclerView : list - $list")
        adapter.setData(list)
    }
}








