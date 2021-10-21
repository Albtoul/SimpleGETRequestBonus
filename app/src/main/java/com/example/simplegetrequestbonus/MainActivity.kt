package com.example.simplegetrequestbonus

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {
    lateinit var tv:TextView//intilise varibal
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tv = findViewById(R.id.tv)

        val apiInterface = APIClient().getClient()?.create(APIInterface::class.java)//call api to fetch data
        apiInterface!!.getClient()?.enqueue(object : Callback<Person?> {
            override fun onResponse(call: Call<Person?>, response: Response<Person?>) {
             for(index in response.body()!!){//for loop to the name in class Person

                 tv.text =" ${tv.text} \n ${index.name}"
             }
            }

            override fun onFailure(call: Call<Person?>, t: Throwable) {
                call.cancel()

            }
        })



    }
}


