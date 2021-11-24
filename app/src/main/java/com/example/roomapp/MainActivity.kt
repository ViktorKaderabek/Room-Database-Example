package com.example.roomapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.roomapp.databinding.ActivityMainBinding

@Suppress("DEPRECATION")
class MainActivity : AppCompatActivity()
{
     
     private lateinit var binding : ActivityMainBinding
     
     override fun onCreate(savedInstanceState : Bundle?)
     {
	super.onCreate(savedInstanceState)
	binding =
	     DataBindingUtil.setContentView(this,
				      R.layout.activity_main)
	
	val intent = Intent(this,
		         AddUserActivity::class.java)
	
	binding.floatingActionButton.setOnClickListener {
	     
	     startActivityForResult(intent,1)
	     
	}
     }
}