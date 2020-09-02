package com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.R
import com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.data.vos.PlaylistVO
import com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.delegates.ShowDelegate
import com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.views.viewholders.UpNextViewHolder
import com.padcmyanmar.padcx.shared.adapters.BaseAdapter
import com.padcmyanmar.padcx.shared.viewholders.BaseViewHolder

class UpNextAdapter(delegate : ShowDelegate) : BaseAdapter<BaseViewHolder<PlaylistVO>,PlaylistVO>(){

    val mDelegate = delegate

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UpNextViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_up_next,parent,false)
        return UpNextViewHolder(view,mDelegate)
    }

}