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

class MainRVAdapter: RecyclerView.Adapter<MainRVViewHolder>() {
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


}