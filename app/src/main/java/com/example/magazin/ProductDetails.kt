package com.example.magazin

import android.content.DialogInterface
import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_pork.view.*
import kotlinx.android.synthetic.main.product_details.*

class ProductDetails : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.product_details)
        val title = intent.getStringExtra("title") // getStringExtra принимает намерение с ключем title
        val price = intent.getStringExtra("price")
        description.text=title
        price_pack.text = price

        //supportFragmentManager.beginTransaction().replace(R.id.prod, GroceryFragment()).commit()





    }
    }
