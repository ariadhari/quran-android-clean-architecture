package id.gorgom.quranapp.data

import id.gorgom.quranapp.domain.model.alquran.Ayat
import id.gorgom.quranapp.domain.model.alquran.Surah

interface QuranDataSource {

    suspend fun getAllSurah(): List<Surah>
    suspend fun getAllAyat(number: String): List<Ayat>
    suspend fun insertSurahDao(data: List<Surah>)
    suspend fun insertAyatDao(number: String, data: List<Ayat>)
}