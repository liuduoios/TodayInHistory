package org.liuduo.todayinhistory.ui

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import org.liuduo.todayinhistory.data.Item
import org.liuduo.todayinhistory.viewmodels.MainViewModel

@Composable
fun ListScreen(uiState: UIState, onItemClicked: (Item) -> Unit, modifier: Modifier = Modifier) {
    Scaffold(
        content = {
            ItemList(
                itemList = uiState.itemList,
                onItemClicked = { onItemClicked(it) }
            )
        }
    )
}