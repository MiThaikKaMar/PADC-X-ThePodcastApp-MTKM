package com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.R
import com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.activities.DetailActivity
import com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.adapters.UpNextAdapter
import com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.mvp.presenters.PodcastPresenter
import com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.mvp.presenters.impls.PodcastPresenterImpl
import com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.mvp.views.PodcastView
import com.padcmyanmar.padcx.shared.fragments.BaseFragment
import kotlinx.android.synthetic.main.fragment_podcast.*

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class PodcastFragment : BaseFragment(),PodcastView {
    private var param1: String? = null
    private var param2: String? = null

    private lateinit var mPodcastPresenter : PodcastPresenter

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
        return inflater.inflate(R.layout.fragment_podcast, container, false)
    }

    companion object {
        fun newInstance(param1: String, param2: String) =
            PodcastFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpPresenter()

        setUpRecyclerView()

    }

    private fun setUpRecyclerView(){
        val layoutManager = LinearLayoutManager(this.context,LinearLayoutManager.VERTICAL,false)
        rv_up_next.adapter=UpNextAdapter(mPodcastPresenter)
        rv_up_next.layoutManager=layoutManager
    }


    private fun setUpPresenter(){
        mPodcastPresenter=ViewModelProviders.of(this).get(PodcastPresenterImpl::class.java)
        mPodcastPresenter.initPresenter(this)
    }

    override fun navigateDetail(id:Int) {
        startActivity(DetailActivity.newIntent(this.requireContext(),id))
    }

}