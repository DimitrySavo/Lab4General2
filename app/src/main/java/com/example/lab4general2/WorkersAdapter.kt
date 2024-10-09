package com.example.lab4general2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class WorkersAdapter(private val dataset: List<Worker>) :
    RecyclerView.Adapter<WorkersAdapter.ViewHolder>() {
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val nameAndSurname: TextView = view.findViewById(R.id.nameOnItem)
        val image: ImageView = view.findViewById(R.id.imageOnItem)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.list_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = dataset[position]
        holder.nameAndSurname.text = item.surname + item.name
        holder.image.setImageResource(item.imageId)
    }

    override fun getItemCount(): Int {
        return dataset.size
    }
}