package com.csroid.feature1

import kotlin.random.Random

class TodoRepository(private val todoAPI: TodoAPI) {

    suspend fun getTodos():TodoListItem{
        val result=todoAPI.getTodos()
        val randomTodo=result.body()!!
        val randomInt = Random.nextInt(21)
        return randomTodo[randomInt]
    }
}