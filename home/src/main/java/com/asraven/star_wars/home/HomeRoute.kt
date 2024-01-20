package com.asraven.star_wars.home

import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.asraven.star_wars.home.viewmodel.HomeViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import com.asraven.star_wars.model.CharacterStarWars

@Composable
 fun HomeRoute(
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = hiltViewModel(),
){
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    val lazyPagingItems: LazyPagingItems<CharacterStarWars> =
        uiState.data.collectAsLazyPagingItems()

    if (uiState.loading) Text("loading")
    LazyVerticalGrid(
        columns = GridCells.Adaptive(minSize = 128.dp),
    ){
        items (lazyPagingItems.itemCount) {
            Represent(lazyPagingItems[it]?.name?: "test")

        }
    }

    Text("loading")

}

@Composable
fun Represent(text: String){
    Text(text)
}