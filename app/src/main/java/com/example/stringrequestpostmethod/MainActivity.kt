package com.example.stringrequestpostmethod

import android.os.Bundle
import android.view.textclassifier.ConversationActions
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.stringrequestpostmethod.databinding.ActivityMainBinding




class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btn.setOnClickListener {
            var nam=binding.edit1.text.toString()
            var numb=binding.edit2.text.toString()


            var queue = Volley.newRequestQueue(this)
            var url="https://arsarkar.xyz/SMR_practices/str1_post.php"
            var stringRequest=object :StringRequest(Request.Method.POST,url,
                { respons ->

                    binding.name.text=respons.toString()




                }, {error ->
                    binding.name.text=error.toString()
                })  {
                override fun getParams(): MutableMap<String, String> {
                   var params= HashMap<String, String>()
                    params["name"]=nam
                    params["number"]=numb
                    return params
                }
            }
            queue.add(stringRequest)

        }










    }
}