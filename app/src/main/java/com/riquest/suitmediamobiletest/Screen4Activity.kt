package com.riquest.suitmediamobiletest

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.GridView
import android.widget.Toast
import androidx.core.content.contentValuesOf

class Screen4Activity : AppCompatActivity(), AdapterView.OnItemClickListener {

    private var gridView:GridView ? = null
    private var arrayList:ArrayList<GuestItem> ? = null
    private var GuestAdapter:GuestAdapter ? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_screen4)

        gridView = findViewById(R.id.gv_guest)
        arrayList = ArrayList()
        arrayList = setDataList()
        GuestAdapter = GuestAdapter(applicationContext, arrayList!!)
        gridView?.adapter = GuestAdapter
        gridView?.onItemClickListener = this
    }

    private fun setDataList() : ArrayList<GuestItem>{
        var arrayList:ArrayList<GuestItem> = ArrayList()
        arrayList.add(GuestItem(R.drawable.speak,"Jim","12 Januari 2000",12))
        arrayList.add(GuestItem(R.drawable.speak,"Junior","2 Juli 2010",2))
        arrayList.add(GuestItem(R.drawable.speak,"Julia","3 Februari 2010",3))
        arrayList.add(GuestItem(R.drawable.speak,"Barbie","20 Maret 2019",20))
        arrayList.add(GuestItem(R.drawable.speak,"Joe","16 April 2001",16))

        return arrayList
    }

    override fun onItemClick(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
        val guestItem:GuestItem = arrayList!!.get(p2)
        if(p2 % 2 == 0 && p2 % 3 == 0){
            Toast.makeText(applicationContext, "IOS", Toast.LENGTH_LONG).show()
        }else if(p2 % 2 == 0){
            Toast.makeText(applicationContext, "Blackberry", Toast.LENGTH_LONG).show()
        }else if(p2 % 3 == 0){
            Toast.makeText(applicationContext, "Android", Toast.LENGTH_LONG).show()
        }else {
            Toast.makeText(applicationContext, "Feature Phone", Toast.LENGTH_LONG).show()
        }
        val sharedPreferences = getSharedPreferences("sharedPrefs", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.apply {
            putString("GUEST", guestItem.name)
        }.apply()
        val intent = Intent(this, Screen2Activity::class.java)
        //intent.putExtra(Screen2Activity.BUTTON1,event)
        //intent.putExtra(Screen2Activity.NAME, name)
        startActivity(intent)
    }

}