package org.example.game.ui.game

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import org.example.game.domain.model.Game
import org.example.game.domain.usecases.GetGameUseCase

data class UIState(
    val loading: Boolean = false,
    val error: String= "",
    val data: List<Game>? = null
)

class GameViewModel(
    private val getGameUseCase: GetGameUseCase
): ViewModel() {
    private var _state = MutableStateFlow(UIState())
    val state = _state.asStateFlow()

    init {
        getGames()
    }


    fun getGames() {
        viewModelScope.launch {
            _state.value = UIState(loading = true)

            getGameUseCase().collect{result->
                result.onSuccess { data->
                    _state.value = UIState(data = data)
                }
                result.onFailure { error->
                    _state.value = UIState(error = error.toString())

                }

                }

            }
        }
    }