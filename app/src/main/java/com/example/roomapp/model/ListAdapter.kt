package com.example.roomapp.model

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.roomapp.R
import com.example.roomapp.databinding.ListUsersBinding
import com.mikepenz.fastadapter.binding.AbstractBindingItem


class ListAdapter(val users : Users? = null) : AbstractBindingItem<ListUsersBinding>()
{
     
     private var usersList = emptyList<Users>()
     
          override val type : Int
	get() = R.id.home_item
     
     override fun bindView(
         binding : ListUsersBinding,
         payloads : List<Any>,
		      )
     { //prirazuje view s DataClassou
          
          binding.txtLastname.text = users?.lastName
	binding.txtName.text = users?.name
     
     }
     
     override fun createBinding(
	//Vytvari recyclerview
         inflater : LayoutInflater,
         parent : ViewGroup?,
			 ) : ListUsersBinding
     {
	return ListUsersBinding.inflate(inflater,
				    parent,
				    false)
     }
     
     fun setData(user: List<Users>){
     
          this.usersList = user
	
     }
     
}