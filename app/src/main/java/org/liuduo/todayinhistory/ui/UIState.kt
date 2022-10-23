package org.liuduo.todayinhistory.ui

import org.liuduo.todayinhistory.data.Item

data class UIState(
    val itemList: List<Item> = listOf()
)