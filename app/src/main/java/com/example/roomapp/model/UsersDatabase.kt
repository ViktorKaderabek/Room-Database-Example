package com.example.roomapp.model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Users::class],
	version = 1,
	exportSchema = false)
abstract class UsersDatabase : RoomDatabase()
{
     
     abstract fun userDao() : UsersDao
     
     companion object
     {
	@Volatile
	private var INSTANCE : UsersDatabase? = null
	
	fun getDatabase(context : Context) : UsersDatabase
	{
	     val tempInstance = INSTANCE
	     if (tempInstance != null)
	     {
		return tempInstance
	     }
	     synchronized(this) {
		val instance = Room.databaseBuilder(
		     context.applicationContext,
		     UsersDatabase::class.java,
		     "user_database"
					     )
		    .build()
		INSTANCE = instance
		return instance
	     }
	}
     }
}

