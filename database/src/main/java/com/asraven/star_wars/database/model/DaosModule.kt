package com.asraven.star_wars.database.model

import com.asraven.star_wars.database.model.dao.CharactersDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
object DaosModule {

    @Provides
    fun providesCharacterDao(
        database: AppDatabase
    ): CharactersDao = database.charactersDao()
}