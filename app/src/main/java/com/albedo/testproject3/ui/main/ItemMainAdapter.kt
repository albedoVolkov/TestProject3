package com.albedo.testproject3.ui.main

import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.content.res.AppCompatResources
import androidx.recyclerview.widget.RecyclerView
import com.albedo.testproject3.R
import com.albedo.testproject3.data.models.UserDataUIState
import com.albedo.testproject3.databinding.ItemRslActivityMainBinding
import com.bumptech.glide.Glide


class ItemMainAdapter(private val context: Context) : RecyclerView.Adapter<ItemMainAdapter.ItemViewHolder>() {

    val TAG = "ItemMainAdapter"

    private var data : List<UserDataUIState> = listOf()

    lateinit var onClickListener: OnClickListener

    inner class ItemViewHolder(private var binding: ItemRslActivityMainBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(itemModel: UserDataUIState) {
            binding.containerCard.setOnClickListener {
                onClickListener.onClick(itemModel)
            }
            binding.txtFirstInfo.text = "${itemModel.name?.first} ${itemModel.name?.last}"
            binding.txtPhoneInfo.text = itemModel.phone
            binding.txtStreetInfo.text = itemModel.location.street.name
            binding.txtCityInfo.text = itemModel.location.city

            if (itemModel.picture.thumbnail != null) {
                Glide.with(context)
                    .load(itemModel.picture.large)
                    .error(R.drawable.not_loaded_image)
                    .placeholder(R.drawable.not_loaded_image)
                    .into(binding.imgPhotoInfo)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val itemView = LayoutInflater.from(parent.context)
        return ItemViewHolder(ItemRslActivityMainBinding.inflate(itemView, parent, false))
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) = holder.bind(data[position])

    override fun getItemId(position: Int): Long = data[position].id?.value?.toLong() ?: 0L

    override fun getItemCount() = data.size

    @SuppressLint("NotifyDataSetChanged")
    fun setData(newList : List<UserDataUIState>){
        Log.d(TAG, "newList $newList")
        data = newList
        notifyDataSetChanged()
    }

    interface OnClickListener {
        fun onClick(itemData: UserDataUIState)
    }
}