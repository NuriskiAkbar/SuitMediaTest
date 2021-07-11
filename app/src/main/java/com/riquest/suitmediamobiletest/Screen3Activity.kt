package com.riquest.suitmediamobiletest

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ListView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.row_event.*
import kotlinx.android.synthetic.main.row_event.tv_nama
import kotlinx.android.synthetic.main.screen2.*
import kotlinx.android.synthetic.main.screen2.view.*



class Screen3Activity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_screen3)

        var listview = findViewById<ListView>(R.id.lv_event)
        var list = mutableListOf<Model>()

        list.add(Model("New Year","12 Januari 2019",R.drawable.speak))
        list.add(Model("Birthday","6 Maret 2014",R.drawable.speak))
        list.add(Model("Graduation","12 Januari 2009",R.drawable.speak))
        list.add(Model("Thanksgiving","1 April 2021",R.drawable.speak))
        list.add(Model("Halloween","12 Januari 2019",R.drawable.speak))

        listview.adapter = MyAdapter(this, R.layout.row_event, list)

        listview.setOnItemClickListener{ parent:AdapterView<*>, view: View, position:Int, id ->
          val event = list[position].event
            val sharedPreferences = getSharedPreferences("sharedPrefs", Context.MODE_PRIVATE)
            val editor = sharedPreferences.edit()
            editor.apply {
                putString("EVENT", event)
            }.apply()
            val intent = Intent(this, Screen2Activity::class.java)
            //intent.putExtra(Screen2Activity.BUTTON1,event)
           //intent.putExtra(Screen2Activity.NAME, name)
            startActivity(intent)
        }

    }
}