package id.gorgom.quranapp.data.local

import id.gorgom.quranapp.data.QuranDataSource
import id.gorgom.quranapp.data.local.dao.QuranDao
import id.gorgom.quranapp.data.mapper.AyatMapper.mappingAyatEntityToAyat
import id.gorgom.quranapp.data.mapper.AyatMapper.mappingAyatToAyatEntity
import id.gorgom.quranapp.data.mapper.SurahMapper.mappingSurahEntityToSurah
import id.gorgom.quranapp.data.mapper.SurahMapper.mappingSurahToSurahEntity
import id.gorgom.quranapp.domain.model.alquran.Ayat
import id.gorgom.quranapp.domain.model.alquran.Surah
import javax.inject.Inject

class QuranLocalDataSource @Inject constructor(private val quranDao: QuranDao) :
    QuranDataSource {
    override suspend fun getAllSurah(): List<Surah> {
        return quranDao.getAllSurah().mappingSurahEntityToSurah()
    }

    override suspend fun getAllAyat(number: String): List<Ayat> {
        return quranDao.getAllAyat(number).mappingAyatEntityToAyat()
    }

    override suspend fun insertSurahDao(data: List<Surah>) {
        val dataEntities = data.mappingSurahToSurahEntity()
        return quranDao.insertSurah(dataEntities)
    }

    override suspend fun insertAyatDao(number: String, data: List<Ayat>) {
        val dataEntities = data.mappingAyatToAyatEntity(number)
        return quranDao.insertAyat(dataEntities)
    }
}