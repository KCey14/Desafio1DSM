package udb.edu.sv.dsmdesafio

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Ejercicio3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_ejercicio3)
        //Declaración de las variables de los txt
        val num1 = findViewById<EditText>(R.id.txtNum1)
        val num2 = findViewById<EditText>(R.id.txtNum2)
        //Crear botones para las operaciones
        val btnCSuma = findViewById<Button>(R.id.btnSumar)
        val btnCRestar = findViewById<Button>(R.id.btnRestar)
        val btnCMul = findViewById<Button>(R.id.btnMultiplicar)
        val btnCDiv = findViewById<Button>(R.id.btnDividir)
        val btnReturn3 = findViewById<Button>(R.id.btnR3)
        //Para mostrar el resultado
        val txtResultados = findViewById<TextView>(R.id.txtResultado)

        
        //Llamar funciones para los botones
        btnCSuma.setOnClickListener{
            sumar(num1, num2, txtResultados)
        }
        btnCRestar.setOnClickListener{
            restar(num1, num2,txtResultados)
        }
        btnCMul.setOnClickListener{
            multiplicar(num1, num2,txtResultados)
        }
        btnCDiv.setOnClickListener{
            dividir(num1, num2,txtResultados)
        }

        //Regresar a la pagina principal
        btnReturn3.setOnClickListener{
            startActivity(Intent(this, MainActivity::class.java))
        }

    }

    private fun sumar(num1:EditText, num2:EditText, txtResultados:TextView){
        //Convertir los números a double
        val valorA = num1.text.toString().toDoubleOrNull() ?: 0.0
        val valorB = num2.text.toString().toDoubleOrNull() ?: 0.0
        val valorC = valorA + valorB
        txtResultados.text="$valorC"
    }

    private fun restar(num1:EditText, num2:EditText, txtResultados:TextView){
        //Convertir los números a double
        val valorA = num1.text.toString().toDoubleOrNull() ?: 0.0
        val valorB = num2.text.toString().toDoubleOrNull() ?: 0.0
        val valorC = valorA - valorB
        txtResultados.text="$valorC"
    }

    private fun multiplicar(num1:EditText, num2:EditText, txtResultados:TextView){
        //Convertir los números a double
        val valorA = num1.text.toString().toDoubleOrNull() ?: 0.0
        val valorB = num2.text.toString().toDoubleOrNull() ?: 0.0
        val valorC = valorA * valorB
        txtResultados.text="$valorC"
    }

    private fun dividir(num1:EditText, num2:EditText, txtResultados:TextView){
        //Convertir los números a double
        val valorA = num1.text.toString().toDoubleOrNull() ?: 0.0
        val valorB = num2.text.toString().toDoubleOrNull() ?: 0.0
        val valorC = valorA / valorB
        txtResultados.text="$valorC"
    }
}