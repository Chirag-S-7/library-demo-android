package com.csroid.feature1

data class TodoListItem(
    val completed: Boolean,
    val id: Int,
    val title: String,
    val userId: Int
)