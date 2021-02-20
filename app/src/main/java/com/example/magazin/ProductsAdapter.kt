package com.example.magazin

import android.content.Intent
import android.sax.StartElementListener
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.RecyclerView
import com.example.magazin.data.Product
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.product_row.view.*
import org.jetbrains.anko.support.v4.fragmentTabHost

class ProductsAdapter (
    private val products: List<Product>,
    private val navigateToDetails: (String) -> Unit
): RecyclerView.Adapter<ProductsAdapter.ViewHolder>() {
    override fun onBindViewHolder(holder: ProductsAdapter.ViewHolder, position: Int) {
        holder.bind(products[position])
    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.product_row,parent,false)
        val holder = ViewHolder(view) //   ViewHolder с параметрами view
        return holder // возвращает ViewHolder с параметрами view
    }

    override fun getItemCount () = products.size  // должно ограничивать количество ViewHolder, надо разобраться.


    inner class ViewHolder (itemView : View) : RecyclerView.ViewHolder(itemView) {

        fun bind(product: Product) = itemView.apply {
            Picasso.get().load(product.photoUrl).into(photo) // библиотека Picasso ( Отображение картинок по URL)
            title.text = product.title
            price.text = product.price.toString()

            setOnClickListener {
                navigateToDetails(product.title)
            }
        }

    }

}