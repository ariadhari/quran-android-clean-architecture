package id.gorgom.quranapp.domain.repository

import id.gorgom.quranapp.domain.model.alquran.Ayat
import id.gorgom.quranapp.domain.model.alquran.Surah

interface QuranRepository {

    suspend fun getAllSurah(): List<Surah>
    suspend fun getAllAyat(number: String): List<Ayat>
}