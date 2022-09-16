package com.example.practica1.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.practica1.R
import com.example.practica1.entities.Cripto

class CriptoAdapter(
    var criptoList: MutableList<Cripto>,
    var onClick : (Int) -> Unit //EXTRA: recibo una funcion para el onClick de la tarjeta
    ): RecyclerView.Adapter<CriptoAdapter.CriptoHolder>() {

    //La funcion del holder es ser la parte del adapter que se comunica con el xml de item. La view que recibe es la instancia del item.
    //va a ejecutar funciones que se ejecuten cuando renderice los items.
    class CriptoHolder (v: View) : RecyclerView.ViewHolder(v){

        //creo una vista
        private var view: View
        init {
            this.view = v
        }

        //esta funcion va a buscar el textView del item y lo setea con el valor que le pasaron por param
        fun setTicker (ticker : String){
            var txtTicker : TextView = view.findViewById(R.id.txtTicker)

            txtTicker.text = ticker
        }




        //EXTRA: Defino el metodo getCard que devuelve el card al onBind
        fun getCard() :CardView{
            return view.findViewById(R.id.card)
        }

        fun setImage(imageUrl : String){
            var imageCripto  : ImageView = view.findViewById(R.id.imageCripto)
            Glide
                .with(view)
                .load(imageUrl)
                .into(imageCripto)
        }
    }

    //este metodo va a buscar el item.xml de la lista y se lo pasa al holder.
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CriptoHolder {
        val view =  LayoutInflater.from(parent.context).inflate(R.layout.item_cripto,parent,false)
        return (CriptoHolder(view))
    }

    //voy a recorrer toda la lista (como un for de los elementos en pantalla) y
    override fun onBindViewHolder(holder: CriptoHolder, position: Int) {
        holder.setTicker(criptoList[position].ticker)

        //EXTRA: defino la accion de que pasa cuando clickeo la card
        holder.getCard().setOnClickListener {
            onClick(position)
        }

        holder.setImage(criptoList[position].urlImage)
    }

    //devuelve el tamanio de la lista.
    override fun getItemCount(): Int {
        return criptoList.size
    }
}