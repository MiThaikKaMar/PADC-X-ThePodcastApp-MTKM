package com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.R
import com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.adapters.CategoryAdapter
import com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.data.vos.GeneresVO
import com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.mvp.presenters.CategoriesPresenter
import com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.mvp.presenters.impls.CategoriesPresenterImpl
import com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.mvp.views.CategoriesView
import com.padcmyanmar.padcx.padc_x_thepodcastapp_mtkm.views.viewpods.EmptyViewPod
import com.padcmyanmar.padcx.shared.fragments.BaseFragment
import kotlinx.android.synthetic.main.fragment_categories.*
import mk.padc.share.utils.load

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"
class CategoriesFragment : BaseFragment(),CategoriesView {
    private var param1: String? = null
    private var param2: String? = null

private lateinit var mCategoriesPresenter : CategoriesPresenter
    private val mCategoriesAdapter = CategoryAdapter()
    private lateinit var mEmptyViewPod: EmptyViewPod

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
        return inflater.inflate(R.layout.fragment_categories, container, false)
    }

    companion object {
        fun newInstance(param1: String, param2: String) =
            CategoriesFragment().apply {
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
        mCategoriesPresenter.onUiReady(this,"")
    }

    private fun setUpPresenter(){
        mCategoriesPresenter=ViewModelProviders.of(this).get(CategoriesPresenterImpl::class.java)
        mCategoriesPresenter.initPresenter(this)
    }

    private fun setUpRecyclerView(){
        mEmptyViewPod = vp_empty_cate as EmptyViewPod
        rl_categories.adapter=mCategoriesAdapter
        val layoutManager = LinearLayoutManager(this.context,LinearLayoutManager.HORIZONTAL,false)
        rl_categories.layoutManager=layoutManager
        rl_categories.setEmpytView(mEmptyViewPod)
    }


    override fun showGenresList(genresList: List<GeneresVO>) {
        mCategoriesAdapter.setData(genresList.toMutableList())
    }

    override fun showMainCategory(list: List<GeneresVO>) {
        iv_cate.load(getString(R.string.image))
        tv_main_cate.text=getString(R.string.name)
    }
}