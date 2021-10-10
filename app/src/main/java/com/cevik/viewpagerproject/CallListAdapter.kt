package com.cevik.viewpagerproject

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.cevik.viewpagerproject.data.Call

class CallListAdapter:RecyclerView.Adapter<CallListViewHolder>() {
    var callList: List<Call> = arrayListOf()
        set(value) {
            field=value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CallListViewHolder {
     val itemView=LayoutInflater.from(parent.context).inflate(R.layout.adapter_item_call,parent,false)
       return CallListViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: CallListViewHolder, position: Int) {
      holder.bind(callList[position])
    }

    override fun getItemCount(): Int =callList.size
}