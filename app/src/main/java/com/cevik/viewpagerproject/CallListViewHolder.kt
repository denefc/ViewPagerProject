package com.cevik.viewpagerproject

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.cevik.viewpagerproject.data.Call

class CallListViewHolder(itemView:View):RecyclerView.ViewHolder(itemView) {

    fun bind(model:Call){
        val tvName=itemView.findViewById<TextView>(R.id.tvName)
        val tvText=itemView.findViewById<TextView>(R.id.tvText)
        val tvIndex=itemView.findViewById<TextView>(R.id.tvIndex)

        tvIndex.text=model.index.toString()
        tvName.text=model.name
        tvText.text=model.text

    }
}