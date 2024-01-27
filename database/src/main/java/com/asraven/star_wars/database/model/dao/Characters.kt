package com.asraven.star_wars.database.model.dao

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Upsert
import com.asraven.star_wars.database.model.CharacterEntity
import com.asraven.star_wars.model.CharacterStarWars
import kotlinx.coroutines.flow.Flow


@Dao
interface CharactersDao {
    @Query("SELECT * FROM characters")
    fun getAll(): Flow<List<CharacterEntity>>

    @Upsert
    fun insertAll(data: List<CharacterEntity>)

    @Query("SELECT * FROM characters")
    fun pagingSource(): PagingSource<Int, CharacterEntity>

    @Query("DELETE FROM characters")
    suspend fun clearAll()


}