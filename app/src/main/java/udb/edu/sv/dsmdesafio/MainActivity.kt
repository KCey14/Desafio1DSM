package udb.edu.sv.dsmdesafio

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        //creando los botones en kotlin
        val btnEjercicio1 = findViewById<Button>(R.id.btnEjercicio1)
        val btnEjercicio2 = findViewById<Button>(R.id.btnEjercicio2)
        val btnEjercicio3 = findViewById<Button>(R.id.btnEjercicio3)

        //Crear los eventos listener para ir a ellos cuando se de click a un boton
        btnEjercicio1.setOnClickListener{
            startActivity(Intent(this, Ejercicio1::class.java))
        }
        btnEjercicio2.setOnClickListener{
            startActivity(Intent(this, Ejercicio2::class.java))
        }
        btnEjercicio3.setOnClickListener{
            startActivity(Intent(this, Ejercicio3::class.java))
        }
    }
}