package id.gorgom.quranapp.presentation.alquran.detailalquran

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import id.gorgom.quranapp.domain.usecase.alquran.AyatUseCase
import id.gorgom.quranapp.utils.ResultState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailAlquranViewModel @Inject constructor(
    private val ayatUseCase: AyatUseCase
) : ViewModel() {
    private val _listAyatData = MutableStateFlow(DetailAlquranState())
    var listAyatData: StateFlow<DetailAlquranState> = _listAyatData

    fun getAllAyat(number: String) = viewModelScope.launch(Dispatchers.IO) {
        ayatUseCase(number = number).collect {
            when (it) {
                is ResultState.Success -> {
                    _listAyatData.value =
                        DetailAlquranState(detailAlquranList = it.data ?: emptyList())
                }
                is ResultState.Loading -> {
                    _listAyatData.value = DetailAlquranState(isLoading = true)
                }
                is ResultState.Error -> {
                    _listAyatData.value =
                        DetailAlquranState(error = it.message ?: "An Unexpected Error")
                }
            }
        }
    }
}