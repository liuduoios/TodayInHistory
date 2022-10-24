package org.liuduo.todayinhistory.ui.components

import androidx.core.os.bundleOf
import androidx.navigation.NavController
import androidx.navigation.NavOptions
import androidx.navigation.Navigator

fun NavController.navigateWithArguments(
    route: String,
    args: List<Pair<String, Any>>? = null,
    navOptions: NavOptions? = null,
    navigatorExtras: Navigator.Extras? = null,
    ) {
    navigate(route = route, navOptions = navOptions, navigatorExtras = navigatorExtras)

    if (args == null && args?.isEmpty() == true) {
        return
    }

    val bundle = backQueue.lastOrNull()?.arguments
    if (bundle != null) {
//        val pair = args?.first()
        val bundle = bundleOf(*args?.toTypedArray()!!)
        bundle.putAll(bundle)
    } else {
        println("The last argument of NavBackStackEntry is NULL")
    }
}