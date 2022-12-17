package com.mra.movies.view.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.mra.movies.databinding.HomeFragmentBinding
import com.mra.movies.utils.flowLife
import com.mra.movies.utils.toast
import com.mra.movies.view.BaseFragment
import com.mra.movies.viewModel.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseFragment<HomeFragmentBinding>(HomeFragmentBinding::inflate) {

    private val viewModel: HomeViewModel by viewModels()
    private var recyclerViewAdapter: HomeThumbnailRecyclerViewAdapter? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initRecyclerViewAdapter()
        initRecyclerview()

        popularMoviesObservable()
    }


    private fun popularMoviesObservable() {
        flowLife(viewModel.popularMoviesFlow) {
            it.errorMessage?.let { message ->
                toast(message)
                viewModel.clearPopularMoviesMessageFlow()
            }

            it.data?.let { movies ->
                recyclerViewAdapter?.setDate(movies)
            }
        }
    }

    private fun initRecyclerViewAdapter() {
        recyclerViewAdapter = HomeThumbnailRecyclerViewAdapter(
            onItemClickListener = { movie ->
                toast(movie?.title)
            },
            callNewMovies = {
                viewModel.getPopularMovies(it ?: 0, false)
            })
    }

    private fun initRecyclerview() {
        binding.moviesRecyclerView.apply {
            context?.let { mContext ->
                layoutManager = GridLayoutManager(mContext, 2, GridLayoutManager.VERTICAL, false)
                adapter = recyclerViewAdapter
            }
        }
    }

}