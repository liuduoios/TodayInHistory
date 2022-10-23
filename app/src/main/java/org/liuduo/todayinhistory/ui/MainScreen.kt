package org.liuduo.todayinhistory

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import org.liuduo.todayinhistory.data.Item
import org.liuduo.todayinhistory.ui.DetailScreen
import org.liuduo.todayinhistory.ui.ItemList
import org.liuduo.todayinhistory.ui.ListScreen
import org.liuduo.todayinhistory.ui.theme.TodayInHistoryTheme
import org.liuduo.todayinhistory.viewmodels.MainViewModel

enum class TodayInHistoryScreen(@StringRes val title: Int) {
    List(title = R.string.app_title),
    Detail(title = R.string.detail)
}

@Composable
fun TodayInHistoryAppBar(
    currentScreen: TodayInHistoryScreen,
    canNavigateBack: Boolean,
    navigateUp: () -> Unit,
    modifier: Modifier = Modifier
) {
    TopAppBar(
        title = { Text(stringResource(currentScreen.title)) },
        modifier = modifier,
        navigationIcon = {
            if (canNavigateBack) {
                IconButton(onClick = navigateUp) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = stringResource(R.string.back)
                    )
                }
            }
        }
    )
}

@Composable
fun TodayInHistoryApp(
    modifier: Modifier = Modifier,
    viewModel: MainViewModel = MainViewModel()
) {
    val navController = rememberNavController()

    val uiState by viewModel.uiState.collectAsState()

    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentScreen = TodayInHistoryScreen.valueOf(
        backStackEntry?.destination?.route ?: TodayInHistoryScreen.List.name
    )

    Scaffold(
        topBar = {
            TodayInHistoryAppBar(
                currentScreen = currentScreen,
                canNavigateBack = navController.previousBackStackEntry != null,
                navigateUp = { navController.navigateUp() }
            )
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = TodayInHistoryScreen.List.name,
            modifier = modifier.padding(innerPadding)
        ) {
            composable(route = TodayInHistoryScreen.List.name) {
                ListScreen(
                    uiState = uiState,
                    onItemClicked = { item ->
                        navController.navigate(TodayInHistoryScreen.Detail.name)
                    }
                )
            }
            composable(route = TodayInHistoryScreen.Detail.name) {
                DetailScreen(
                    item = uiState.itemList.firstOrNull() ?: Item("", "", "0", 0, 0, "")
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TodayInHistoryTheme {
        TodayInHistoryApp()
    }
}