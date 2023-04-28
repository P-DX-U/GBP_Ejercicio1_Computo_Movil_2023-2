package com.third.gbp_ejercicio1_computo_movil_2023_2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast

class ResultsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_results)

        val bundle = intent.extras

        if (bundle != null) {
            val nombre = bundle.getString("Nombre")
            val year = bundle.getInt("year")
            val month = bundle.getInt("month")
            val day = bundle.getInt("day")
            val email = bundle.getString("Email")
            val numCuenta = bundle.getString("NumCuenta")
            val carrera = bundle.getString("Carrera")
            Log.d("Nombre> ", nombre.toString())
            Log.d("Year> ", year.toString())
            Log.d("Month> ", month.toString())
            Log.d("Day> ", day.toString())
            Log.d("Email> ", email.toString())
            Log.d("Num Cuenta> ", numCuenta.toString())
            Log.d("Carrera> ", carrera.toString())

        }
    }
}