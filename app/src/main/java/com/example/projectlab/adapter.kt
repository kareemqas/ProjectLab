package com.example.projectlab

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.BaseAdapter
import android.widget.TextView
import com.example.projectlab.databinding.ConvertViewBinding

class adapter(var mCtx: Context, var  items:ArrayList<Map<String , Any>>)
    : BaseAdapter(){
    override fun getCount(): Int {
           return  items.size
    }

    override fun getItem(position: Int): Any {
        return position
    }

    override fun getItemId(position: Int): Long {
                   return  position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {


        var binding = ConvertViewBinding.inflate(LayoutInflater.from(mCtx), parent, false);



        binding.mobileNum.text = "Phone : "+items[position]["phone"].toString()
        binding.studentName.text = "Name : "+items[position]["name"].toString()
        binding.serialNumber.text = "Address : "+items[position]["addres"].toString()
        Log.e("ASDASD" , items.toString()+ "ASDSADASD")
        return binding.root
    }
}