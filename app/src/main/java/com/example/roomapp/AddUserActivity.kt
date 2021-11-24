package com.example.roomapp

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.roomapp.databinding.ActivityAddUserBinding
import com.example.roomapp.model.Users
import com.example.roomapp.model.UsersViewModel

class AddUserActivity : AppCompatActivity()
{
     
     private lateinit var binding : ActivityAddUserBinding
     private lateinit var mainViewModle : UsersViewModel
     
     override fun onCreate(savedInstanceState : Bundle?)
     {
	super.onCreate(savedInstanceState)
	
	binding =
	     DataBindingUtil.setContentView(this,
				      R.layout.activity_add_user)
	
	mainViewModle = ViewModelProvider(this,
				    defaultViewModelProviderFactory).get(UsersViewModel::class.java)
	
	
	binding.imbtnBack.setOnClickListener {
	     setResult(0)
	     finish()
	}
	
	binding.btnAdd.setOnClickListener {
	     
	     val name : String = binding.edtxName.text.toString()
	     val lastName : String = binding.edtxLastname.text.toString()
	     
	     val users = Users(0,
			   name,
			   lastName)
	     
	     mainViewModle.addUser(users)
	     
	     Toast.makeText(applicationContext, "Done",
			Toast.LENGTH_LONG).show()
	     
	     setResult(1)
	     finish()
	}
	
     }
}