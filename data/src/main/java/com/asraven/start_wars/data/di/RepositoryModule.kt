package com.asraven.start_wars.data.di

import com.asraven.start_wars.data.CharactersRepository
import com.asraven.start_wars.data.OfflineFirstCharactersRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent



@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {

   @Binds
    fun bindsSearchRepository(
        charactersRepository: OfflineFirstCharactersRepository
    ): CharactersRepository

}
