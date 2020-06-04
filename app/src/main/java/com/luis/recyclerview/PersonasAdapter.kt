package com.luis.recyclerview

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.single_person.view.*

class PersonasAdapter(personas:ArrayList<Persona>, contexto:Context):
        RecyclerView.Adapter<PersonasAdapter.ViewHolder>() {
    var elementos:ArrayList<Persona>?= null
    var contexto: Context?= null

    init {
        this.elementos= personas
        this.contexto= contexto
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        //val vistaPersona:View = LayoutInflater.from(contexto).inflate(R.layout.elemento)
        //val personaViewHolder = ViewHolder(vistaPersona)
        val view = LayoutInflater.from(parent.context).inflate(R.layout.single_person, parent, false)
        val viewHolder = ViewHolder(view)
        view.tag = viewHolder
        return viewHolder
    }

    override fun getItemCount(): Int {
        return this.elementos!!.count()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.nombre!!.text = elementos!![position].nombre
        holder.genero!!.text = elementos!![position].genero
        Picasso.get().load(elementos!![position].foto)
                .placeholder(R.drawable.ic_launcher_foreground)
                .error(R.drawable.ic_launcher_background)
                .into(holder.imagen)
    }

    class ViewHolder(vista: View):RecyclerView.ViewHolder(vista){
        var imagen:ImageView? = null
        var nombre:TextView? = null
        var genero:TextView? = null

        init {
            imagen = vista.ivPersona
            nombre = vista.tvNombre
            genero = vista.tvGenero
        }
    }
}