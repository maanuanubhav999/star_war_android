package com.asraven.start_wars.data.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.asraven.star_wars.model.CharacterStarWars
import com.asraven.start_wars.data.Api
import retrofit2.HttpException
import java.io.IOException

class CharactersPagingSource(
    private val api: Api
) : PagingSource<Int, CharacterStarWars>() {

    var pageCount = 0

    override fun getRefreshKey(state: PagingState<Int, CharacterStarWars>): Int? {
        return null

    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, CharacterStarWars> {

                return try {
                    val currentPage = params.key ?: 1
                    val allCharactersResponse = api.getAllCharacters( currentPage)

                    LoadResult.Page(
                        data = allCharactersResponse.results,
                        prevKey = allCharactersResponse.previous?.substringAfterLast("page=")?.toIntOrNull(),
                        nextKey = allCharactersResponse.next?.substringAfterLast("page=")?.toIntOrNull()
                    )
                } catch (e: IOException) {
                    LoadResult.Error(e)
                } catch (e: HttpException) {
                    LoadResult.Error(e)
                }
        }


}
