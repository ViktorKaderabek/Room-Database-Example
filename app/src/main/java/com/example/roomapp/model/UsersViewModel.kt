package com.example.roomapp.model

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UsersViewModel(application: Application): AndroidViewModel(application) {
     
     private val readAllData: LiveData<List<Users>>
     private val repository: UsersRepository
     
     init {
	val userDao = UsersDatabase.getDatabase(application).userDao()
	repository = UsersRepository(userDao)
	readAllData = repository.readAllData
     }
     
     fun addUser(user: Users){
	viewModelScope.launch(Dispatchers.IO) {
	     repository.addUser(user)
	}
     }
     
}