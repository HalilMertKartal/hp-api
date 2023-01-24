package com.mert.hpapp.mainRecyclerView

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.mert.hpapp.R
import com.mert.hpapp.data.CharHP
import kotlinx.android.synthetic.main.rv_charlist_row.view.*

class MainRVAdapter: RecyclerView.Adapter<MainRVAdapter.MainRVViewHolder>() {
    var charHPList = ArrayList<CharHP>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainRVViewHolder {
        // inflate the rv with row layout file which we created before
        val inflater = LayoutInflater.from(parent.context).inflate(R.layout.rv_charlist_row, parent, false)
        return MainRVViewHolder(inflater)
    }

    // Array elemanlarını RV de row olarak tek tek bind edecek fonksiyon
    override fun onBindViewHolder(holder: MainRVViewHolder, position: Int) {
        holder.bind(charHPList[position])
    }

    override fun getItemCount(): Int {
        return charHPList.size
    }

    class MainRVViewHolder(view: View): ViewHolder(view){
        private val stockPP =  "https://cdn.pixabay.com/photo/2015/10/05/22/37/blank-profile-picture-973460_1280.png"

        private val name = view.char_name
        private val actor = view.char_actor
        private val gender = view.char_gender
        private val profilePic = view.char_pp


        fun bind(charHP: CharHP) {
            // Update the text views
            name.text = charHP.name
            actor.text = "Played by: ${charHP.actor}"
            gender.text = "Gender: ${charHP.gender}"

            // Load the image
            var imgUrl = charHP.profilePictureURL
            if (imgUrl.isEmpty()){
                imgUrl = stockPP
            }
            Glide.with(profilePic)
                .load(imgUrl)
                .circleCrop()
                .into(profilePic)


        }
    }
}