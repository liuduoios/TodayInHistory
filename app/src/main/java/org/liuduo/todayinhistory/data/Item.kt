package org.liuduo.todayinhistory.data

data class Item(
    val picUrl: String,
    val title: String,
    val year: String,
    val month: Int,
    val day: Int,
    val details: String
)
