package id.gorgom.quranapp.data.remote.service

import id.gorgom.quranapp.data.remote.response.alquran.AyatResponse
import id.gorgom.quranapp.data.remote.response.alquran.SurahResponse
import id.gorgom.quranapp.data.remote.response.sholat.JadwalSholatResponse
import id.gorgom.quranapp.data.remote.response.sholat.KotaSholatResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Url

interface QuranApi {

    // Feature Alquran
    @GET("/99c279bb173a6e28359c/data")
    suspend fun getListSurah(): SurahResponse

    @GET("/99c279bb173a6e28359c/surat/{nomor}")
    suspend fun getDetailSurah(
        @Path("nomor") nomor: String
    ): AyatResponse

    // Feature Sholat
    @GET
    suspend fun getKotaSholat(
        @Url sholatKotaUrl: String
    ): KotaSholatResponse

    @GET
    suspend fun getJadwalSholat(
        @Url sholatJadwalUrl: String
    ): JadwalSholatResponse
}