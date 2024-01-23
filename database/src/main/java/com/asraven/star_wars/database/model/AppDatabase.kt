package com.asraven.star_wars.database.model

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.asraven.star_wars.database.model.dao.CharactersDao


@Database(entities = [CharacterEntity::class], version = 1, exportSchema = false)
@TypeConverters(
    Converter::class,
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun charactersDao(): CharactersDao
}