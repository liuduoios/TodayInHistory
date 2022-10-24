package org.liuduo.todayinhistory.data

import android.os.Parcelable

data class Item(
    val picUrl: String,
    val title: String,
    val year: String,
    val month: Int,
    val day: Int,
    val details: String
)
