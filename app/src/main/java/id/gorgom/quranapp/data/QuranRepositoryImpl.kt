package id.gorgom.quranapp.data

import id.gorgom.quranapp.domain.model.alquran.Ayat
import id.gorgom.quranapp.domain.model.alquran.Surah
import id.gorgom.quranapp.domain.repository.QuranRepository
import id.gorgom.quranapp.utils.Source
import javax.inject.Inject

class QuranRepositoryImpl @Inject constructor(private val quranSourceFactory: QuranSourceFactory) :
    QuranRepository {
    override suspend fun getAllSurah(): List<Surah> {
        return quranSourceFactory.create(Source.LOCAL).getAllSurah()
            .ifEmpty { syncSurahRemote() }
    }

    private suspend fun syncSurahRemote(): List<Surah> {
        return quranSourceFactory.create(Source.NETWORK).getAllSurah()
            .also { quranSourceFactory.create(Source.LOCAL).insertSurahDao(it) }
    }

    override suspend fun getAllAyat(number: String): List<Ayat> {
        return quranSourceFactory.create(Source.LOCAL).getAllAyat(number)
            .ifEmpty { syncAyatRemote(number) }
    }

    private suspend fun syncAyatRemote(number: String): List<Ayat> {
        return quranSourceFactory.create(Source.NETWORK).getAllAyat(number)
            .also { quranSourceFactory.create(Source.LOCAL).insertAyatDao(number, it) }
    }
}