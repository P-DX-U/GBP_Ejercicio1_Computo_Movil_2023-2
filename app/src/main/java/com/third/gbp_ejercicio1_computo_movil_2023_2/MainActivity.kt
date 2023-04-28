package com.third.gbp_ejercicio1_computo_movil_2023_2

import android.R
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import com.third.gbp_ejercicio1_computo_movil_2023_2.databinding.ActivityMainBinding
import com.third.gbp_ejercicio1_computo_movil_2023_2.R as localR
import java.util.*
import kotlin.properties.Delegates


class MainActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {

    private lateinit var binding: ActivityMainBinding
    private lateinit var aaCarreras: ArrayAdapter<String>
    var vday: Int = 0
    var vmonth: Int = 0
    var vyear: Int = 0
    var carrera: String = " "
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val arrayCarreras: Array<String> = resources.getStringArray(localR.array.carreras)
        aaCarreras = ArrayAdapter<String>(
            this,
            R.layout.simple_spinner_dropdown_item
        )
        binding.spCarrerasFi.adapter = aaCarreras
        aaCarreras.addAll(arrayCarreras.toList())
        binding.spCarrerasFi.onItemSelectedListener = this
    }

    fun dateClick(view: View) {
        val datePicker = DatePickerFragment { day, month, year -> onDateSelected(day, month, year) }
        datePicker.show(supportFragmentManager, "datePicker")
    }

    fun onDateSelected(day: Int, month: Int, year: Int) {
        var month = month + 1
        binding.editTextDate.setText("Fecha de nacimiento: $day/$month/$year")

        vday = day
        vmonth = month
        vyear = year
    }

    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, position: Int, p3: Long) {
        carrera = aaCarreras.getItem(position).toString()
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {
        TODO("Not yet implemented")
    }

    fun resultClick(view: View) {
        val intent = Intent(this, ResultsActivity::class.java)

        val bundle = Bundle()
        bundle.putString(
            "Nombre",
            binding.editTextNombre?.text.toString() + " " + binding.editTextApellido?.text.toString()
        )
        bundle.putInt("year", vyear)
        bundle.putInt("month", vmonth)
        bundle.putInt("day", vday)
        bundle.putString("Email", binding.editTextTextEmailAddress?.text.toString())
        bundle.putString("NumCuenta", binding.editTextCuenta?.text.toString())
        bundle.putString("Carrera", carrera)

        intent.putExtras(bundle)

        startActivity(intent)
    }


}