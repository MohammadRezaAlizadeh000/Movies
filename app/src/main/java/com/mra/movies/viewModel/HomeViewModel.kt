package com.mra.movies.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mra.movies.domin.GetPopularMoviesUseCase
import com.mra.movies.model.MovieEntity
import com.mra.movies.utils.ResponseState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val popularMoviesUseCase: GetPopularMoviesUseCase
): ViewModel() {

    data class PopularMoviesData(
        override val errorMessage: String? = null,
        override val page: Int? = null,
        override val data: List<MovieEntity?>? = null
    ): BaseResponseDataFlow<List<MovieEntity?>?>

    private var popularMoviesJob: Job? = null
    private val _popularMoviesFlow = MutableStateFlow(PopularMoviesData())
    val popularMoviesFlow: StateFlow<PopularMoviesData> = _popularMoviesFlow

    fun getPopularMovies() {
        popularMoviesJob = viewModelScope.launch {
            _popularMoviesFlow.value = when(val response = popularMoviesUseCase()) {
                is ResponseState.Success -> PopularMoviesData(data = response.data)
                is ResponseState.Error -> PopularMoviesData(errorMessage = response.message)
                is ResponseState.Loading -> PopularMoviesData()
                else -> PopularMoviesData()
            }
        }
    }

    fun clearPopularMoviesMessageFlow() {
        _popularMoviesFlow.update {
            it.copy(errorMessage = null)
        }
    }


    override fun onCleared() {
        popularMoviesJob?.cancel()
        popularMoviesJob = null
        super.onCleared()
    }

}