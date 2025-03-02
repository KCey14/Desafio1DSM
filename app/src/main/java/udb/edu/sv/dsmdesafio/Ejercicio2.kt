package udb.edu.sv.dsmdesafio

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class Ejercicio2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_ejercicio2)

        //Declarando las variables para capturar datos
        val txtName = findViewById<EditText>(R.id.txtNombreB)
        val txtSalario = findViewById<EditText>(R.id.txtSaldo)
        //Declarando variable para el botón
        val btnCalcular = findViewById<Button>(R.id.btnDescontar)
        val btnReturn2 = findViewById<Button>(R.id.btnR2)
        //Declarando variables para los textos
        val txtRetiro = findViewById<TextView>(R.id.txtAFP)
        val txtSeguro = findViewById<TextView>(R.id.txtISSS)
        val txtRent = findViewById<TextView>(R.id.txtRenta)
        val txtPagoFinal = findViewById<TextView>(R.id.txtNeto)
        val txtFinal = findViewById<TextView>(R.id.textView14)

        //Llamar en el botón la función que hara el calculo mandando
        //variables de excursion
        btnCalcular.setOnClickListener{
            calcularDescuentos(txtName, txtSalario, txtRetiro, txtSeguro, txtRent, txtPagoFinal,
                txtFinal)
        }

        //Regresar a la pagina principal
        btnReturn2.setOnClickListener{
            startActivity(Intent(this, MainActivity::class.java))
        }

    }

    //Declarando la función y llamando elementos
    private fun calcularDescuentos(txtName:EditText,txtSalario:EditText,
                                   txtRetiro:TextView,txtSeguro:TextView, txtRent:TextView,
                                   txtPagoFinal:TextView, txtFinal:TextView){
        //Convertir el nombre a String
        val nombre = txtName.text.toString()
        //Convertir el salario a double
        val salario = txtSalario.text.toString().toDoubleOrNull() ?: 0.0

        //Hacer los descuentos respectivos
        //Kotlin dirá que las variables son double por que salario ya lo es
        val aFP = salario*0.0725
        val iSSS = salario*0.03
        //Condición para aplicar la renta
        if(salario>=472.01 && salario <= 895.24){
            //El 10% más la cuota fija
            val r1 = (salario*0.1)+ 17.67
            val salarioNeto = salario - aFP - iSSS - r1
            //Asignar para mensajes
            txtRetiro.text="$$aFP"
            txtSeguro.text="$$iSSS"
            txtRent.text="$$r1"
            txtPagoFinal.text="$$salarioNeto"
            txtFinal.text="El salario para $nombre después de los descuentos es de $$salarioNeto"
        }else if(salario>=895.25 && salario <= 2038.10){
            //El 20% más la cuota fija
            val r2 = (salario*0.2)+ 60
            val salarioNeto = salario - aFP - iSSS - r2
            //Asignar para mensajes
            txtRetiro.text="$$aFP"
            txtSeguro.text="$$iSSS"
            txtRent.text="$$r2"
            txtPagoFinal.text="$$salarioNeto"
            txtFinal.text="El salario para $nombre después de los descuentos es de $$salarioNeto"
        }else if(salario>=2038.11){
            //El 30% más la cuota fija
            val r3 = (salario*0.3)+ 288.57
            val salarioNeto = salario - aFP - iSSS - r3
            //Asignar para mensajes
            txtRetiro.text="$$aFP"
            txtSeguro.text="$$iSSS"
            txtRent.text="$$r3"
            txtPagoFinal.text="$$salarioNeto"
            txtFinal.text="El salario para $nombre después de los descuentos es de $$salarioNeto"
        }else{
            //No hay renta que aplicar
            val salarioNeto = salario - aFP - iSSS
            //Asignar para mensajes
            txtRetiro.text="$$aFP"
            txtSeguro.text="$$iSSS"
            txtPagoFinal.text="$$salarioNeto"
            txtRent.text="No aplicable"

            txtFinal.text="El salario para $nombre después de los descuentos es de $$salarioNeto"
        }


    }
}