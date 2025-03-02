package udb.edu.sv.dsmdesafio

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class Ejercicio1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_ejercicio1)
         //Declaración para los campos, txt y botones
        val nota1 = findViewById<EditText>(R.id.txtNota1)
        val nota2 = findViewById<EditText>(R.id.txtNota2)
        val nota3 = findViewById<EditText>(R.id.txtNota3)
        val nota4 = findViewById<EditText>(R.id.txtNota4)
        val nota5 = findViewById<EditText>(R.id.txtNota5)
        val btnCalcularPromedio = findViewById<Button>(R.id.btnCalcular)
        val btnReturn1 = findViewById<Button>(R.id.btnR1)
        val txtResultado = findViewById<TextView>(R.id.txtMensaje)
        val txtMostrar = findViewById<TextView>(R.id.txtPromedio)

        //Llamando la función para calcular el promedio
        btnCalcularPromedio.setOnClickListener{
            calcularPromedio(nota1,nota2,nota3,nota4,nota5,txtMostrar, txtResultado)
        }

        //Regresar a la pagina principal
        btnReturn1.setOnClickListener{
            startActivity(Intent(this, MainActivity::class.java))
        }
    }

    private fun calcularPromedio(nota1:EditText, nota2:EditText,nota3:EditText, nota4:EditText,
                                 nota5:EditText, txtResultado:TextView, txtMostrar:TextView){
        //Convertir de string a double las notas
        //Primero hace la convergencia de texto a string, luego a double
        val valor1 = nota1.text.toString().toDoubleOrNull() ?: 0.0
        val valor2 = nota2.text.toString().toDoubleOrNull() ?: 0.0
        val valor3 = nota3.text.toString().toDoubleOrNull() ?: 0.0
        val valor4 = nota4.text.toString().toDoubleOrNull() ?: 0.0
        val valor5 = nota5.text.toString().toDoubleOrNull() ?: 0.0

        //Calculando el promedio
        val promedio = (valor1 * 0.15) + (valor2 * 0.15) + (valor3 * 0.2) + (valor4 * 0.25) +
                (valor5 * 0.25)
        if(promedio <= 6){
            //Mostrar el promedio obtenido
            txtMostrar.text = "$promedio"
            txtResultado.text = "Reprobado"
        }else{
            //Mostrar el promedio obtenido
            txtMostrar.text = "$promedio"
            txtResultado.text = "Aprobado"
        }

    }
}