package org.liuduo.todayinhistory.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.liuduo.todayinhistory.data.Item

@Composable
fun DetailScreen(title: String, details: String, modifier: Modifier = Modifier) {
    Column {
        Text(
            text = title,
            fontSize = 26.sp,
            modifier = Modifier.padding()
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = details,
            fontSize = 18.sp,
            modifier = Modifier.padding()
        )
    }
}