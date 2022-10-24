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
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import org.liuduo.todayinhistory.data.Item
import org.liuduo.todayinhistory.ui.DetailScreen
import org.liuduo.todayinhistory.ui.ItemList
import org.liuduo.todayinhistory.ui.ListScreen
import org.liuduo.todayinhistory.ui.components.navigateWithArguments
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

    var currentScreen: TodayInHistoryScreen
    val route = backStackEntry?.destination?.route
    if (route == null || route!!.contains("list")) {
        currentScreen = TodayInHistoryScreen.valueOf(TodayInHistoryScreen.List.name)
    } else {
        currentScreen = TodayInHistoryScreen.valueOf(TodayInHistoryScreen.Detail.name)
    }
//    val currentScreen = TodayInHistoryScreen.valueOf(
//        backStackEntry?.destination?.route ?: TodayInHistoryScreen.List.name
//    )

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
            startDestination = "list",
            modifier = modifier.padding(innerPadding)
        ) {
            composable(route = "list") {
                ListScreen(
                    uiState = uiState,
                    onItemClicked = { item ->
                        navController.navigate(
                            route = "detail/${item.title}/${item.details}"
                        )
                    }
                )
            }
            composable(route = "detail/{title}/{details}") { backStackEntry ->
                DetailScreen(
                    title = backStackEntry.arguments?.getString("title") ?: "",
                    details = backStackEntry.arguments?.getString("details") ?: ""
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