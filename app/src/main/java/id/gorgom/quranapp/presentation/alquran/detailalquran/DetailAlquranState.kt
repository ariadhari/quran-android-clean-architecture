package id.gorgom.quranapp.presentation.alquran.detailalquran

import id.gorgom.quranapp.domain.model.alquran.Ayat

data class DetailAlquranState(
    val isLoading: Boolean = false,
    val detailAlquranList: List<Ayat> = emptyList(),
    val error: String = ""
)