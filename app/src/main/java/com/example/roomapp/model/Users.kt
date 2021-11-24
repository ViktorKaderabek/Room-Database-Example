package com.example.roomapp.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users_table")
data class Users(
    @PrimaryKey(autoGenerate = true) var id : Int,
    val name : String,
    val lastName : String,
	      )
