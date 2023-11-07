package com.example.welcometoatlanta

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.RecyclerView

class AtlantaAdapter(
    private val fragmentManager: FragmentManager
) : RecyclerView.Adapter<AtlantaViewHolder>() {

    private val places = mutableListOf<Place>()

    fun addPlaces(newPlace: List<Place>) {
        places.clear()
        places.addAll(newPlace)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AtlantaViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.view_holder_atlanta, parent, false)
        return AtlantaViewHolder(view)
    }

    override fun getItemCount(): Int {
        return places.size
    }

    override fun onBindViewHolder(holder: AtlantaViewHolder, position: Int) {
        val data = places[holder.adapterPosition]
        holder.bindData(data)
        holder.itemView.setOnClickListener {
            val fragment = SecondFragment(data)
            fragmentManager.beginTransaction()
                .replace(R.id.flfragment, fragment)
                .addToBackStack(null).commit()
        }
    }
}