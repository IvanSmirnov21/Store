package com.example.magazin

import android.os.Bundle
import android.provider.ContactsContract.CommonDataKinds.Website.URL
import android.util.Log.d
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.UiThread
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.example.magazin.data.Product
import com.google.gson.Gson
import com.google.gson.JsonArray
import com.google.gson.internal.bind.TypeAdapters.URL
import kotlinx.android.synthetic.main.fragment_main.view.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.Dispatcher
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.support.v4.onUiThread
import org.jetbrains.anko.support.v4.runOnUiThread
import org.jetbrains.anko.support.v4.uiThread
import java.net.URL
import kotlin.coroutines.CoroutineContext

class MainFragment: Fragment(), CoroutineScope {
    override val coroutineContext = Dispatchers.IO
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val root = inflater.inflate(R.layout.fragment_main, container, false)
        launch() {

            val json = URL("https://gist.githubusercontent.com/IvanSmirnov21/e5e95a599cc43675abaf167984cb201b/raw/2d54bac3bf8fe41f3996b3fc9cf9387ed45f388a/shopping_products.json").readText()
           // runOnUiThread {
                d("ivan", "json: $json")
                val products = Gson().fromJson(json, Array<Product>::class.java).toList()
            // Исполнение кода в служебном потоке, визуал в главном потоке, иначе приложение крашится!!!
            launch(Dispatchers.Main) {
                root.recycler_View.apply {
                    layoutManager = GridLayoutManager(activity, 2)  // recycler_View Количество столбцов spanCount = 2 . GridLayoutManager - МЕНЕДЖЕР СЕТКИ, root - ссылка на fragment_main
                    adapter = ProductsAdapter(products)
                }
                }
        }


       // }



        return root
    }

}