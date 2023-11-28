package com.example.trabajo06

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.ContentValues
import android.content.Intent
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class Pantalla2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.pantalla2)
        val et1 = findViewById<EditText>(R.id.rfcm)
        val et2 = findViewById<EditText>(R.id.nomma)
        val et3 = findViewById<EditText>(R.id.matma)

        val boton1 = findViewById<Button>(R.id.altam)
        val boton2 = findViewById<Button>(R.id.conrfc)
        val boton3 = findViewById<Button>(R.id.consum)
        val boton4 = findViewById<Button>(R.id.bajam)
        val boton5 = findViewById<Button>(R.id.modifim)
        var btn6=findViewById<Button>(R.id.regre2)


        boton1.setOnClickListener {
            val admin = AdminSQLiteOpenHelper(this, "administracion", null, 1)
            val bd = admin.writableDatabase
            val registro = ContentValues()
            registro.put("rfc", et1.text.toString())
            registro.put("nombre", et2.text.toString())
            registro.put("materia", et3.text.toString())
            bd.insert("maestros", null, registro)
            bd.close()
            et1.setText("")
            et2.setText("")
            et3.setText("")
            Toast.makeText(this, "Se cargaron los datos del maestro", Toast.LENGTH_SHORT).show()
        }

        boton2.setOnClickListener {
            val admin = AdminSQLiteOpenHelper(this, "administracion", null, 1)
            val bd = admin.writableDatabase
            val fila = bd.rawQuery("select nombre,materia from maestros where rfc=${et1.text.toString()}", null)
            if (fila.moveToFirst()) {
                et2.setText(fila.getString(0))
                et3.setText(fila.getString(1))
            } else
                Toast.makeText(this, "No existe un alumno con dicho número de control", Toast.LENGTH_SHORT).show()
            bd.close()
        }

        boton3.setOnClickListener {
            val admin = AdminSQLiteOpenHelper(this, "administracion", null, 1)
            val bd = admin.writableDatabase
            val fila = bd.rawQuery("select rfc,materia from maestros where nombre=${et2.text.toString()}", null)
            if (fila.moveToFirst()) {
                et2.setText(fila.getString(0))
                et3.setText(fila.getString(1))
            } else
                Toast.makeText(this, "No existe un alumno con dicho número de control", Toast.LENGTH_SHORT).show()
            bd.close()
        }

        boton4.setOnClickListener {
            val admin = AdminSQLiteOpenHelper(this, "administracion", null, 1)
            val bd = admin.writableDatabase
            val cant = bd.delete("maestros", "rfc=${et1.text.toString()}", null)
            bd.close()
            et1.setText("")
            et2.setText("")
            et3.setText("")
            if (cant == 1)
                Toast.makeText(this, "Se borró el maestro con es RFC", Toast.LENGTH_SHORT).show()
            else
                Toast.makeText(this, "No existe un maestro con ese RFC", Toast.LENGTH_SHORT).show()
        }

        boton5.setOnClickListener {
            val admin = AdminSQLiteOpenHelper(this, "administracion", null, 1)
            val bd = admin.writableDatabase
            val registro = ContentValues()
            registro.put("nombre",et2.text.toString())
            registro.put("materia",et3.text.toString())
            val cant = bd.delete("alumnos", "rfc=${et1.text.toString()}", null)
            bd.close()
            if (cant == 1)
                Toast.makeText(this, "Se modifico el maestro con ese RFC", Toast.LENGTH_SHORT).show()
            else
                Toast.makeText(this, "No existe un alumno con ese RFC", Toast.LENGTH_SHORT).show()
        }
        btn6.setOnClickListener{
            val intent = Intent(this, PantallaPrincipal::class.java)
            startActivity(intent)
        }
    }
}