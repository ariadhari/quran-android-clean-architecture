package id.gorgom.quranapp.data.remote

import id.gorgom.quranapp.data.QuranDataSource
import id.gorgom.quranapp.data.mapper.AyatMapper.mappingAyatResponseToAyat
import id.gorgom.quranapp.data.mapper.SurahMapper.mappingSurahResponseToSurah
import id.gorgom.quranapp.data.remote.service.QuranApi
import id.gorgom.quranapp.domain.model.alquran.Ayat
import id.gorgom.quranapp.domain.model.alquran.Surah
import javax.inject.Inject

class QuranRemoteDataSource @Inject constructor(
    private val quranApi: QuranApi
) : QuranDataSource {
    override suspend fun getAllSurah(): List<Surah> {
        return quranApi.getListSurah().mappingSurahResponseToSurah()
    }

    override suspend fun insertSurahDao(data: List<Surah>) {

    }

    override suspend fun getAllAyat(number: String): List<Ayat> {
        return quranApi.getDetailSurah(nomor = number).mappingAyatResponseToAyat()
    }

    override suspend fun insertAyatDao(number: String, data: List<Ayat>) {

    }
}