package com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.adapters

import androidx.recyclerview.widget.RecyclerView
import com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.views.viewholders.BaseViewHolder

abstract class BaseAdapter<W:BaseViewHolder<T>,T> : RecyclerView.Adapter<W>(){
    var mData : MutableList<T>? = null

    override fun getItemCount(): Int {
        return 0
    }

    override fun onBindViewHolder(holder: W, position: Int) {

    }
    fun setData(data : MutableList<T>){
        mData=data
        notifyDataSetChanged()
    }
}