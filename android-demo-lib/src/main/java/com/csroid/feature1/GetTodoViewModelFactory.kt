package com.csroid.feature1

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class GetTodoViewModelFactory(private val todoRepository: TodoRepository): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T
    {
        return GetTodoViewModel(todoRepository) as T
    }
}