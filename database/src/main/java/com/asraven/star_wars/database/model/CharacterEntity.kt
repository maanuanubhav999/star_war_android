package com.asraven.star_wars.database.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.asraven.star_wars.model.CharacterStarWars


@Entity(
    tableName = "characters",
)
data class CharacterEntity(
    @PrimaryKey(autoGenerate = true)
    val id: String,
    @ColumnInfo(name = "birth_year")
    val birthYear: String,
    val created: String,
    val edited: String,
    @ColumnInfo(name = "eye_color")
    val eyeColor: String,
    val films: List<String>,
    val gender: String,
    @ColumnInfo(name = "hair_color")
    val hairColor: String,
    val height: String,
    @ColumnInfo(name = "homeworld")
    val homeWorld: String,
    val mass: String,
    val name: String,
    @ColumnInfo(name = "skin_color")
    val skinColor: String,
    val species: List<Any>,
    val starships: List<String>,
    val url: String,
    val vehicles: List<String>
)


fun CharacterEntity.asExternalModule() = CharacterStarWars(
    birth_year = birthYear,
    created = created,
    edited = edited,
    eye_color = eyeColor,
    films = films,
    gender = gender,
    hair_color = hairColor,
    height = height,
    homeworld = homeWorld,
    mass = mass,
    name = name,
    skin_color = skinColor,
    species = species,
    starships = starships,
    url = url,
    vehicles = vehicles
)
