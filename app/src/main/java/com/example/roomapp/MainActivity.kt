package com.example.roomapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.roomapp.databinding.ActivityMainBinding
import com.example.roomapp.model.ListAdapter
import com.example.roomapp.model.UsersViewModel
import com.mikepenz.fastadapter.FastAdapter
import com.mikepenz.fastadapter.adapters.ItemAdapter

@Suppress("DEPRECATION")
class MainActivity : AppCompatActivity()
{
     
     private lateinit var binding : ActivityMainBinding
     private lateinit var mainViewModle : UsersViewModel
     
     override fun onCreate(savedInstanceState : Bundle?)
     {
	super.onCreate(savedInstanceState)
	binding =
	     DataBindingUtil.setContentView(this,
				      R.layout.activity_main)
	mainViewModle = ViewModelProvider(this,
				    defaultViewModelProviderFactory).get(UsersViewModel::class.java)
	
	val adapter = ListAdapter()
	val itemAdapter =
	     ItemAdapter<ListAdapter>()
	val fastAdapter =
	     FastAdapter.with(itemAdapter)
	
	binding.recyclerview.layoutManager =
	     LinearLayoutManager(this)
	binding.recyclerview.adapter = fastAdapter // Nastavuje recyclerview co bude obsahem
	binding.recyclerview.setHasFixedSize(true)
	
	
	mainViewModle.readAllData.observe(this,
				    Observer { user -> adapter.setData(user) })
	fastAdapter.notifyDataSetChanged()
	
	val intent = Intent(this,
			AddUserActivity::class.java)
	
	binding.floatingActionButton.setOnClickListener {
	     
	     startActivityForResult(intent,
			        1)
	     
	}
     }
}