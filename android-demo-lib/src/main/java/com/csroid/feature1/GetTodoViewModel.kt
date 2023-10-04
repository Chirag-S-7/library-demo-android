package com.csroid.feature1

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class GetTodoViewModel(private val todoRepository: TodoRepository):ViewModel() {

    private val _todo=MutableLiveData<TodoListItem>()
    val todo:LiveData<TodoListItem>
        get() = _todo

    fun getTodos(){
        viewModelScope.launch(Dispatchers.IO) {
            val result=todoRepository.getTodos()
            _todo.postValue(result)
        }
    }
}