package com.dicoding.orderfoodapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class AboutActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)

        val backToHome: Button = findViewById(R.id.btn_about_to_home)
        backToHome.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn_about_to_home -> {
                val homeIntent = Intent(this, MainActivity::class.java)
                startActivity(homeIntent)
            }
        }
    }
}