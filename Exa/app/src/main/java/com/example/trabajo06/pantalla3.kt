package com.example.trabajo06

import android.content.ContentValues
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class pantalla3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.pantalla3)

        val et1 = findViewById<EditText>(R.id.nomat)
        val et2 = findViewById<EditText>(R.id.maes)
        val et3 = findViewById<EditText>(R.id.aula)

        val boton1 = findViewById<Button>(R.id.altamat)
        val boton2 = findViewById<Button>(R.id.consumat)
        val boton3 = findViewById<Button>(R.id.consumae)
        val boton4 = findViewById<Button>(R.id.bajama)
        val boton5 = findViewById<Button>(R.id.modima)
        var btn6=findViewById<Button>(R.id.regre3)


        boton1.setOnClickListener {
            val admin = AdminSQLiteOpenHelper(this, "administracion", null, 1)
            val bd = admin.writableDatabase
            val registro = ContentValues()
            registro.put("nombremateria", et1.text.toString())
            registro.put("maestro", et2.text.toString())
            registro.put("aula", et3.text.toString())
            bd.insert("materias", null, registro)
            bd.close()
            et1.setText("")
            et2.setText("")
            et3.setText("")
            Toast.makeText(this, "Se cargaron los datos del maestro", Toast.LENGTH_SHORT).show()
        }

        boton2.setOnClickListener {
            val admin = AdminSQLiteOpenHelper(this, "administracion", null, 1)
            val bd = admin.writableDatabase
            val fila = bd.rawQuery("select maestro,aula from materias where nombremateria=${et1.text.toString()}", null)
            if (fila.moveToFirst()) {
                et2.setText(fila.getString(0))
                et3.setText(fila.getString(1))
            } else
                Toast.makeText(this, "No existe una materia con ese maestro", Toast.LENGTH_SHORT).show()
            bd.close()
        }

        boton3.setOnClickListener {
            val admin = AdminSQLiteOpenHelper(this, "administracion", null, 1)
            val bd = admin.writableDatabase
            val fila = bd.rawQuery("select nombremateria,materia from materias where maestro=${et2.text.toString()}", null)
            if (fila.moveToFirst()) {
                et2.setText(fila.getString(0))
                et3.setText(fila.getString(1))
            } else
                Toast.makeText(this, "No existe un maestro con esa materia", Toast.LENGTH_SHORT).show()
            bd.close()
        }

        boton4.setOnClickListener {
            val admin = AdminSQLiteOpenHelper(this, "administracion", null, 1)
            val bd = admin.writableDatabase
            val cant = bd.delete("materias", "nombremateria=${et1.text.toString()}", null)
            bd.close()
            et1.setText("")
            et2.setText("")
            et3.setText("")
            if (cant == 1)
                Toast.makeText(this, "Se borró la materia", Toast.LENGTH_SHORT).show()
            else
                Toast.makeText(this, "No existe esa materia", Toast.LENGTH_SHORT).show()
        }

        boton5.setOnClickListener {
            val admin = AdminSQLiteOpenHelper(this, "administracion", null, 1)
            val bd = admin.writableDatabase
            val registro = ContentValues()
            registro.put("maestro",et2.text.toString())
            registro.put("aula",et3.text.toString())
            val cant = bd.delete("alumnos", "nombremateria=${et1.text.toString()}", null)
            bd.close()
            if (cant == 1)
                Toast.makeText(this, "Se modifico una materia", Toast.LENGTH_SHORT).show()
            else
                Toast.makeText(this, "No existe esa materia", Toast.LENGTH_SHORT).show()
        }
        btn6.setOnClickListener{
            val intent = Intent(this, PantallaPrincipal::class.java)
            startActivity(intent)
        }
    }
}