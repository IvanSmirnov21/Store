package com.example.magazin

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.example.magazin.data.Product
import kotlinx.android.synthetic.main.fragment_main.view.*

class MainFragment: Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val root = inflater.inflate(R.layout.fragment_main, container, false)
        val products = arrayListOf<Product>()


        for (n in 0..100) {
            products.add(Product("Продукты #$n", "https://via.placeholder.com/350x350", 100.0)) // Цикл Product из DATA
        }

        root.recycler_View.apply {
            layoutManager = GridLayoutManager(activity,2)  // recycler_View Количество столбцов spanCount = 2 . GridLayoutManager - МЕНЕДЖЕР СЕТКИ, root - ссылка на fragment_main
            adapter = ProductsAdapter(products)
        }
        return root
    }

}