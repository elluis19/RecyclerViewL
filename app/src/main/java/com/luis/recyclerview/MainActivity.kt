package com.luis.recyclerview

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.widget.GridLayout
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var persona: ArrayList<Persona> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        persona.add(Persona("luis", "https://la100.cienradios.com/wp-content/uploads/sites/content/2015/11/soltero1.jpg", "Masculino"))
        persona.add(Persona("luis1", "https://liderweb.mx/wp-content/uploads/2017/07/01Persona-distraida.jpg", "Masculino"))
        persona.add(Persona("luis2", "https://image.freepik.com/foto-gratis/joven-hispano-cool-hombre-persona-apuntando-mano-camisa-blanco-orgulloso-confiado_1187-68952.jpg", "Masculino"))

        recyclerPersonas.layoutManager = GridLayoutManager(this, 1)!!//spantCoun numero de columnas
        recyclerPersonas.setHasFixedSize(true)
        recyclerPersonas.adapter = PersonasAdapter(persona, this)
    }
}
