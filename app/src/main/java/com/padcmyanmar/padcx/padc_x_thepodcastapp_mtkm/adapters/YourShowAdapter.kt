package com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.R
import com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.delegates.ShowDelegate
import com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.views.viewholders.YourShowViewHolder

class YourShowAdapter(val mDelegate: ShowDelegate) : RecyclerView.Adapter<YourShowViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): YourShowViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_your_show,parent,false)
        return YourShowViewHolder(view,mDelegate)
    }

    override fun getItemCount(): Int {
        return 10
    }

    override fun onBindViewHolder(holder: YourShowViewHolder, position: Int) {

    }
}