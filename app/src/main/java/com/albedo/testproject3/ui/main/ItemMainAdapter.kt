package com.albedo.testproject3.ui.main

import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.albedo.testproject3.R
import com.albedo.testproject3.data.models.UserUIState
import com.albedo.testproject3.databinding.ItemRslActivityMainBinding
import com.bumptech.glide.Glide


class ItemMainAdapter(private val context: Context) : RecyclerView.Adapter<ItemMainAdapter.ItemViewHolder>() {

    val TAG = "ItemMainAdapter"

    private var data : List<UserUIState> = listOf()

    lateinit var onClickListener: OnClickListener

    inner class ItemViewHolder(private var binding: ItemRslActivityMainBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(itemModel: UserUIState) {
            binding.containerCard.setOnClickListener { onClickListener.onClick(itemModel) }

            binding.txtFirstInfo.text = "${itemModel.first} ${itemModel.last}"
            binding.txtPhoneInfo.text = itemModel.phone
            binding.txtStreetInfo.text = itemModel.streetName
            binding.txtCityInfo.text = itemModel.city

            Glide.with(context)
                .load(itemModel.large)
                .error(R.drawable.not_loaded_image)
                .placeholder(R.drawable.not_loaded_image)
                .into(binding.imgPhotoInfo)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val itemView = LayoutInflater.from(parent.context)
        return ItemViewHolder(ItemRslActivityMainBinding.inflate(itemView, parent, false))
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) = holder.bind(data[position])

    override fun getItemId(position: Int): Long = data[position].id.toLong() ?: 0L

    override fun getItemCount() = data.size

    @SuppressLint("NotifyDataSetChanged")
    fun setData(newList : List<UserUIState>){
        Log.d(TAG, "newList $newList")
        data = newList
        notifyDataSetChanged()
    }

    interface OnClickListener {
        fun onClick(itemData: UserUIState)
    }
}