package com.riquest.suitmediamobiletest

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getSupportActionBar()?.hide();
        setContentView(R.layout.activity_main)

        btn_selesai.setOnClickListener {
            val name = et_nama.text.toString()
            val sharedPreferences = getSharedPreferences("sharedPrefs", Context.MODE_PRIVATE)
            val editor = sharedPreferences.edit()
            editor.apply {
                putString("NAME", name)
            }.apply()
            val intent = Intent(this@MainActivity, Screen2Activity::class.java)
            startActivity(intent)
        }
    }


}