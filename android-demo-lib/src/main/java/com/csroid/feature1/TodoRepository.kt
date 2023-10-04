package com.csroid.feature1

class TodoRepository(private val todoAPI: TodoAPI) {

    suspend fun getTodos():TodoListItem{
        val result=todoAPI.getTodos()
        val randomTodo=result.body()!!
        return randomTodo[0]
    }
}