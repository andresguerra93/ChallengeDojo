package com.agc.challengedojo.di

import androidx.room.Database
import com.agc.challengedojo.data.local.dao.CharacterDao
import com.agc.challengedojo.data.remote.api.RickAndMortyApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideRetrofit(client: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://rickandmortyapi.com/api/")
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    @Provides
    @Singleton
    fun provideRickAndMortyApiService(): ApiService {
        return RetrofitInstance.api
    }

    @Provides
    @Singleton
    fun provideCharacterDao(db: Database): CharacterDao {
        return db.characterDao()
    }

    @Provides
    @Singleton
    fun provideEpisodeDao(db: Database): EpisodeDao {
        return db.episodeDao()
    }

    @Provides
    @Singleton
    fun provideCharacterRepository(
        apiService: RickAndMortyApiService,
        characterDao: CharacterDao
    ): CharacterRepositoryImpl {
        return CharacterRepositoryImpl(apiService, characterDao)
    }

    @Provides
    @Singleton
    fun provideEpisodeRepository(
        apiService: RickAndMortyApiService,
        episodeDao: EpisodeDao
    ): EpisodeRepositoryImpl {
        return EpisodeRepositoryImpl(apiService, episodeDao)
    }
}
