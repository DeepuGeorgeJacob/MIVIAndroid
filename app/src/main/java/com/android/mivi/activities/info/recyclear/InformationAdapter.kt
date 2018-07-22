package com.android.mivi.activities.info.recyclear

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.android.mivi.R
import com.android.mivi.activities.info.dal.Information

class InformationAdapter : RecyclerView.Adapter<ViewHolder>() {
    private var data = ArrayList<Information>()
    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        val  view = LayoutInflater.from(parent!!.context).inflate(R.layout.information_item_layout, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        holder!!.header.text = data.get(position).getHeader()
        holder!!.detail.text = data.get(position).getDetails()

    }

    public fun setData(list: List<Information>) {
        data.addAll(list)
        notifyDataSetChanged()
    }
}