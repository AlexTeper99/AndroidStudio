package com.example.practica1.fragments

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.practica1.R

class CryptoListFragment : Fragment() {

    lateinit var v: View
    private lateinit var txtTitle : TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        v = inflater.inflate(R.layout.fragment_crypto_list, container, false)

        txtTitle = v.findViewById(R.id.txtTitle)
        return v
    }



}