package com.example.practica1.entities

import android.util.Log

class User( //constructor in-line
    var name: String,
    var email: String,
    var pass: String)
{

    fun showName(){
        Log.d("Test", this.name)
    }
}