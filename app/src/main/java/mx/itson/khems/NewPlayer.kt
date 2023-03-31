package mx.itson.khems

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import mx.itson.khems.entidades.Player

class NewPlayer : AppCompatActivity(), View.OnClickListener {
    lateinit var nombre : EditText
    var juegos : Int = 0
    var puntaje : Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_player)
        val btnAgregar = findViewById<Button>(R.id.guardar)
        btnAgregar.setOnClickListener(this)
        nombre = findViewById(R.id.nombre_ganador)
        juegos = intent.getIntExtra("juegos",0)
        puntaje = intent.getIntExtra("puntaje",0)
    }

    override fun onClick(v: View?) {
        if(v?.id==R.id.guardar){
            Player().guardar(applicationContext,nombre.text.toString(),puntaje,juegos)
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }

}