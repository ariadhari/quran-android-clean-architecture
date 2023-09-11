package id.gorgom.quranapp.data.local.entity

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tbl_ayat")
data class AyatEntity(
    @PrimaryKey(autoGenerate = true)
    @NonNull
    val idAyat: Int,
    val nomorSurah: String,
    val id: String,
    val ar: String,
    val nomor: String,
    val tr: String
)
