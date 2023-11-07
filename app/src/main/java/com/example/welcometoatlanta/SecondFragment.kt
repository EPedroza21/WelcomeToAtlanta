package com.example.welcometoatlanta

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

class SecondFragment(place: Place) : Fragment() {

    private val placeName = place.name
    private val placeDirection = place.direction
    private val placeOpeningTimes = place.openingTimes
    private val placeFamily = place.isFamilyFriendly

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.second_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val nameTitleTextView = view.findViewById<TextView>(R.id.info_title)
        val infoTextView = view.findViewById<TextView>(R.id.details_text_view)
        nameTitleTextView.text = placeName
        val familyFriendlyStatus: String = getFamilyFriendlyDescription(placeFamily)

        infoTextView.text = getString(
            R.string.detailed_place_description,
            placeDirection,
            placeOpeningTimes,
            familyFriendlyStatus
        )
    }

    private fun getFamilyFriendlyDescription(placeFamily: Boolean): String {
        return if (placeFamily) {
            getString(R.string.family_friendly_place)
        } else {
            getString(R.string.not_family_friendly_place)
        }
    }
}


