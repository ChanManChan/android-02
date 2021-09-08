package com.u4.todoapp.data.repository

import androidx.lifecycle.LiveData
import com.u4.todoapp.data.ToDoDao
import com.u4.todoapp.data.models.ToDoData

class ToDoRepository(private val toDoDao: ToDoDao) {

    val getAllData: LiveData<List<ToDoData>> = toDoDao.getAllData()

    suspend fun insertData(toDoData: ToDoData) {
        toDoDao.insertData(toDoData)
    }
}