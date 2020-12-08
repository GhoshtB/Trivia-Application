package com.example.triviaapplication.viemodel

import android.app.Application
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.triviaapplication.database.UserDatabase
import com.example.triviaapplication.model.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class UserViewmodel : ViewModel() {

    lateinit var userDatabase: UserDatabase

    val userDatas: MutableLiveData<List<User>> by lazy { MutableLiveData<List<User>>() }

    fun initializeViewModel(application: Application){
        userDatabase=UserDatabase.intializeUser(application)
    }
    fun insertUsers(user: User){
        GlobalScope.launch(context = Dispatchers.IO){
            userDatabase.userDao().insertUser(user) }
    }

    fun callDataBase() {
        viewModelScope.launch(context = Dispatchers.IO) {
            userDatabase.userDao().getUsers().let {
                viewModelScope.launch(context = Dispatchers.Main) {
                    userDatas.value=it
                }

            }
        }

    }
}