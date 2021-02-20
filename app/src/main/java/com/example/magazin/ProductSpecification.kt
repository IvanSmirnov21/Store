package com.example.magazin

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.product_description.*

class ProductSpecification: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       setContentView(R.layout.product_description)
        val title = intent.getStringExtra("title2")
        textView2.text = title
    }
    }
