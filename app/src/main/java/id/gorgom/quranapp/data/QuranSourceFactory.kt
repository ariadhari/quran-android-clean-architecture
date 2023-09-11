package id.gorgom.quranapp.data

import id.gorgom.quranapp.data.local.QuranLocalDataSource
import id.gorgom.quranapp.data.remote.QuranRemoteDataSource
import id.gorgom.quranapp.utils.Source
import javax.inject.Inject

class QuranSourceFactory @Inject constructor(
    private val quranRemoteDataSource: QuranRemoteDataSource,
    private val quranLocalDataSource: QuranLocalDataSource
) {

    fun create(source: Source): QuranDataSource {
        return when (source) {
            Source.NETWORK -> quranRemoteDataSource
            else -> quranLocalDataSource
        }
    }
}