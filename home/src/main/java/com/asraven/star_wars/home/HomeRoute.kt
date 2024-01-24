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
import com.asraven.star_wars.home.views.CharacterBox
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
        columns = GridCells.Adaptive(minSize = 200.dp),
    ){
        items (lazyPagingItems.itemCount) {
            lazyPagingItems[it]?.let { it1 -> CharacterBox(it1) }

        }
    }

}

