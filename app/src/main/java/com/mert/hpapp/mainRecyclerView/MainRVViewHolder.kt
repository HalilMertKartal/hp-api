package com.mert.hpapp.mainRecyclerView

import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.mert.hpapp.*
import com.mert.hpapp.data.CharHP
import com.mert.hpapp.ui.CharacterDetailsFragment
import com.mert.hpapp.util.Constants
import com.mert.hpapp.util.GlideImageLoader
import kotlinx.android.synthetic.main.rv_charlist_row.view.*

class MainRVViewHolder(view: View): RecyclerView.ViewHolder(view){
    var mainViewModel = MainActivityViewModel()
    val characterDetailsFragment = CharacterDetailsFragment(mainViewModel)

    private val stockPP =  Constants.STOCK_PP_URL

    private val name = view.char_name
    private val actor = view.char_actor
    private val gender = view.char_gender
    private val profilePic = view.char_pp

    private val rowItem = view.RV_Row

    fun bind(charHP: CharHP) {
        // Update the text views
        name.text = charHP.name
        actor.text = "Played by: ${charHP.actor}"
        gender.text = "Gender: ${charHP.gender.replaceFirstChar { it.uppercase() }}"

        // Load the image
        var imgUrl = charHP.profilePictureURL
        if (imgUrl.isEmpty()){
            imgUrl = stockPP
        }
        val loader = GlideImageLoader()
        loader.loadGlideImage(profilePic, imgUrl)

        // Set the onClickListener to see the details
        rowItem.setOnClickListener {
            // Details will be passed to the character details fragment

            /*
            // Activity olsaydı böyle yapılabilirdi
            val intent = Intent(it.context, R.layout.fragment_character_details::class.java)
            intent.putExtra("dateOfBirth", charHP.dateOfBirth)
            intent.putExtra("eyeColour", charHP.eyeColour)
            intent.putExtra("hairColour", charHP.hairColour)
            intent.putExtra("Ancestry", charHP.ancestry)

            it.context.startActivity(intent)
             */
            // Use the view model to carry information between fragments
            mainViewModel.selectedCharHP.value = charHP

            val activity = it.context as AppCompatActivity
            activity.supportFragmentManager.beginTransaction().apply {
                replace(R.id.fragmentContainerView, characterDetailsFragment)
                    .addToBackStack("mainRV")
                    .commit()
            }
        }

    }
}