package mx.itson.khems.Adaptadores

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import mx.itson.khems.R
import mx.itson.khems.entidades.Player

class Adaptador (val listaPlayer : ArrayList<Player>): BaseAdapter() {
    override fun getCount(): Int {
        return  listaPlayer.size
    }

    override fun getItem(position: Int): Any {
        return listaPlayer[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var view = convertView
        if (view == null) {
            view = LayoutInflater.from(parent?.context).inflate(R.layout.player_item, parent, false)
        }
        val nombreTextView = view?.findViewById<TextView>(R.id.txt_nombre)
        nombreTextView?.text = listaPlayer[position].nombre

        val puntosTextView = view?.findViewById<TextView>(R.id.txt_puntaje)
        puntosTextView?.text = listaPlayer[position].puntaje.toString()

        val partidasTextView = view?.findViewById<TextView>(R.id.txt_juegos)
        partidasTextView?.text = listaPlayer[position].juegos.toString()


        return view!!
    }
}