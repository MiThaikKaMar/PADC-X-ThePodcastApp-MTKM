package com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.R
import com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.data.vos.GeneresVO
import com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.views.viewholders.CategoryViewHolder
import com.padcmyanmar.padcx.shared.adapters.BaseAdapter
import com.padcmyanmar.padcx.shared.viewholders.BaseViewHolder

class CategoryAdapter : BaseAdapter<BaseViewHolder<GeneresVO>, GeneresVO>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_category,parent,false)
        return CategoryViewHolder(view)
    }
}