package com.albedo.testproject3.ui.main

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.viewModelScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.albedo.testproject3.data.models.UserUIState
import com.albedo.testproject3.databinding.ActivityMainBinding
import com.albedo.testproject3.services.ConstantsSource
import com.albedo.testproject3.ui.userinformation.UserInformationActivity
import com.albedo.testproject3.viewmodels.MainActivityViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    val TAG = "MainActivity"

    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainActivityViewModel by viewModels()
    private lateinit var adapter: ItemMainAdapter



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
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

        viewModel.errorData.onEach {
            Log.d(TAG, "error : $it")
            if(it != ""){ Toast.makeText(this@MainActivity,"Ошибка при загрузке данных - $it",Toast.LENGTH_LONG).show() }
        }.launchIn(viewModel.viewModelScope)

        viewModel.data.onEach {
            Log.d(TAG, "mainItems : $it")
            viewModel.setListInViewModel(it)
            setItemListInRecyclerView(it)
        }.launchIn(viewModel.viewModelScope)
    }



    private fun setListeners() {
        views {
            toolBar.btnReloadUsers.setOnClickListener{
                val error = viewModel.refreshDataByBtn()
            }
        }
    }



    private fun setAdapter() {
        views {
            adapter = ItemMainAdapter(this@MainActivity)
            rclUsers.layoutManager = LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL, false)
            rclUsers.adapter = adapter

            adapter.onClickListener = object : ItemMainAdapter.OnClickListener {
                override fun onClick(itemData: UserUIState) {
                    openInfoActivity(itemData)
                }
            }
        }
    }


    private fun openInfoActivity(itemData: UserUIState) {
        val intent = Intent(this, UserInformationActivity::class.java)
        val bundle = Bundle()
        bundle.putString(ConstantsSource.KeyFromMAToUIA, itemData.id)
        intent.putExtras(bundle)
        startActivity(intent)
    }

    private fun setItemListInRecyclerView(list: List<UserUIState>) {
        Log.d(TAG, "setItemListInRecyclerView : list - $list")
        adapter.setData(list)
    }
}








