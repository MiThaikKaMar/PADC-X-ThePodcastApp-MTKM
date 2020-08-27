package com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.R
import com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.activities.DetailActivity
import com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.adapters.YourShowAdapter
import com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.delegates.ShowDelegate
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_your_show.*

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class YourShowFragment : BaseFragment(),ShowDelegate {
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_your_show, container, false)
    }

    companion object {
        fun newInstance(param1: String, param2: String) =
            YourShowFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        rv_your_shows.adapter=YourShowAdapter(this)
        val linearLayout = LinearLayoutManager(this.context,LinearLayoutManager.VERTICAL,false)
        rv_your_shows.layoutManager=linearLayout

        iv_arrow.setOnClickListener {
            vp_welcome.visibility=View.VISIBLE
        }
    }

    override fun onTapItem(id: Int) {
        startActivity(Intent(this.context,DetailActivity::class.java))
    }
}