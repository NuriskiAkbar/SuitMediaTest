package com.riquest.suitmediamobiletest

import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.WindowManager
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
        getSupportActionBar()?.hide();
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
        arrayList.add(GuestItem(R.drawable.speak,"Andi","2014-01-01",1))
        arrayList.add(GuestItem(R.drawable.speak,"Budi","2014-02-02",2))
        arrayList.add(GuestItem(R.drawable.speak,"Charlie","2014-03-03",3))
        arrayList.add(GuestItem(R.drawable.speak,"Dede","2014-06-06",6))
        arrayList.add(GuestItem(R.drawable.speak,"Joko","2014-02-12",12))

        return arrayList
    }

    fun isPrimeNumber(number: Int): String {

        for (i in 2..number / 2) {
            if (number % i == 0) {
                return "not prime"
            }
        }
        return "prime"
    }

    override fun onItemClick(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
        val guestItem:GuestItem = arrayList!!.get(p2)
        val datebirth = guestItem.date
        val startIndex = 8
        val endIndex = 10
        val substring:String = datebirth?.subSequence(startIndex, endIndex) as String
        val newnumb:Int = substring.toInt()

        val startIndex2 = 5
        val endIndex2 = 7
        val substring2:String = datebirth?.subSequence(startIndex2, endIndex2) as String
        val newnumb2:Int = substring2.toInt()
        //Toast.makeText(applicationContext, ""+newnumb, Toast.LENGTH_LONG).show()
        ////////////////////////////////////////////////////////////////////////////////
       if (newnumb != null) {
            if(newnumb % 2 == 0 && newnumb % 3 == 0){
                Toast.makeText(applicationContext, "IOS", Toast.LENGTH_LONG).show()
            }else if(newnumb % 2 == 0){
                Toast.makeText(applicationContext, "Blackberry", Toast.LENGTH_LONG).show()
            }else if(newnumb % 3 == 0){
                Toast.makeText(applicationContext, "Android", Toast.LENGTH_LONG).show()
            }else {
                Toast.makeText(applicationContext, "Feature Phone", Toast.LENGTH_LONG).show()
            }
        }

        Toast.makeText(applicationContext, ""+isPrimeNumber(newnumb2), Toast.LENGTH_LONG).show()

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
