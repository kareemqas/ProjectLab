package com.example.projectlab

import android.content.ContentValues.TAG
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase


class MainActivity : AppCompatActivity() {
    val db = Firebase.firestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var name = findViewById<EditText?>(R.id.name);
        var phone = findViewById<EditText?>(R.id.phone);
        var addres = findViewById<EditText?>(R.id.addres);

        var save = findViewById<Button?>(R.id.save);


        save.setOnClickListener {
            var txt_name: String = name.text.toString()
            var txt_addres = addres.text.toString()
            var txt_phone = phone.text.toString()
            val users: HashMap<String, Any> = HashMap()
            users["name"] = txt_name
            users["phone"] = txt_phone
            users["addres"] = txt_addres
            db.collection("users")
                .add(users)
                .addOnSuccessListener { documentReference ->

                }
                .addOnFailureListener { e ->
                    Log.w(TAG, "Error adding document", e)
                }

// save code
            var intent = Intent(this, MainActivity2::class.java);
            startActivity(intent)
         }

    }

}