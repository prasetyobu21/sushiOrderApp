package com.dicoding.orderfoodapp

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class FoodMenuAdapter(private val foodMenu: ArrayList<FoodMenu>) : RecyclerView.Adapter<FoodMenuAdapter.FoodMenuHolder>() {

    private lateinit var onItemClickCallback: OnItemClickCallback

    interface OnItemClickCallback {
        fun onItemClicked(data: FoodMenu)
    }

    fun setOnCliclCallback(onItemClickCallback: OnItemClickCallback){
        this.onItemClickCallback = onItemClickCallback
    }

    inner class FoodMenuHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        var tvDetail: TextView = itemView.findViewById(R.id.tv_item_detail)
        var imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
        var tvPrice: TextView = itemView.findViewById(R.id.tv_item_price)
        var btnBuy: Button = itemView.findViewById(R.id.btn_buy)
    }

    override fun onCreateViewHolder(ViewGroup: ViewGroup, i: Int): FoodMenuHolder {
        val view: View = LayoutInflater.from(ViewGroup.context).inflate(R.layout.item_cardview_food, ViewGroup, false)
        return FoodMenuHolder(view)
    }

    override fun getItemCount(): Int {
        return foodMenu.size
    }

    override fun onBindViewHolder(holder: FoodMenuHolder, position: Int) {
        val food = foodMenu[position]

        Glide.with(holder.itemView.context)
                .load(food.photo)
                .apply(RequestOptions().override(350,550))
                .into(holder.imgPhoto)

        holder.tvName.text = food.name
        holder.tvDetail.text = food.detail
        holder.tvPrice.text = "$" + food.price.toString()

        holder.btnBuy.setOnClickListener{
            onItemClickCallback.onItemClicked(foodMenu[holder.adapterPosition])
        }
    }
}