package com.asraven.star_wars.home.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import com.asraven.star_wars.model.CharacterStarWars
import com.asraven.start_wars.data.CharactersRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject


data class HomeUiState(
    val loading: Boolean = false,
    val data: Flow<PagingData<CharacterStarWars>> = flowOf(),
)

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val charactersRepository: CharactersRepository
) : ViewModel() {


//    val uiState: StateFlow<HomeUiState> =
//        getFollowableTopics(sortBy = TopicSortField.NAME).map(
//            InterestsUiState::Interests,
//        ).stateIn(
//            scope = viewModelScope,
//            started = SharingStarted.WhileSubscribed(5_000),
//            initialValue = InterestsUiState.Loading,
//        )

    private val _uiState = MutableStateFlow(
        HomeUiState(
            loading = true,
        )
    )
    val uiState = _uiState.asStateFlow()

    private val coroutineExceptionHandler = CoroutineExceptionHandler { _, exception ->
        onError(exception)
    }

    private fun onError(throwable: Throwable) {
        Log.e("error", throwable.toString())
    }

    init {
        getAllCharacters()
    }
    private fun getAllCharacters() {
        viewModelScope.launch(coroutineExceptionHandler) {
            val data = charactersRepository.getCharactersResources(1)
            _uiState.update {
                it.copy(
                    loading = false,
                    data = data
                )
            }
        }
    }

}