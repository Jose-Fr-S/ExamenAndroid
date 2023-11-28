package com.example.trabajo06

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.content.Intent


class PantallaPrincipal : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.pantalla_principal)
        var btn1=findViewById<Button>(R.id.botalu)
        var btn2=findViewById<Button>(R.id.botma)
        var btn3=findViewById<Button>(R.id.botmat)

        btn1.setOnClickListener{
            val intent = Intent(this, Pantalla1::class.java)
            startActivity(intent)
        }

        btn2.setOnClickListener{
            val act2 = Intent(this, Pantalla2::class.java)
            startActivity(act2)
        }

        btn3.setOnClickListener{
            val act2 = Intent(this, pantalla3::class.java)
            startActivity(act2)
        }
    }
}