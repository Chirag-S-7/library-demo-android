package com.csroid.feature1

import androidx.lifecycle.LiveData
import retrofit2.Response
import retrofit2.http.GET

interface TodoAPI {

    @GET("todos")
    suspend fun getTodos() : Response<TodoList>
}