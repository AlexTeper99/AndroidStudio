package com.example.practica1.fragments

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.practica1.R
import com.example.practica1.adapters.CriptoAdapter
import com.example.practica1.entities.Cripto
import com.google.android.material.snackbar.Snackbar

class CryptoListFragment : Fragment() {

    lateinit var v: View
    private lateinit var txtTitle : TextView
    private lateinit var recivedData : String
    var criptoList: MutableList<Cripto> = mutableListOf();

    //4. inicializar el adapter
    lateinit var adapter: CriptoAdapter
    lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        v = inflater.inflate(R.layout.fragment_crypto_list, container, false)

        recivedData = CryptoListFragmentArgs.fromBundle(requireArguments()).text
        txtTitle = v.findViewById(R.id.txtTitle)

        //nombro a mi recyclerView
        recyclerView = v.findViewById(R.id.recCripto)

        txtTitle.text = "Bienvenido " + recivedData

        //codigo de la lista
        criptoList.add(Cripto("Bitcoin", "BTC", " "))
        criptoList.add(Cripto("Ethereum", "ETH", " "))
        criptoList.add(Cripto("USDT", "USDT", " "))
        criptoList.add(Cripto("Cardano", "ADA", " "))
        criptoList.add(Cripto("Bitcoin", "BTC", " "))
        criptoList.add(Cripto("Ethereum", "ETH", " "))
        criptoList.add(Cripto("USDT", "USDT", " "))
        criptoList.add(Cripto("Cardano", "ADA", " "))
        criptoList.add(Cripto("Bitcoin", "BTC", " "))
        criptoList.add(Cripto("Ethereum", "ETH", " "))
        criptoList.add(Cripto("USDT", "USDT", " "))
        criptoList.add(Cripto("Cardano", "ADA", " "))
        criptoList.add(Cripto("Bitcoin", "BTC", " "))
        criptoList.add(Cripto("Ethereum", "ETH", " "))
        criptoList.add(Cripto("USDT", "USDT", " "))
        criptoList.add(Cripto("Cardano", "ADA", " "))
        criptoList.add(Cripto("Bitcoin", "BTC", " "))
        criptoList.add(Cripto("Ethereum", "ETH", " "))
        criptoList.add(Cripto("USDT", "USDT", " "))
        criptoList.add(Cripto("Cardano", "ADA", " "))

        return v
    }

    //4. defino la config de mi onStart para el recyclerView
    override fun onStart() {
        super.onStart()

        //  recyclerView.setHasFixedSize(true)
        // creo una lista de un elemento abajo de otro
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        //EXTRA: Llamo al Adapter mandandole la funcion
        adapter = CriptoAdapter(criptoList){ pos ->
            Snackbar.make(v, criptoList[pos].ticker, Snackbar.LENGTH_SHORT).show()
        }
        recyclerView.adapter = adapter
    }

}