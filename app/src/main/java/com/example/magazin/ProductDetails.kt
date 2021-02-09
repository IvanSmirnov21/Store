package com.example.magazin

import android.content.DialogInterface
import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.product_details.*

class ProductDetails : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.product_details)
        val title = intent.getStringExtra("title") // getStringExtra принимает намерение с ключем title
        product_name.text = title  // описание продукта TextView = намерению
        Availability.setOnClickListener {
            AlertDialog.Builder (this)
                    .setMessage("В наличии")
                    .setPositiveButton("OK") { dialog, which ->  }.create().show()
        }


    }
    }
