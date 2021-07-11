package com.riquest.suitmediamobiletest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.database.core.Context
import kotlinx.android.synthetic.main.screen2.*

class Screen2Activity : AppCompatActivity() {

    //companion object{
    //    const val NAME = "NAMA"
   //     const val BUTTON1 = "BUTTON1"
    //}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.screen2)

        val sharedPreferences = getSharedPreferences("sharedPrefs", android.content.Context.MODE_PRIVATE)
        val savedname = sharedPreferences.getString("NAME", null)
        val savedevent = sharedPreferences.getString("EVENT", "PILIH EVENT")
        val savedguest = sharedPreferences.getString("GUEST", "PILIH GUEST")

        //val button1 = intent.getStringExtra(BUTTON1)
        //val name = intent.getStringExtra(NAME)
        tv_nama.text = savedname
        btn_event.text = savedevent
        btn_guest.text = savedguest

        btn_event.setOnClickListener {
            val intent = Intent(this@Screen2Activity, Screen3Activity::class.java)
            startActivity(intent)
        }

        btn_guest.setOnClickListener {
            val intent = Intent(this@Screen2Activity, Screen4Activity::class.java)
            startActivity(intent)
        }
}
}