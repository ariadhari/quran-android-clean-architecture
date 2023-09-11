package id.gorgom.quranapp.presentation.alquran

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import id.gorgom.quranapp.domain.usecase.alquran.SurahUseCase
import id.gorgom.quranapp.utils.ResultState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AlquranViewModel @Inject constructor(
    private val surahUseCase: SurahUseCase
) : ViewModel() {
    private val _listSurahData = MutableStateFlow(AlquranState())
    var listSurahData: StateFlow<AlquranState> = _listSurahData

    fun getAllSurah() = viewModelScope.launch(Dispatchers.IO) {
        surahUseCase().collect {
            when (it) {
                is ResultState.Success -> {
                    _listSurahData.value = AlquranState(alquranList = it.data ?: emptyList())
                }
                is ResultState.Loading -> {
                    _listSurahData.value = AlquranState(isLoading = true)
                }
                is ResultState.Error -> {
                    _listSurahData.value =
                        AlquranState(error = it.message ?: "An Unexpected Error")
                }
            }
        }
    }
}