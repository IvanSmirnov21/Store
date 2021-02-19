package com.example.magazin

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.magazin.data.ProductDescription

class ProductsAdapter2 (private val products: List<ProductDescription> ): RecyclerView.Adapter<ProductsAdapter2.ViewHolder>() {
    override fun onBindViewHolder(holder: ProductsAdapter2.ViewHolder, position: Int) {
        val product = products[position]
        holder.sizePack.text = product.description_size.toString()
        holder.pricePack.text = product.price_description.toString()
        holder.description.text = product.description
    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.grocery_list,parent,false)
        val holder = ViewHolder(view) //   ViewHolder с параметрами view
        view.setOnClickListener() { // Клик на view
            val intent = Intent(parent.context, ProductDescription::class.java) // Намерение в контексте, -> ProductDetails
            intent.putExtra("title2", products[holder.adapterPosition].description) //намерение передачи между экранами с ключем title и значением products[holder.adapterPosition].title
            parent.context.startActivities(arrayOf(intent)) //Запуск Activities
        }
        return holder // возвращает ViewHolder с параметрами view
    }

    override fun getItemCount () = products.size  // должно ограничивать количество ViewHolder, надо разобраться.


    class ViewHolder (itemView : View) : RecyclerView.ViewHolder(itemView) {
        val sizePack: TextView = itemView.findViewById(R.id.size_pack)
        val description: TextView = itemView.findViewById(R.id.description)
        val pricePack: TextView = itemView.findViewById(R.id.price_pack)

    }

}
