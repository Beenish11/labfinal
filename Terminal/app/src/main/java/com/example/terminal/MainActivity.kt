package com.example.terminal

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.core.view.isVisible
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.example.terminal.databinding.ActivityMainBinding
import org.json.JSONObject

class MainActivity : AppCompatActivity() {

    private val ls = ArrayList<Model>()
    private lateinit var Adapter: Adapter

    override fun onCreate(savedInstanceState: Bundle?) {
        lateinit var binding: ActivityMainBinding

        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        val view=binding.root
        setContentView(view)

        title = "Terminal"

        Adapter = Adapter(ls)
        val layoutManager = LinearLayoutManager(applicationContext)
        binding.recyclerView.layoutManager = layoutManager
        binding.recyclerView.itemAnimator = DefaultItemAnimator()
        binding.recyclerView.adapter = Adapter



        // volley

        val queue= Volley.newRequestQueue(this)

        val url = "https://run.mocky.io/v3/cc1eb953-b35f-49b0-b20e-e43232921464"

        val jsonObjectRequest = JsonObjectRequest(
            Request.Method.GET,
            url,
            null,
            Response.Listener<JSONObject> { response ->
                view.isVisible = true
                view.text = response.toString()

            },
            Response.ErrorListener { error ->
                view.Text = "Can't load request"

                Log.d("Cant manage request", error.toString())

            })
        // Add JsonRequest to the RequestQueue
        queue.add(jsonObjectRequest)
    }


    }

