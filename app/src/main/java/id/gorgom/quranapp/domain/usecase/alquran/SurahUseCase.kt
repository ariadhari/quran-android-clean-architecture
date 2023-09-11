package id.gorgom.quranapp.domain.usecase.alquran

import id.gorgom.quranapp.domain.model.alquran.Surah
import id.gorgom.quranapp.domain.repository.QuranRepository
import id.gorgom.quranapp.utils.ResultState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class SurahUseCase @Inject constructor(
    private val repository: QuranRepository
) {
    operator fun invoke(): Flow<ResultState<List<Surah>>> = flow {
        try {
            emit(ResultState.Loading())
            val surah = repository.getAllSurah()
            emit(ResultState.Success(surah))
        } catch (e: HttpException) {
            emit(
                ResultState.Error(
                    e.localizedMessage ?: " An Unexpected Error Occurred"
                )
            )
        } catch (e: IOException) {
            emit(ResultState.Error("Error Occurred"))
        }
    }
}