package com.padcmyanmar.padcx.shared.adapters

import androidx.recyclerview.widget.RecyclerView
import com.padcmyanmar.padcx.shared.viewholders.BaseViewHolder

abstract class BaseAdapter<W: BaseViewHolder<T>,T> : RecyclerView.Adapter<W>(){
    var mData : MutableList<T> = arrayListOf()

    override fun getItemCount(): Int {
        return mData.count()
    }

    override fun onBindViewHolder(holder: W, position: Int) {
        holder.bindData(mData[position])
    }
    fun setData(data : MutableList<T>){
        mData=data
        notifyDataSetChanged()
    }
}