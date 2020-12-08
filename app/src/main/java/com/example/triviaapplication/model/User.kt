package com.example.triviaapplication.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class User(var name:String,var player:String,var flagColor:String, var time:String) {
@PrimaryKey(autoGenerate = true)
var id:Int=0

}