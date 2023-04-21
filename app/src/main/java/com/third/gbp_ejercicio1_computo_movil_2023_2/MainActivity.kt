package com.third.gbp_ejercicio1_computo_movil_2023_2

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.third.gbp_ejercicio1_computo_movil_2023_2.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }

    fun dateClick(view: View){
        val datePicker = DatePickerFragment { day, month, year -> onDateSelected(day, month, year) }
        datePicker.show(supportFragmentManager, "datePicker")
    }
    fun onDateSelected(day:Int, month:Int, year:Int){
        var month = month + 1
        binding.editTextDate.setText("Fecha de nacimiento: $day/$month/$year")
    }


}