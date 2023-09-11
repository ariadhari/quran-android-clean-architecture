package id.gorgom.quranapp.data.mapper

import id.gorgom.quranapp.data.local.entity.AyatEntity
import id.gorgom.quranapp.data.remote.response.alquran.AyatResponse
import id.gorgom.quranapp.domain.model.alquran.Ayat

object AyatMapper {
    fun AyatResponse?.mappingAyatResponseToAyat(): List<Ayat> {
        val newList: MutableList<Ayat> = mutableListOf()

        this?.forEach {
            newList.add(
                Ayat(
                    ar = it.ar,
                    id = it.id,
                    nomor = it.nomor,
                    tr = it.tr
                )
            )
        }

        return if (this.isNullOrEmpty()) {
            emptyList()
        } else {
            newList
        }
    }

    fun List<Ayat>?.mappingAyatToAyatEntity(nomorSurah: String): List<AyatEntity> {
        val newList: MutableList<AyatEntity> = mutableListOf()

        this?.forEach {
            newList.add(
                AyatEntity(
                    idAyat = 0,
                    nomorSurah = nomorSurah,
                    ar = it.ar,
                    id = it.id,
                    nomor = it.nomor,
                    tr = it.tr
                )
            )
        }

        return if (this.isNullOrEmpty()) {
            emptyList()
        } else {
            newList
        }

    }

    fun List<AyatEntity>?.mappingAyatEntityToAyat(): List<Ayat> {
        val newList: MutableList<Ayat> = mutableListOf()

        this?.forEach {
            newList.add(
                Ayat(
                    ar = it.ar,
                    id = it.id,
                    nomor = it.nomor,
                    tr = it.tr
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