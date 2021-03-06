package com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.views.viewholders

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.data.vos.DownloadVO
import com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.delegates.DownloadDelegate
import com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.delegates.ShowDelegate
import com.padcmyanmar.padcx.shared.viewholders.BaseViewHolder
import kotlinx.android.synthetic.main.item_your_show.view.*
import mk.padc.share.utils.load

class YourShowViewHolder(itemView: View,delegate: DownloadDelegate) : BaseViewHolder<DownloadVO>(itemView) {
    init {
        itemView.setOnClickListener {
            mData?.let {
                delegate.onTapDownloadListItem(it)
            }
        }
    }

    override fun bindData(data: DownloadVO) {
        mData=data

        mData?.download_podcast_url?.let { itemView.iv_show_profile.load(it) }
        itemView.tv_show_title.text=mData?.donwload_podcast_title
        itemView.tv_show_description.text=mData?.download_podcast_description

    }
}