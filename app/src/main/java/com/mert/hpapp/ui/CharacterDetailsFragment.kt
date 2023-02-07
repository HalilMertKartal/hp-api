package com.mert.hpapp.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mert.hpapp.MainActivityViewModel
import com.mert.hpapp.R
import com.mert.hpapp.util.Constants
import com.mert.hpapp.util.GlideImageLoader
import kotlinx.android.synthetic.main.fragment_character_details.*


class CharacterDetailsFragment(private val mainViewModel: MainActivityViewModel) : Fragment() {
    private val TAG = "CharacterDetails"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initializeDetails()
        Log.d(TAG, "$TAG launched")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_character_details, container, false)
    }


    private fun initializeDetails() {
        val selectedCharHP = mainViewModel.selectedCharHP.value

        if (selectedCharHP != null) {
            Log.d(TAG, selectedCharHP.name)

            character_name.text = selectedCharHP.name
            character_gender.text = "Gender: ${selectedCharHP.gender.replaceFirstChar { it.uppercase() }}"
            character_house.text = "House: ${selectedCharHP.house}"
            character_birthdate.text = "Birth Date ${selectedCharHP.dateOfBirth}"
            character_ancestry.text = "Ancestry: ${selectedCharHP.ancestry.replaceFirstChar { it.uppercase() }}"
            character_eye_color.text = "Eye Colour: ${selectedCharHP.eyeColour.replaceFirstChar { it.uppercase() }}"
            character_hair_color.text = "Hair Colour: ${selectedCharHP.hairColour.replaceFirstChar { it.uppercase() }}"

            val profilePic = char_detailed_pp

            var imgUrl = selectedCharHP.profilePictureURL
            if (imgUrl.isEmpty()){
                imgUrl = Constants.STOCK_PP_URL
            }
            val loader = GlideImageLoader()
            loader.loadGlideImage(profilePic, imgUrl)

        }
        else {
            Log.d(TAG, "Selected characterHP is null")
        }

    }
}