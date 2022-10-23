package org.liuduo.todayinhistory

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import org.liuduo.todayinhistory.data.Item
import org.liuduo.todayinhistory.ui.ItemList
import org.liuduo.todayinhistory.ui.theme.TodayInHistoryTheme
import org.liuduo.todayinhistory.viewmodels.MainViewModel

@Composable
fun TodayInHistoryApp(
    modifier: Modifier = Modifier,
    viewModel: MainViewModel = MainViewModel()
) {
    val uiState by viewModel.uiState.collectAsState()

    TodayInHistoryTheme {
        Scaffold(
            content = {
                ItemList(itemList = uiState.itemList)
            }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TodayInHistoryTheme {
        TodayInHistoryApp()
    }
}