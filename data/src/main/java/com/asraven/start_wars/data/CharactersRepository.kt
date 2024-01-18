package com.asraven.start_wars.data

import androidx.paging.PagingData
import com.asraven.star_wars.model.CharacterStarWars
import kotlinx.coroutines.flow.Flow



interface CharactersRepository: Syncable {

    fun getCharactersResources(pageNumber: Int)
     : Flow<PagingData<CharacterStarWars>>
}