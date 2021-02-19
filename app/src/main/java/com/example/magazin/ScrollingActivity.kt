package com.example.magazin

import android.os.Bundle
import android.util.Log.d
import android.util.Log.i
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.recyclerview.widget.GridLayoutManager
import com.example.magazin.data.Product
import com.google.android.material.appbar.CollapsingToolbarLayout
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_scrolling.*
import kotlinx.android.synthetic.main.content_scrolling.*

class ScrollingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scrolling)
        setSupportActionBar(findViewById(R.id.toolbar))
        findViewById<CollapsingToolbarLayout>(R.id.toolbar_layout).title = title
        findViewById<FloatingActionButton>(R.id.fab).setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }
        supportFragmentManager.beginTransaction().replace(R.id.frame_layout, MainFragment()).commit()




        navigation_view.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.action_home -> {
                    supportFragmentManager.beginTransaction()
                            .replace(R.id.frame_layout, MainFragment())  //frame_layout в MainFragment
                            .commit()  //запуск фрагмента главной страницы
                }
                R.id.Chicken_And_Turkey -> {
                    supportFragmentManager.beginTransaction()
                            .replace(R.id.frame_layout, ChickenFragment())
                            .commit()  //запуск фрагмента курицы и индейки
                }
                R.id.pork -> {
                    supportFragmentManager.beginTransaction()
                            .replace(R.id.frame_layout, PorkFragment())
                            .commit()  //запуск морепродуктов
                }
                R.id.seafood -> {
                    supportFragmentManager.beginTransaction()
                            .replace(R.id.frame_layout, PorkFragment())
                            .commit()  //запуск морепродуктов
                }
                R.id.related_products -> {
                    supportFragmentManager.beginTransaction()
                            .replace(R.id.frame_layout, ChickenFragment())
                            .commit()  //запуск фрагмента остальных продуктов
                }
            }
            it.isChecked = true // isChecked - состояние выбраного объекта, setNavigationItemSelectedListener - получает уведомление при нажатии на меню.
            drawerLayout.closeDrawers() // Закрытие навигационного меню при нажатии.
            true
        }

        supportActionBar?. apply {
            setDisplayHomeAsUpEnabled(true)   // Добавляет меню ActionBar
            setHomeAsUpIndicator(R.drawable.ic_sharp_dehaze_24) // картинка меню
        }


    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        drawerLayout.openDrawer(GravityCompat.START) // открывает меню ActionBar drawerLayout
        return true
       // return super.onOptionsItemSelected(item)
    }
}
