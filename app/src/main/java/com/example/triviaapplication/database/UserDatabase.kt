package com.example.triviaapplication.database

import android.app.Application
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.triviaapplication.model.User

@Database(entities = [User::class],version = 1)
abstract class UserDatabase:RoomDatabase() {

    companion object{
        var INSTANCE:UserDatabase? =null

        fun intializeUser(application: Application):UserDatabase{
            if (INSTANCE==null){
                INSTANCE= Room.databaseBuilder(application.applicationContext,
                    UserDatabase::class.java,"user.db").build()
            }
            return INSTANCE!!
        }

    }
    abstract fun userDao():UserDao

}