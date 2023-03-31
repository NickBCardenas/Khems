package mx.itson.khems

import android.os.Bundle
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import mx.itson.khems.Adaptadores.Adaptador
import mx.itson.khems.entidades.Player

class ListPlayersActivity : AppCompatActivity() {
    private lateinit var listView: ListView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_players)
        listView = findViewById(R.id.listView)
        val lista = Player().obtenerPlayers(this)
        val adaptador = Adaptador(lista)

        listView.adapter = adaptador

    }
}