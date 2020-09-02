package com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.views.viewholders

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.data.vos.GeneresVO
import com.padcmyanmar.padcx.shared.viewholders.BaseViewHolder
import kotlinx.android.synthetic.main.item_category.view.*

class CategoryViewHolder(itemView: View) : BaseViewHolder<GeneresVO>(itemView) {
    override fun bindData(data: GeneresVO) {
        mData=data

        itemView.tv_categories.text=mData?.name
    }

}