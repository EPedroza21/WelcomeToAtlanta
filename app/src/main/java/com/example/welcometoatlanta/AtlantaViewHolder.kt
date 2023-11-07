package com.example.welcometoatlanta

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AtlantaViewHolder(itemView:View): RecyclerView.ViewHolder(itemView) {
    private val placeImageView = itemView.findViewById<ImageView>(R.id.place_visit_img)
    private val nameTextView = itemView.findViewById<TextView>(R.id.place_name_text)

    fun bindData(places: Place) {
        nameTextView.text = places.name
        placeImageView.setImageResource(places.image)
    }
}