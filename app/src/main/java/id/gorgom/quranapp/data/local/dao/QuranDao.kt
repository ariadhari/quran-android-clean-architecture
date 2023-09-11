package id.gorgom.quranapp.data.local.dao

import androidx.room.*
import id.gorgom.quranapp.data.local.entity.*

@Dao
interface QuranDao {

    @Query("SELECT * FROM tbl_surah")
    fun getAllSurah(): List<SurahEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertSurah(surahEntity: List<SurahEntity>)

    @Query("SELECT * FROM tbl_ayat WHERE nomorSurah=:nomor")
    fun getAllAyat(nomor: String): List<AyatEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAyat(ayatEntity: List<AyatEntity>)
}