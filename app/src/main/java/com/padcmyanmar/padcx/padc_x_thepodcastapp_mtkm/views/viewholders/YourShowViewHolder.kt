package com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.views.viewholders

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.delegates.ShowDelegate

class YourShowViewHolder(itemView: View,delegate: ShowDelegate) : RecyclerView.ViewHolder(itemView) {
    init {
        itemView.setOnClickListener {
            delegate.onTapItem(0)
        }
    }
}