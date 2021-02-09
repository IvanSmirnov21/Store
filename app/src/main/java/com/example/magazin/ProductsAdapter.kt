package com.example.magazin

import android.content.Intent
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
        val holder = ViewHolder(view) //   ViewHolder с параметрами view
        view.setOnClickListener() { // Клик на view
            val intent = Intent(parent.context, ProductDetails::class.java) // Намерение в контексте, -> ProductDetails
            intent.putExtra("title", products[holder.adapterPosition].title) //намерение передачи между экранами с ключем title и значением products[holder.adapterPosition].title
            parent.context.startActivities(arrayOf(intent)) //Запуск Activities
        }
        return holder // возвращает ViewHolder с параметрами view
    }

    override fun getItemCount () = products.size  // должно ограничивать количество ViewHolder, надо разобраться.


    class ViewHolder (itemView : View) : RecyclerView.ViewHolder(itemView) {
        val image: ImageView = itemView.findViewById(R.id.photo)
        val title: TextView = itemView.findViewById(R.id.title)
        val price: TextView = itemView.findViewById(R.id.price)

    }

}