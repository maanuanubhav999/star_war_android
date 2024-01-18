package com.asraven.start_wars.data

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.asraven.star_wars.database.model.CharacterEntity
import com.asraven.star_wars.database.model.asExternalModule
import com.asraven.star_wars.database.model.dao.CharactersDao
import com.asraven.star_wars.model.CharacterStarWars
import com.asraven.start_wars.data.paging.CharactersPagingSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class OfflineFirstCharactersRepository @Inject constructor(
    private val charactersDao: CharactersDao,
    private val api: Api
): CharactersRepository {
    override fun getCharactersResources(pageNumber: Int): Flow<PagingData<CharacterStarWars>> =
         Pager(PagingConfig(pageSize = 1)) { CharactersPagingSource(api) }.flow


    override suspend fun syncWith(synchronizer: Synchronizer): Boolean {

        return synchronizer.changeListSync(
            versionReader = ChangeListVersions::charactersResource,
            changeListFetcher = { currentVersion ->
//                api.getAllCharacters (after = currentVersion)
//                api.getAllCharacters()
                listOf()

            },
            versionUpdater = { latestVersion ->
                copy(charactersResource = latestVersion)
            },
            modelDeleter = {},
            modelUpdater = { changedIds ->



//
//                // Obtain the news resources which have changed from the network and upsert them locally
//                changedIds.chunked(40).forEach { chunkedIds ->
//                    val networkNewsResources = api.getNewsResources(ids = chunkedIds)
//
//                    charactersDao.upsertNewsResources(
//                        newsResourceEntities = networkNewsResources.map(
//                            NetworkNewsResource::asEntity,
//                        ),
//                    )
//
//                }

            },
        )
    }

}