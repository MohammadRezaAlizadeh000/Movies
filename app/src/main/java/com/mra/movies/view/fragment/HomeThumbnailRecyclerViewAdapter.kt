package com.mra.movies.view.fragment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mra.movies.databinding.MovieThumbnailRecyclerViewRowBinding
import com.mra.movies.model.MovieEntity
import com.mra.movies.view.createRateString
import com.mra.movies.view.loadImage

class HomeThumbnailRecyclerViewAdapter(
    val onItemClickListener: (MovieEntity?) -> Unit
) : RecyclerView.Adapter<MoviesThumbnailHolder>() {

    private val dataList = mutableListOf<MovieEntity?>()
    fun setDate(data: List<MovieEntity?>?) {
        data?.let {
            dataList.apply {
                clear()
                addAll(it)
            }
        }
    }

    fun refreshList() {
        val listSize = dataList.size
        dataList.clear()
        notifyItemRangeRemoved(0, listSize)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        MoviesThumbnailHolder(
            MovieThumbnailRecyclerViewRowBinding
                .inflate(LayoutInflater.from(parent.context), parent, false)
        )

    override fun onBindViewHolder(holder: MoviesThumbnailHolder, position: Int) {
        val model = dataList[position]

        model?.let {
            with(holder) {
                poster.loadImage(it.posterUrl)
                title.text = model.title
                rate.createRateString(it.imDbRate, it.imDbRateCount)
                year.text = model.year
                crew.text = model.crew

                dataBackground.setOnClickListener {
                    crew.visibility = if (crew.visibility == View.VISIBLE) View.GONE else View.VISIBLE
                }

                itemView.setOnClickListener { onItemClickListener(model) }
            }
        }
    }

    override fun getItemCount() = dataList.size

}

class MoviesThumbnailHolder(binding: MovieThumbnailRecyclerViewRowBinding) :
    RecyclerView.ViewHolder(binding.root) {

    val poster: ImageView = binding.moviePoster
    val dataBackground: LinearLayout = binding.dataBackground
    val rate: TextView = binding.movieRate
    val year: TextView = binding.movieYear
    val title: TextView = binding.movieTitle
    val crew: TextView = binding.movieCrew

}