package com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.views.viewholders

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.data.vos.PlaylistVO
import com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.delegates.ShowDelegate
import com.padcmyanmar.padcx.shared.viewholders.BaseViewHolder
import kotlinx.android.synthetic.main.item_up_next.view.*

class UpNextViewHolder(itemView: View,delegate : ShowDelegate) : BaseViewHolder<PlaylistVO>(itemView) {
    init {
     itemView.setOnClickListener {
         mData?.let {
             delegate.onTapItem(it.data?.id2 ?: "")
         }
     }
        itemView.iv_download.setOnClickListener {
            mData?.let {
                it.data?.let {
                    delegate.onTapDownloadPodcastItem(it) }
            }
        }
    }

    override fun bindData(data: PlaylistVO) {
        mData=data

        Glide.with(itemView)
            .load(mData?.data?.image)
            .into(itemView.iv_profile)

        itemView.tv_title.text=mData?.data?.title

    }

}