package com.example.trabajo06

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.TextView


class examen : AppCompatActivity(){

    private val historial = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.examen)

        val num1=findViewById<EditText>(R.id.nu1)
        val num2=findViewById<EditText>(R.id.nu2)
        val num3=findViewById<EditText>(R.id.nu3)
        val r1=findViewById<RadioButton>(R.id.sum)
        val r2=findViewById<RadioButton>(R.id.res)
        val r3=findViewById<RadioButton>(R.id.div)
        val r4=findViewById<RadioButton>(R.id.mult)
        val tv=findViewById<TextView>(R.id.resul)
        val button3=findViewById<Button>(R.id.button)
        val historialTextView = findViewById<TextView>(R.id.his)



        button3.setOnClickListener {
            var resultado = ""
            if (r1.isChecked) {
                resultado = "Resultado: ${num1.text.toString().toInt() + num2.text.toString().toInt() + num3.text.toString().toInt()}"
            }
            if (r2.isChecked) {
                resultado = "Resultado: ${num1.text.toString().toInt() - num2.text.toString().toInt() - num3.text.toString().toInt()}"
            }
            if (r3.isChecked) {
                resultado = "Resultado: ${num1.text.toString().toInt() / num2.text.toString().toInt()}"
            }
            if (r4.isChecked) {
                resultado = "Resultado: ${num1.text.toString().toInt() * num2.text.toString().toInt() * num3.text.toString().toInt()}"
            }

            historial.add(resultado)
            tv.text = resultado
            historialTextView.text = historial.joinToString("\n")
            num1.text.clear()
            num2.text.clear()
            num3.text.clear()

        }
    }
}