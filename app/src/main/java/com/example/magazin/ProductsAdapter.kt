package com.example.magazin

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.magazin.data.Product
import com.squareup.picasso.Picasso

class ProductsAdapter (private val products: ArrayList<Product> ): RecyclerView.Adapter<ProductsAdapter.ViewHolder>() {
    override fun onBindViewHolder(holder: ProductsAdapter.ViewHolder, position: Int) {
        val product = products[position]
        Picasso.get().load(product.photoUrl).into(holder.image) // библиотека Picasso ( Отображение картинок по URL)
        holder.title.text = product.title
        holder.price.text = product.price.toString() // Почему то, без toString не пашет, при том что title работает.
    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.product_row,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount () = products.size  // должно ограничивать количество ViewHolder, надо разобраться.


    class ViewHolder (itemView : View) : RecyclerView.ViewHolder(itemView) {
        val image: ImageView = itemView.findViewById(R.id.photo)
        val title: TextView = itemView.findViewById(R.id.title)
        val price: TextView = itemView.findViewById(R.id.price)

    }

}