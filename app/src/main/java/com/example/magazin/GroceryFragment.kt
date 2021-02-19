package com.example.magazin

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.magazin.data.Product
import com.example.magazin.data.ProductDescription
import com.google.gson.Gson
import kotlinx.android.synthetic.main.fragment_main.view.*
import kotlinx.android.synthetic.main.product_details.view.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.net.URL

class GroceryFragment: Fragment(), CoroutineScope {
    override val coroutineContext = Dispatchers.IO
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val root2 = inflater.inflate(R.layout.product_details, container, false)
        launch() {
            //  launch() - можно поток определить в скобках, тут получаеться IO по умолчанию
            val json2 = URL("https://gist.githubusercontent.com/IvanSmirnov21/831031e31488fc0865f3752e2c84beda/raw/1e0e7ce2cab53f7ae10a4401c91499af8bf9dd36/description_products.json").readText()
            Log.d("ivan2", "json: $json2")
            val products = Gson().fromJson(json2, Array<ProductDescription>::class.java).toList() //гугловский gson

            //coroutine, Исполнение служебного кода в служебном потоке, визуал в главном потоке, иначе приложение крашится!!!
            launch(Dispatchers.Main) {
                root2.recycler_View2.apply {
                    layoutManager = LinearLayoutManager(activity)
                    adapter = ProductsAdapter2(products)


                }
            }
        }


        return root2

    }


}
