package com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.fragments


import android.app.Activity
import android.content.Context
import android.content.pm.PackageManager
import android.os.Bundle
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.R
import com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.activities.DetailActivity
import com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.adapters.CategoryAdapter
import com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.adapters.UpNextAdapter
import com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.data.vos.DataVO
import com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.data.vos.PlaylistVO
import com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.data.vos.RandomVO
import com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.mvp.presenters.PodcastPresenter
import com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.mvp.presenters.impls.PodcastPresenterImpl
import com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.mvp.views.PodcastView
import com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.utils.HOMEPAGE
import com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.views.viewpods.EmptyViewPod
import com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.views.viewpods.PlayBackViewPod
import com.padcmyanmar.padcx.shared.fragments.BaseFragment
import kotlinx.android.synthetic.main.fragment_podcast.*

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class PodcastFragment : BaseFragment(),PodcastView {
    private var param1: String? = null
    private var param2: String? = null

    private lateinit var mPlayBackViewPod : PlayBackViewPod
    private lateinit var mPodcastPresenter : PodcastPresenter
    private lateinit var mUpNextAdapter : UpNextAdapter
    private lateinit var mEmptyVP : EmptyViewPod

    private val PERMISSION_REQUEST_CODE = 101

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
        mPodcastPresenter.onUiReady(this,"")
        setUpRecyclerView()
        setUpViewPod()
    }
    private fun setUpPresenter(){
        mPodcastPresenter=ViewModelProviders.of(this).get(PodcastPresenterImpl::class.java)
        mPodcastPresenter.initPresenter(this)
    }

    private fun setUpRecyclerView(){

        mEmptyVP = vp_empty as EmptyViewPod
        mUpNextAdapter= UpNextAdapter(mPodcastPresenter)
        val layoutManager = LinearLayoutManager(this.context,LinearLayoutManager.VERTICAL,false)
        rv_up_next.adapter=mUpNextAdapter
        rv_up_next.layoutManager=layoutManager
        rv_up_next.setEmpytView(mEmptyVP)
    }

    override fun navigateDetail(id:String) {
        startActivity(DetailActivity.newIntent(this.requireContext(),id, HOMEPAGE,""))
    }

    override fun showRandomEpisode(randomEpisode: RandomVO) {
            mPlayBackViewPod.setData(randomEpisode)
            tv_description.text= Html.fromHtml(randomEpisode.description)
    }

    override fun showPlayList(list: List<PlaylistVO>) {
        mUpNextAdapter.setData(list.toMutableList())
    }


    private fun setUpViewPod(){
        mPlayBackViewPod= vp_play_back as PlayBackViewPod
    }


    override fun showDownload(data: DataVO) {
        setupData(data)
    }

    fun setupData(data: DataVO) {
        val permission = ContextCompat.checkSelfPermission(
            activity as Activity,
            android.Manifest.permission.WRITE_EXTERNAL_STORAGE
        )

        if (permission != PackageManager.PERMISSION_GRANTED) {
            makeRequest()
        } else {
            data?.let {  mPodcastPresenter?.onClickDownload(activity as Context,it) }
        }
    }

    private fun makeRequest() {
        ActivityCompat.requestPermissions(
            activity as Activity,
            arrayOf(android.Manifest.permission.WRITE_EXTERNAL_STORAGE),
            PERMISSION_REQUEST_CODE
        )
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when (requestCode) {
            PERMISSION_REQUEST_CODE -> {
                if (grantResults.isEmpty() || grantResults[0] != PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(activity as Activity, "Permission Denied", Toast.LENGTH_SHORT)
                        .show()
                } else {
                    Toast.makeText(context, "Permission GRANDED", Toast.LENGTH_LONG).show()
                }
            }
        }
    }
}