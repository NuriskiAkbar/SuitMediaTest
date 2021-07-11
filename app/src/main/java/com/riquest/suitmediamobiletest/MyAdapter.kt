package com.riquest.suitmediamobiletest

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

class MyAdapter (var mctx:Context, var resource:Int, var items:List<Model>):ArrayAdapter<Model>(mctx, resource,items){
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val layoutInflater:LayoutInflater = LayoutInflater.from(mctx)
        val view:View = layoutInflater.inflate(resource, null)
        val imageView:ImageView = view.findViewById(R.id.iv_mbuh)
        val event:TextView = view.findViewById(R.id.tv_nama)
        val tanggal:TextView = view.findViewById(R.id.tv_tanggal)

        var items:Model = items[position]
        imageView.setImageDrawable(mctx.resources.getDrawable(items.img))
        event.text = items.event
        tanggal.text = items.tanggal
        return view
    }
}