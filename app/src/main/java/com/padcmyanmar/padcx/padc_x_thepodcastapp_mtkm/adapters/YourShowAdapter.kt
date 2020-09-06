package com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.R
import com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.data.vos.DownloadVO
import com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.delegates.DownloadDelegate
import com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.delegates.ShowDelegate
import com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.views.viewholders.YourShowViewHolder
import com.padcmyanmar.padcx.shared.adapters.BaseAdapter
import com.padcmyanmar.padcx.shared.viewholders.BaseViewHolder

class YourShowAdapter(val mDelegate: DownloadDelegate) : BaseAdapter<BaseViewHolder<DownloadVO>,DownloadVO>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): YourShowViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_your_show,parent,false)
        return YourShowViewHolder(view,mDelegate)
    }

}