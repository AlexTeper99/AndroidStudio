package com.example.practica1.fragments

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.navigation.findNavController
import com.example.practica1.R
import com.example.practica1.entities.User
import com.google.android.material.snackbar.Snackbar

class Login : Fragment() {

    //declaro vista
    lateinit var v: View


    private var user : User = User("Alex", "a1@mail.com", "123456")

    //Es variable, la List tiene un tamanio fijo?
    private var userList : MutableList<User> = mutableListOf()

    private var name: String = ""

    private lateinit var txtLabel : TextView
    private lateinit var inputName: EditText
    private lateinit var btnSend: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        v = inflater.inflate(R.layout.fragment_login, container, false)

        //findViewById de botones
        txtLabel = v.findViewById(R.id.txtLabel)
        btnSend = v.findViewById(R.id.btnSend)
        inputName = v.findViewById(R.id.inputName)

        userList.add(user)
        userList.add(User("Alex2", "a2@mail.com", "123456"))
        userList.add(User("Alex3", "a3@mail.com", "123456"))
        return v
    }

    override fun onStart() {
        super.onStart()

        btnSend.setOnClickListener {
            if(inputName.text.isNotEmpty()){
                name = inputName.text.toString()
                var usuarioBuscado: User?

                usuarioBuscado = userList.find { actualUser -> actualUser.name == name }
                if(usuarioBuscado != null && usuarioBuscado.name.isNotEmpty()){
                    val action12 = LoginDirections.actionLoginToCryptoListFragment(usuarioBuscado.name)
                    v.findNavController().navigate(action12)
                }else{
                    txtLabel.text = "Usuario no encontrado"
                }

            }else{
                Snackbar.make(it, "Ingrese algo por favor", Snackbar.LENGTH_SHORT).show()
            }

        }
        /*
        btnSend.setOnClickListener {
            val action12 = LoginDirections.actionLoginToCryptoListFragment("Alex")
            v.findNavController().navigate(action12)
        }
        */
    }




}


