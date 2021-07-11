package com.riquest.suitmediamobiletest

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import java.text.FieldPosition

class GuestAdapter(var context: Context, var arrayList: ArrayList<GuestItem>): BaseAdapter(){

    override fun getItem(p0: Int): Any {
        return arrayList.get(p0)
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getCount(): Int {
        return arrayList.size
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        var view:View = View.inflate(context, R.layout.grid_item, null)

        var image:ImageView = view.findViewById(R.id.iv_guest)
        var name:TextView = view.findViewById(R.id.tv_namaguest)
        var date:TextView = view.findViewById(R.id.tv_ttlguest)

        var GuestItem:GuestItem = arrayList.get(p0)

        image.setImageResource(GuestItem.image!!)
        name.text = GuestItem.name
        date.text = GuestItem.date

        return view
    }

}