package org.liuduo.todayinhistory.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import org.liuduo.todayinhistory.data.Item

@Composable
fun ItemCard(item: Item, modifier: Modifier = Modifier) {
    Card(modifier = modifier.padding(8.dp), elevation = 4.dp) {
        Column {
            AsyncImage(
                model = item.picUrl,
                contentDescription = null,
                modifier = Modifier.fillMaxWidth().height(100.dp).background(Color.Gray)
            )
            Text(
                text = item.title
            )
            Text(
                text = "${item.year}.${item.month}.${item.day}"
            )
        }
    }
}