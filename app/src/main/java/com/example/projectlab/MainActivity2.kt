package com.example.projectlab

import android.content.ContentValues.TAG
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.viewbinding.ViewBinding
import com.example.projectlab.databinding.ActivityMain2Binding
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class MainActivity2 : AppCompatActivity() {
    val db = Firebase.firestore

    var arrayList: ArrayList<Map<String , Any>> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        var adapter = adapter(this, arrayList)

        binding.userlist.adapter = adapter
        val name = db.collection("users")

        name.get()
            .addOnSuccessListener { document ->

 document.documents.forEach {
     Log.e("ASDADSSAD" , "ASDASD " + it["phone"])

     var map = HashMap<String, Any>()
     map["phone"] = it["phone"].toString()
     map["name"] = it["name"].toString()
     map["addres"] = it["addres"].toString()
     arrayList.add( map)
 }
adapter.notifyDataSetChanged()
                Log.e("ASDASD",arrayList.size.toString()+" A SDSAD")
              // document.documents array
                // document.documents[0]
                //

//                if (document != null) {
//                    Log.d(TAG, "DocumentSnapshot data: ${document.data}")
//                } else {
//                    Log.d(TAG, "No such document")
//                }
            }
            .addOnFailureListener { exception ->
                Log.d(TAG, "get failed with ", exception)
            }
//        val password = db.collection("users").document("password")
//        password.get()
//            .addOnSuccessListener { document ->
//                if (document != null) {
//                    Log.d(TAG, "DocumentSnapshot data: ${document.data}")
//                } else {
//                    Log.d(TAG, "No such document")
//                }
//            }
//            .addOnFailureListener { exception ->
//                Log.d(TAG, "get failed with ", exception)
//            }

//        val arrayAdapter: ArrayAdapter<*>
//        val users = arrayOf(
//           name,
//            password,
//        )

        // access the listView from xml file


//        arrayAdapter = ArrayAdapter(this,
//            android.R.layout.simple_list_item_1, users)
//        mListView.adapter = arrayAdapter


    }
}