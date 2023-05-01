package com.third.gbp_ejercicio1_computo_movil_2023_2

import android.R
import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.util.Patterns
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.third.gbp_ejercicio1_computo_movil_2023_2.databinding.ActivityMainBinding
import com.third.gbp_ejercicio1_computo_movil_2023_2.R as localR

class MainActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {

    private lateinit var binding: ActivityMainBinding
    private lateinit var aaCarreras: ArrayAdapter<String>
    var vday: Int = 0
    var vmonth: Int = 0
    var vyear: Int = 0
    var carrera: String = ""
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
        carrera = position.toString()
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {
    }

    private fun isValidEmail(mail: CharSequence) =
        (!TextUtils.isEmpty(mail) && Patterns.EMAIL_ADDRESS.matcher(mail).matches())

    private fun textFieldsValidation(): Boolean {
        if (binding.editTextNombre?.text.toString().isBlank()) {
            Toast.makeText(
                this,
                "Por favor escribe tu nombre.",
                Toast.LENGTH_LONG
            ).show()
            return false
        } else if (binding.editTextApellido?.text.toString().isBlank()) {
            Toast.makeText(
                this,
                "Por favor escribe tus apellidos.",
                Toast.LENGTH_LONG
            ).show()
            return false
        } else if (binding.editTextDate?.text.toString().isBlank()) {
            Toast.makeText(
                this,
                "Por favor selecciona tu fecha de nacimiento.",
                Toast.LENGTH_LONG
            ).show()
            return false
        } else if (binding.editTextTextEmailAddress?.text.toString().isBlank()) {
            Toast.makeText(
                this,
                "Por favor escribe tu correo electrónico.",
                Toast.LENGTH_LONG
            ).show()
            return false
        } else if (isValidEmail(binding.editTextTextEmailAddress.text.toString()) == false) {
            Toast.makeText(
                this,
                "El E-Mail proporcionado no tiene forma de dirección de correo electrónico.",
                Toast.LENGTH_LONG
            ).show()
            return false
        } else if (binding.editTextCuenta?.text.toString().isBlank()) {
            Toast.makeText(
                this,
                "Por favor escribe tu número de cuenta.",
                Toast.LENGTH_LONG
            ).show()
            return false
        } else if (binding.editTextCuenta.text.toString().length < 9) {
            Toast.makeText(
                this,
                "Por favor escribe tu número de cuenta de 9 dígitos.",
                Toast.LENGTH_LONG
            ).show()
            return false
        } else if (carrera.toString() == "0") {
            Toast.makeText(
                this,
                "Por favor selecciona una carrera.",
                Toast.LENGTH_LONG
            ).show()
            return false
        } else {
            return true
        }
    }

    fun resultClick(view: View) {
        val intent = Intent(this, ResultsActivity::class.java)
        Log.d("textFieldValidation", textFieldsValidation().toString())
        if(textFieldsValidation() == true){
            val alumno = Student(
                binding.editTextNombre.text.toString(),
                binding.editTextApellido.text.toString(),
                vday,
                vmonth,
                vyear,
                binding.editTextTextEmailAddress.text.toString(),
                binding.editTextCuenta.text.toString(),
                carrera
            )
            val bundle = Bundle()
            bundle.putParcelable("alumno", alumno)
            intent.putExtras(bundle)
            startActivity(intent)
        }
    }
}