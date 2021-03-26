package com.dicoding.orderfoodapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class FoodMenuActivity : AppCompatActivity() {
    private lateinit var rvFood: RecyclerView
    private var list: ArrayList<FoodMenu> = arrayListOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_food_menu)

        rvFood = findViewById(R.id.rv_food)
        rvFood.setHasFixedSize(true)
        list.addAll(FoodMenuData.listData)
        showRecyclerList()

//        val btnBuy: Button = findViewById(R.id.btn_buy)
    }

    private fun showRecyclerList(){
        rvFood.layoutManager = LinearLayoutManager(this)
        val foodMenuAdapter = FoodMenuAdapter(list)
        rvFood.adapter = foodMenuAdapter
        foodMenuAdapter.setOnCliclCallback(object: FoodMenuAdapter.OnItemClickCallback{
            override fun onItemClicked(data: FoodMenu) {
                val foodMenuDetail = Intent(this@FoodMenuActivity, FoodMenuDetailActivity::class.java)
                foodMenuDetail.putExtra(FoodMenuDetailActivity.EXTRA_NAME, data.name)
                foodMenuDetail.putExtra(FoodMenuDetailActivity.EXTRA_PRICE, data.price)
                foodMenuDetail.putExtra(FoodMenuDetailActivity.EXTRA_IMG, data.photo)
                startActivity(foodMenuDetail)
            }
        })
    }
}