package com.asraven.start_wars.data.paging

import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import androidx.room.withTransaction
import com.asraven.star_wars.database.model.AppDatabase
import com.asraven.star_wars.database.model.CharacterEntity
import com.asraven.star_wars.database.model.asInternalModule
import com.asraven.star_wars.database.model.dao.CharactersDao
import com.asraven.star_wars.model.CharacterStarWars
import com.asraven.start_wars.data.Api
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

@OptIn(ExperimentalPagingApi::class)
class CharacterPagingSourceUsingRemoteMediator @Inject constructor(
//    private val dao: CharactersDao,
    private val database: AppDatabase,
    private val api: Api
): RemoteMediator<Int, CharacterEntity>() {

 var counter = 1
    override suspend fun load(
        loadType: LoadType,
        state: PagingState<Int, CharacterEntity>
    ): MediatorResult {
        return try {

            val loadKey = when (loadType) {
                LoadType.REFRESH -> 1
                LoadType.PREPEND -> return MediatorResult.Success(
                    endOfPaginationReached = true
                )

                LoadType.APPEND -> {
                    val lastItem = state.lastItemOrNull()
                    if (lastItem == null) {
                        counter
                    } else {
                        counter++
                    }
                }
            }
            //suspending call, doesn't need to be wrapped in a withContext(Dispatcher.IO)
            val response = api.getAllCharacters(loadKey)
            database.withTransaction {
                if (loadType == LoadType.REFRESH) {
                    database.charactersDao().clearAll()
                }
                val entity = response.results.map { it.asInternalModule() }
                database.charactersDao().insertAll(entity)
            }
            MediatorResult.Success(
                endOfPaginationReached = response.next?.substringAfterLast("page=")
                    ?.toIntOrNull() == null
            )

        } catch (e: IOException) {
            MediatorResult.Error(e)
        } catch (e: HttpException) {
            MediatorResult.Error(e)
        }
    }
}