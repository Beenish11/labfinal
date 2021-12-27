package com.example.terminal

import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.annotation.NonNull
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
internal class Adapter(private var ls : List<Model>) :
    RecyclerView.Adapter<Adapter.MyViewHolder>() {
    internal inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val btn = view.findViewById<Button>(R.id.btn_btn)
        var title: TextView = view.findViewById(R.id.title)
        var quantity: TextView = view.findViewById(R.id.quantity)
    }
    @NonNull
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.activity_main, parent, false)
        return MyViewHolder(itemView)
    }
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val movie = ls[position]
        holder.title.text = movie.getTitle()
        holder.quantity.text = movie.getQuantity()

            holder.btn.setOnClickListener{

                val smsUri = Uri.parse("tel:123")
                val intent = Intent(Intent.ACTION_VIEW, smsUri)
                intent.putExtra("address", 123)
                intent.putExtra("sms_body", "message")
                intent.type = "vnd.android-dir/mms-sms"
                //startActivity(intent)


            }
    }
    override fun getItemCount(): Int {
        return ls.size
    }
}