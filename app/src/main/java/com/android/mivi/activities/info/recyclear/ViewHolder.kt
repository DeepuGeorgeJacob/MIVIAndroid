package com.android.mivi.activities.info.recyclear

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import com.android.mivi.R

class ViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {
    val header = itemView!!.findViewById<TextView>(R.id.information)
    val detail = itemView!!.findViewById<TextView>(R.id.details)

}