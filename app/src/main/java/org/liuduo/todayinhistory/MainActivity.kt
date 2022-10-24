package org.liuduo.todayinhistory

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import org.liuduo.todayinhistory.ui.theme.TodayInHistoryTheme
import org.liuduo.todayinhistory.viewmodels.MainViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val viewModel = MainViewModel()

        setContent {
            TodayInHistoryTheme {
                TodayInHistoryApp(viewModel = viewModel)
            }
        }
    }
}