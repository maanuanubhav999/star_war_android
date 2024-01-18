package com.asraven.start_wars.data

import com.asraven.star_wars.database.model.CharacterEntity
import com.asraven.star_wars.database.model.asExternalModule
import com.asraven.star_wars.database.model.dao.CharactersDao
import com.asraven.star_wars.model.CharacterStarWars
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class OfflineFirstCharactersRepository @Inject constructor(
    private val charactersDao: CharactersDao,
): CharactersRepository {
    override fun getCharactersResources(): Flow<List<CharacterStarWars>> =
            charactersDao.getAll() .map { it.map(CharacterEntity::asExternalModule) }

}