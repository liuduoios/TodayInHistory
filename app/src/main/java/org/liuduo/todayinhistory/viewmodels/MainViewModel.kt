package org.liuduo.todayinhistory.viewmodels

import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.liuduo.todayinhistory.data.API
import org.liuduo.todayinhistory.data.Item
import org.liuduo.todayinhistory.data.RetrofitHelper
import org.liuduo.todayinhistory.ui.UIState

class MainViewModel: ViewModel() {
    val appId = "rgihdrm0kslojqvm"
    val appSecret = "WnhrK251TWlUUThqaVFWbG5OeGQwdz09"

    private val _uiState = MutableStateFlow(UIState())
    val uiState: StateFlow<UIState> = _uiState.asStateFlow()

    init {
        viewModelScope.launch {
            val api = RetrofitHelper.getInstance().create(API::class.java)
            val results = api.getItems(0, appId, appSecret)
            _uiState.update { currentState ->
                currentState.copy(
                    itemList = results.body()?.data ?: listOf()
                )
            }
            Log.d("MainViewModel: ", results.body().toString())
        }
    }
}