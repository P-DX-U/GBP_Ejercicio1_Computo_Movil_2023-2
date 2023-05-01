package com.third.gbp_ejercicio1_computo_movil_2023_2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import java.util.Date
import java.util.Calendar

class ResultsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_results)

        val bundle = intent.extras
        val alumno: Student?

        alumno = bundle?.getParcelable<Student>("alumno")

        Log.d("nombre: ", alumno?.nombre.toString())
        Log.d("apellido: ", alumno?.apellidos.toString())
        Log.d("dia: ", alumno?.day.toString())
        Log.d("mes: ", alumno?.month.toString())
        Log.d("ano: ", alumno?.year.toString())
        Log.d("email: ", alumno?.email.toString())
        Log.d("num cuenta: ", alumno?.numCuenta.toString())
        Log.d("carrera: ", alumno?.carrera.toString())
        if (alumno != null) {
            calculateAge(alumno)
        }
    }

    private fun calculateAge(alumno: Student) {
        val c = Calendar.getInstance()
        //Calculo de la fecha actual
        val actualDays = c.get(Calendar.DAY_OF_MONTH)
        val actualMonths = c.get(Calendar.MONTH)
        val actualYears = c.get(Calendar.YEAR)

        Log.d("Dia", actualDays.toString())
        Log.d("Mes", actualMonths.toString())
        Log.d("Ano", actualYears.toString())

        //Obtención de la edad
        var ageDays = actualDays - alumno.day!!.toInt()
        var ageMonths = actualMonths - alumno.month!!.toInt()
        var ageYears = actualYears - alumno.year!!.toInt()

        var age = (ageYears*365 + ageMonths*30 + ageDays)/365
        Log.d("Edad: ", age.toString())
    }

    private fun zodiacSign(){


    }


}