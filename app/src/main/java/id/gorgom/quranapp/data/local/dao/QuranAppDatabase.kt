package id.gorgom.quranapp.data.local.dao

import androidx.room.Database
import androidx.room.RoomDatabase
import id.gorgom.quranapp.data.local.entity.AyatEntity
import id.gorgom.quranapp.data.local.entity.SurahEntity

@Database(
    entities = [
        AyatEntity::class,
        SurahEntity::class
    ],
    version = 1,
    exportSchema = false
)
abstract class QuranAppDatabase : RoomDatabase() {
    abstract fun quranDao(): QuranDao
}