package id.gorgom.quranapp.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import id.gorgom.quranapp.data.local.dao.QuranAppDatabase
import id.gorgom.quranapp.data.local.dao.QuranDao

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    private const val DatabaseName = "QuranDB"

    @Provides
    fun provideRoomDatabase(@ApplicationContext context: Context): QuranAppDatabase {
        return Room.databaseBuilder(
            context,
            QuranAppDatabase::class.java,
            DatabaseName
        ).build()
    }

    @Provides
    fun providerQuranDao(quranAppDatabase: QuranAppDatabase): QuranDao {
        return quranAppDatabase.quranDao()
    }
}