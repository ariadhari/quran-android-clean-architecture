package id.gorgom.quranapp.domain.usecase.alquran

import id.gorgom.quranapp.domain.model.alquran.Ayat
import id.gorgom.quranapp.domain.repository.QuranRepository
import id.gorgom.quranapp.utils.ResultState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class AyatUseCase @Inject constructor(
    private val repository: QuranRepository
) {
    operator fun invoke(number: String): Flow<ResultState<List<Ayat>>> = flow {
        try {
            emit(ResultState.Loading())
            val ayat = repository.getAllAyat(number)
            emit(ResultState.Success(ayat))
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