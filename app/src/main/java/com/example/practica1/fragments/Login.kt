package com.example.practica1.fragments

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.findNavController
import com.example.practica1.R

class Login : Fragment() {

    //declaro vista
    lateinit var v: View

    //declaro elemntos del xml
    private lateinit var txtLabel : TextView
    private lateinit var btnSend : Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        v = inflater.inflate(R.layout.fragment_login, container, false)

        //findViewById de botones
        txtLabel = v.findViewById(R.id.txtLabel)
        btnSend = v.findViewById(R.id.btnSend)

        return v
    }

    override fun onStart() {
        super.onStart()
        btnSend.setOnClickListener {
            val action12 = LoginDirections.actionLoginToCryptoListFragment("Alex")
            v.findNavController().navigate(action12)
        }
    }




}


