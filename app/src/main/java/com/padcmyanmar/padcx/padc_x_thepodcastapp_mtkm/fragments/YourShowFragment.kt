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
import com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.adapters.YourShowAdapter
import com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.delegates.ShowDelegate
import com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.mvp.presenters.YourShowPresenter
import com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.mvp.presenters.impls.YourShowPresenterImpl
import com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.mvp.views.YourShowView
import com.padcmyanmar.padcx.shared.fragments.BaseFragment
import kotlinx.android.synthetic.main.fragment_your_show.*

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class YourShowFragment : BaseFragment(), YourShowView {
    private var param1: String? = null
    private var param2: String? = null

    private lateinit var mYourShowPresenter : YourShowPresenter

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

        setUpPresenter()
        setUpRecyclerView()

    }

    private fun setUpPresenter(){
        mYourShowPresenter=ViewModelProviders.of(this).get(YourShowPresenterImpl::class.java)
        mYourShowPresenter.initPresenter(this)
    }

    private fun setUpRecyclerView(){
        rv_your_shows.adapter=YourShowAdapter(mYourShowPresenter)
        val linearLayout = LinearLayoutManager(this.context,LinearLayoutManager.VERTICAL,false)
        rv_your_shows.layoutManager=linearLayout
    }

    override fun navigateDetail() {
        startActivity(Intent(this.context,DetailActivity::class.java))
    }
}