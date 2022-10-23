package org.liuduo.todayinhistory.ui

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import org.liuduo.todayinhistory.data.Item

@Composable
fun ItemList(itemList: List<Item>, modifier: Modifier = Modifier) {
    LazyColumn {
        items(itemList) { item ->
            ItemCard(item = item)
        }
    }
}