package com.asraven.star_wars.database.model.dao

import androidx.room.Dao
import androidx.room.Query
import com.asraven.star_wars.database.model.CharacterEntity
import com.asraven.star_wars.model.CharacterStarWars
import kotlinx.coroutines.flow.Flow


@Dao
interface CharactersDao {
    @Query("SELECT * FROM characters")
    fun getAll(): Flow<List<CharacterEntity>>

//    @Query("SELECT * FROM user WHERE uid IN (:userIds)")
//    fun loadAllByIds(userIds: IntArray): List<User>
//
//    @Query("SELECT * FROM user WHERE first_name LIKE :first AND " +
//            "last_name LIKE :last LIMIT 1")
//    fun findByName(first: String, last: String): User
//
//    @Insert
//    fun insertAll(vararg users: User)
//
//    @Delete
//    fun delete(user: User)
}