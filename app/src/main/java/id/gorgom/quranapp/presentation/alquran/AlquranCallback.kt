package id.gorgom.quranapp.presentation.alquran

import id.gorgom.quranapp.domain.model.alquran.Surah

interface AlquranCallback {
    fun onDetailSurahAlquran(surah: Surah)
}