package com.example.presentation.screens.articles

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.Resource
import com.example.domain.states.ArticlesState
import com.example.domain.use_cases.ArticlesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject


@HiltViewModel
class ArticlesViewModel @Inject constructor(
    private val articlesUseCase: ArticlesUseCase,
) : ViewModel() {


    private val _state = mutableStateOf(ArticlesState())
    val articlesState: State<ArticlesState>
        get() = _state


    init {

        getArticles()
    }


    private fun getArticles() {
        articlesUseCase().onEach { result ->
            when (result) {
                is Resource.Success -> {

                    _state.value = ArticlesState(
                        listArticles = result.data ?: emptyList()
                    )

                }

                is Resource.Error -> {
                    _state.value = ArticlesState(
                        error = result.message ?: "An unexpected error happened"
                    )
                }

                is Resource.Loading -> {
                    _state.value = ArticlesState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)

    }


}