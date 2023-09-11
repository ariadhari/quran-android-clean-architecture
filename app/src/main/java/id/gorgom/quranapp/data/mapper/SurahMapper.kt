package id.gorgom.quranapp.data.mapper

import id.gorgom.quranapp.data.local.entity.SurahEntity
import id.gorgom.quranapp.data.remote.response.alquran.SurahResponse
import id.gorgom.quranapp.domain.model.alquran.Surah

object SurahMapper {
    fun SurahResponse?.mappingSurahResponseToSurah(): List<Surah> {
        val newList: MutableList<Surah> = mutableListOf()

        this?.forEach {
            newList.add(
                Surah(
                    arti = it.arti,
                    asma = it.asma,
                    audio = it.audio,
                    ayat = it.ayat,
                    keterangan = it.keterangan,
                    nama = it.nama,
                    nomor = it.nomor,
                    rukuk = it.rukuk,
                    type = it.type,
                    urut = it.urut
                )
            )
        }

        return if (this.isNullOrEmpty()) {
            emptyList()
        } else {
            newList
        }
    }

    fun List<Surah>?.mappingSurahToSurahEntity(): List<SurahEntity> {
        val newList: MutableList<SurahEntity> = mutableListOf()

        this?.forEach {
            newList.add(
                SurahEntity(
                    id = 0,
                    arti = it.arti,
                    asma = it.asma,
                    audio = it.audio,
                    ayat = it.ayat,
                    keterangan = it.keterangan,
                    nama = it.nama,
                    nomor = it.nomor,
                    rukuk = it.rukuk,
                    type = it.type,
                    urut = it.urut
                )
            )
        }

        return if (this.isNullOrEmpty()) {
            emptyList()
        } else {
            newList
        }

    }

    fun List<SurahEntity>?.mappingSurahEntityToSurah(): List<Surah> {
        val newList: MutableList<Surah> = mutableListOf()

        this?.forEach {
            newList.add(
                Surah(
                    arti = it.arti,
                    asma = it.asma,
                    audio = it.audio,
                    ayat = it.ayat,
                    keterangan = it.keterangan,
                    nama = it.nama,
                    nomor = it.nomor,
                    rukuk = it.rukuk,
                    type = it.type,
                    urut = it.urut
                )
            )
        }

        return if (this.isNullOrEmpty()) {
            emptyList()
        } else {
            newList
        }
    }
}