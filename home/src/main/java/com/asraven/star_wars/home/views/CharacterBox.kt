package com.asraven.star_wars.home.views

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.asraven.star_wars.model.CharacterStarWars

/* 
        {
            "name": "Anakin Skywalker", 
            "height": "188", 
            "mass": "84", 
            "hair_color": "blond", 
            "skin_color": "fair", 
            "eye_color": "blue", 
            "birth_year": "41.9BBY", 
            "gender": "male", 
            "homeworld": "https://swapi.dev/api/planets/1/", 
            "films": [
                "https://swapi.dev/api/films/4/", 
                "https://swapi.dev/api/films/5/", 
                "https://swapi.dev/api/films/6/"
            ], 
            "species": [], 
            "vehicles": [
                "https://swapi.dev/api/vehicles/44/", 
                "https://swapi.dev/api/vehicles/46/"
            ], 
            "starships": [
                "https://swapi.dev/api/starships/39/", 
                "https://swapi.dev/api/starships/59/", 
                "https://swapi.dev/api/starships/65/"
            ], 
            "created": "2014-12-10T16:20:44.310000Z", 
            "edited": "2014-12-20T21:17:50.327000Z", 
            "url": "https://swapi.dev/api/people/11/"
        },
 */


@Composable
fun CharacterBox(character: CharacterStarWars){
    Column(
        modifier = Modifier.widthIn(128.dp)
    ) {
        Text(text = "Name: ${character.name}")
        Text(text = "Height: ${character.height}")
        Text(text = ": ${character.name}")
        Spacer(modifier = Modifier.height(20.dp))
        
        
    }   
}