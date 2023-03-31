package mx.itson.khems.entidades

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.util.Log
import mx.itson.khems.persistencia.dbKhems

class Player {

    var id = 0
    var nombre : String? = null
    var puntaje : Int=0
    var juegos : Int=0

    constructor()

    constructor(nombre:String,puntaje:Int,juegos:Int){
        this.nombre = nombre
        this.puntaje = puntaje
        this.juegos = juegos
    }

    fun guardar(context: Context, nombre:String, puntaje: Int, juegos: Int){
        try {

            val KhemsDB = dbKhems(context,"Khems", null,1)
            var baseDatos : SQLiteDatabase = KhemsDB.writableDatabase
            val valores = ContentValues()

            valores.put("nombre",nombre)
            valores.put("puntaje",puntaje)
            valores.put("juegos",juegos)

            baseDatos.insert("players",null,valores)

        }catch (ex: Exception){

        }
    }

    fun obtenerPlayers(context: Context) : ArrayList<Player>{

        val players : MutableList<Player> = ArrayList()

        try {
            val KhemsDB = dbKhems(context,"Khems", null,1)
            var baseDatos : SQLiteDatabase = KhemsDB.readableDatabase
            val cursor = baseDatos.rawQuery("SELECT id,nombre,puntaje,juegos FROM players ORDER BY puntos ASC LIMIT 10",null)

            while (cursor.moveToNext()){
                val j = Player(cursor.getString(1),cursor.getInt(2),cursor.getInt(3))

                players.add(j)
            }

        }catch (ex : Exception){
            Log.e("No se pudo obtener a los Players", ex.toString())

        }
        return players as ArrayList<Player>
    }
}