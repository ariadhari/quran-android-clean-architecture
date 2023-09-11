package id.gorgom.quranapp.presentation.alquran

import id.gorgom.quranapp.domain.model.alquran.Surah

data class AlquranState(
    val isLoading: Boolean = false,
    val alquranList: List<Surah> = emptyList(),
    val error: String = ""
)