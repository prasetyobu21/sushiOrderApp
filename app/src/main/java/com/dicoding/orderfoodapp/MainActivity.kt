package com.dicoding.orderfoodapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageButton
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var rvFood: RecyclerView
    private var list: ArrayList<FoodMenu> = arrayListOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnPickup: ImageButton = findViewById(R.id.btn_pickup)
        val btnDelivery: ImageButton = findViewById(R.id.btn_delivery)
        val btnAbout: ImageButton = findViewById(R.id.btn_about)
        btnAbout.setOnClickListener(this)
        btnDelivery.setOnClickListener(this)
        btnPickup.setOnClickListener(this)

    }
    override fun onClick(v: View?) {
        when(v?.id){
            R.id.btn_pickup -> {
                val foodMenuIntent = Intent(this, FoodMenuActivity::class.java)
                startActivity(foodMenuIntent)
            }
            R.id.btn_delivery -> {
                val foodMenuIntent = Intent(this, FoodMenuActivity::class.java)
                startActivity(foodMenuIntent)
            }
            R.id.btn_about -> {
                val aboutIntent = Intent(this, AboutActivity::class.java)
                startActivity(aboutIntent)
            }
        }
    }
}