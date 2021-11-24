package com.example.roomapp.model

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface UsersDao {
     
     @Query("SELECT * FROM users_table")
     fun getAll(): LiveData<List<Users>>
     
     @Insert
     fun insertAll(user : Users)
     
}