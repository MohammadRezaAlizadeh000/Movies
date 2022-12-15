package com.mra.movies.view.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.mra.movies.databinding.HomeFragmentBinding
import com.mra.movies.view.BaseFragment
import com.mra.movies.viewModel.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment: BaseFragment<HomeFragmentBinding>(HomeFragmentBinding::inflate) {

    private val viewModel: HomeViewModel by viewModels()
    private var recyclerViewAdapter: HomeThumbnailRecyclerViewAdapter? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }

}