package com.dicoding.orderfoodapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView

class FoodMenuDetailActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var tvItemQty: TextView
    private lateinit var btnPlusQty: ImageButton
    private lateinit var btnMinusQty: ImageButton
    private lateinit var tvItemName: TextView
    private lateinit var tvItemPrice: TextView
    private lateinit var imgItemPhoto: ImageView
    private lateinit var tvTotalPrice: TextView
    private lateinit var btnBuy: Button

    companion object {
        const val EXTRA_NAME = "extra_name"
        const val EXTRA_DETAIL = "extra_detail"
        const val EXTRA_PRICE = "extra_price"
        const val EXTRA_IMG = "extra_img"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_food_menu_detail)

        tvItemName = findViewById(R.id.tv_item_name)
        tvItemPrice = findViewById(R.id.tv_item_price)
        imgItemPhoto = findViewById(R.id.img_item_photo)
        tvItemQty = findViewById(R.id.tv_item_quantity)
        btnPlusQty = findViewById(R.id.btn_plus_quantity)
        btnMinusQty = findViewById(R.id.btn_minus_quantity)
        tvTotalPrice = findViewById(R.id.tv_total_item_price)
        btnBuy = findViewById(R.id.btn_addToCart)

        val itemName = intent.getStringExtra(EXTRA_NAME)
        val itemPrice = intent.getDoubleExtra(EXTRA_PRICE, 0.0)
        val itemPhoto = intent.getIntExtra(EXTRA_IMG, 0)

        tvItemName.text = itemName
        tvItemPrice.text = "$" + itemPrice.toString()
        imgItemPhoto.setImageResource(itemPhoto)
        btnPlusQty.setOnClickListener(this)
        btnMinusQty.setOnClickListener(this)
        btnBuy.setOnClickListener(this)

        tvTotalPrice.text = "Total: $" + itemPrice.toString()

    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn_plus_quantity -> {
                val itemPrice = intent.getDoubleExtra(EXTRA_PRICE, 0.0)
                val qty = tvItemQty.text.toString().trim()
                val plusQty = qty.toInt() + 1
                var totalPrice = plusQty * itemPrice
                tvTotalPrice.text = "Total: $" + totalPrice.toString()
                tvItemQty.text = plusQty.toString()
            }

            R.id.btn_minus_quantity -> {
                val itemPrice = intent.getDoubleExtra(EXTRA_PRICE, 0.0)
                val qty = tvItemQty.text.toString().trim().toInt()
                var minusQty = qty.toInt()
                if (qty.toInt() > 0) {
                    minusQty = minusQty - 1
                }
                var totalPrice = minusQty * itemPrice
                tvTotalPrice.text = "Total: $" + totalPrice.toString()
                tvItemQty.text = minusQty.toString()
            }

            R.id.btn_addToCart -> {
                val foodMenuIntent = Intent(this, FoodMenuActivity::class.java)
                startActivity(foodMenuIntent)
            }
        }
    }

}