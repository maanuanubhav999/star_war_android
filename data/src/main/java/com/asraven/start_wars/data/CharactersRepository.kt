package com.asraven.start_wars.data

import com.asraven.star_wars.model.CharacterStarWars
import kotlinx.coroutines.flow.Flow



interface CharactersRepository {

    fun getCharactersResources(
    ) : Flow<List<CharacterStarWars>>
}