package com.example.roomapp.model

import androidx.lifecycle.LiveData

class UsersRepository(private val userDao: UsersDao) {
     
     val readAllData: LiveData<List<Users>> = userDao.getAll()
     
     suspend fun addUser(user: Users){
	userDao.insertAll(user)
     }
     
}