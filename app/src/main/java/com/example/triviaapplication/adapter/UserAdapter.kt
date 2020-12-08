package com.example.triviaapplication.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.triviaapplication.BR
import com.example.triviaapplication.R
import com.example.triviaapplication.databinding.UserRowBinding
import com.example.triviaapplication.model.User

class UserAdapter() : RecyclerView.Adapter<UserAdapter.UserViewHolder>() {
    lateinit var binding: UserRowBinding
     var users: List<User> = arrayListOf()

    inner class UserViewHolder(binding: UserRowBinding) : RecyclerView.ViewHolder(binding.root) {
        fun binds(user: User) {
            binding.users = user
            binding.setVariable(BR.users, user)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        binding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.user_row,
            parent,
            false
        )

        return UserViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return users.size
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.binds(users[position])
    }

    fun setList(users: List<User>) {
        this.users = users
        notifyDataSetChanged()
    }
}