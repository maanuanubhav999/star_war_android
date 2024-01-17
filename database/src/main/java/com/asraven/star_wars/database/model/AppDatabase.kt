package com.asraven.star_wars.database.model

import androidx.room.Database
import androidx.room.RoomDatabase
import com.asraven.star_wars.database.model.dao.CharactersDao


@Database(entities = [CharacterEntity::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun charactersDao(): CharactersDao
}