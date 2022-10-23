package org.liuduo.todayinhistory.data

data class Result(
    val code: Int,
    val msg: String,
    val data: List<Item>
)
