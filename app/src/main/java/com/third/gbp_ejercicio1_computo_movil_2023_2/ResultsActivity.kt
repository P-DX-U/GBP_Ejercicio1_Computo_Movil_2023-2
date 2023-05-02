package com.third.gbp_ejercicio1_computo_movil_2023_2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.third.gbp_ejercicio1_computo_movil_2023_2.databinding.ActivityResultsBinding
import java.util.Calendar

class ResultsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityResultsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_results)
        binding = ActivityResultsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bundle = intent.extras
        val alumno: Student?

        alumno = bundle?.getParcelable<Student>("alumno")

        //Log.d("nombre: ", alumno?.nombre.toString())
        //Log.d("apellido: ", alumno?.apellidos.toString())
        //Log.d("dia: ", alumno?.day.toString())
        //Log.d("mes: ", alumno?.month.toString())
        //Log.d("ano: ", alumno?.year.toString())
        //Log.d("email: ", alumno?.email.toString())
        //Log.d("num cuenta: ", alumno?.numCuenta.toString())
        //Log.d("carrera: ", alumno?.carrera.toString())
        if (alumno != null) {
            binding.tvNombre.text = alumno.nombre + " " + alumno.apellidos
            binding.email.text = alumno.email
            binding.tvNumCuenta.text = alumno.numCuenta
            binding.tvCarrera.text = alumno.carrera
            calculateAge(alumno)
            zodiacSign(alumno)
            chineseSign(alumno)
            career(alumno)
        }
    }

    private fun calculateAge(alumno: Student) {
        val c = Calendar.getInstance()
        //Calculo de la fecha actual
        val actualDays = c.get(Calendar.DAY_OF_MONTH)
        val actualMonths = c.get(Calendar.MONTH)
        val actualYears = c.get(Calendar.YEAR)

        //Log.d("Dia", actualDays.toString())
        //Log.d("Mes", actualMonths.toString())
        //Log.d("Año", actualYears.toString())

        //Obtención de la edad
        var ageDays = actualDays - alumno.day!!.toInt()
        var ageMonths = actualMonths - alumno.month!!.toInt()
        var ageYears = actualYears - alumno.year!!.toInt()

        var age = (ageYears * 365 + ageMonths * 30 + ageDays) / 365
        //Log.d("Edad: ", age.toString())
        binding.tvEdad.text = age.toString()
    }

    private fun zodiacSign(alumno: Student) {
        var signoZodiacal = ""
        if (((alumno.day!! >= 21) && (alumno.month!! == 3)) || ((alumno.day!! <= 20) && (alumno.month!! == 4))) {
            signoZodiacal = "Aries"
        } else if (((alumno.day!! >= 21) && (alumno.month!! == 4)) || ((alumno.day!! <= 21) && (alumno.month!! == 5))) {
            signoZodiacal = "Tauro"
        } else if (((alumno.day!! >= 22) && (alumno.month!! == 5)) || ((alumno.day!! <= 21) && (alumno.month!! == 6))) {
            signoZodiacal = "Géminis"
        } else if (((alumno.day!! >= 22) && (alumno.month!! == 6)) || ((alumno.day!! <= 23) && (alumno.month!! == 7))) {
            signoZodiacal = "Cáncer"
        } else if (((alumno.day!! >= 24) && (alumno.month!! == 7)) || ((alumno.day!! <= 23) && (alumno.month!! == 8))) {
            signoZodiacal = "Leo"
        } else if (((alumno.day!! >= 24) && (alumno.month!! == 8)) || ((alumno.day!! <= 23) && (alumno.month!! == 9))) {
            signoZodiacal = "Virgo"
        } else if (((alumno.day!! >= 24) && (alumno.month!! == 9)) || ((alumno.day!! <= 23) && (alumno.month!! == 10))) {
            signoZodiacal = "Libra"
        } else if (((alumno.day!! >= 24) && (alumno.month!! == 10)) || ((alumno.day!! <= 22) && (alumno.month!! == 11))) {
            signoZodiacal = "Escorpio"
        } else if (((alumno.day!! >= 23) && (alumno.month!! == 11)) || ((alumno.day!! <= 21) && (alumno.month!! == 12))) {
            signoZodiacal = "Sagitario"
        } else if (((alumno.day!! >= 22) && (alumno.month!! == 12)) || ((alumno.day!! <= 20) && (alumno.month!! == 1))) {
            signoZodiacal = "Capricornio"
        } else if (((alumno.day!! >= 21) && (alumno.month!! == 1)) || ((alumno.day!! <= 19) && (alumno.month!! == 2))) {
            signoZodiacal = "Acuario"
        } else if (((alumno.day!! >= 20) && (alumno.month!! == 2)) || ((alumno.day!! <= 20) && (alumno.month!! == 3))) {
            signoZodiacal = "Piscis"
        }
        binding.tvSignoZodiacal.text = signoZodiacal.toString()
        //Log.d("Signo ", signoZodiacal)
    }

    private fun chineseSign(alumno: Student) {
        var birthYear = alumno.year
        if (birthYear != null) {
            outer@ while (true) {
                if (birthYear == 1943) {
                    binding.tvHoroscopoChino.text = "Cabra"
                    break@outer
                } else if (birthYear == 1944) {
                    binding.tvHoroscopoChino.text = "Mono"
                    break@outer
                } else if (birthYear == 1945) {
                    binding.tvHoroscopoChino.text = "Gallo"
                    break@outer
                } else if (birthYear == 1946) {
                    binding.tvHoroscopoChino.text = "Perro"
                    break@outer
                } else if (birthYear == 1947) {
                    binding.tvHoroscopoChino.text = "Jabalí"
                    break@outer
                } else if (birthYear == 1948) {
                    binding.tvHoroscopoChino.text = "Rata"
                    break@outer
                } else if (birthYear == 1949) {
                    binding.tvHoroscopoChino.text = "Buey"
                    break@outer
                } else if (birthYear == 1950) {
                    binding.tvHoroscopoChino.text = "Tigre"
                    break@outer
                } else if (birthYear == 1951) {
                    binding.tvHoroscopoChino.text = "Conejo"
                    break@outer
                } else if (birthYear == 1952) {
                    binding.tvHoroscopoChino.text = "Dragón"
                    break@outer
                } else if (birthYear == 1953) {
                    binding.tvHoroscopoChino.text = "Serpiente"
                    break@outer
                } else if (birthYear == 1954) {
                    binding.tvHoroscopoChino.text = "Caballo"
                    break@outer
                } else {
                    birthYear -= 12
                }
            }
        }
    }

    private fun career(alumno: Student){
        val carrera = alumno.carrera?.toInt()
        val carreras = resources.getStringArray(R.array.carreras)
        when (carrera) {
            1 -> {
                binding.tvCarrera.text = carreras[1]
                binding.imageViewCarrera.setImageResource(R.drawable.aeroespacial)
            }
            2 -> {
                binding.tvCarrera.text = carreras[2]
                binding.imageViewCarrera.setImageResource(R.drawable.civil)
            }
            3 -> {
                binding.tvCarrera.text = carreras[3]
                binding.imageViewCarrera.setImageResource(R.drawable.geomatica)
            }
            4 -> {
                binding.tvCarrera.text = carreras[4]
                binding.imageViewCarrera.setImageResource(R.drawable.ambiental)
            }
            5 -> {
                binding.tvCarrera.text = carreras[5]
                binding.imageViewCarrera.setImageResource(R.drawable.geofisica)
            }
            6 -> {
                binding.tvCarrera.text = carreras[6]
                binding.imageViewCarrera.setImageResource(R.drawable.geologica)
            }
            7 -> {
                binding.tvCarrera.text = carreras[7]
                binding.imageViewCarrera.setImageResource(R.drawable.petrolera)
            }
            8 -> {
                binding.tvCarrera.text = carreras[8]
                binding.imageViewCarrera.setImageResource(R.drawable.minas)
            }
            9 -> {
                binding.tvCarrera.text = carreras[9]
                binding.imageViewCarrera.setImageResource(R.drawable.computacion)
            }
            10 -> {
                binding.tvCarrera.text = carreras[10]
                binding.imageViewCarrera.setImageResource(R.drawable.electrica)
            }
            11 -> {
                binding.tvCarrera.text = carreras[11]
                binding.imageViewCarrera.setImageResource(R.drawable.telecom)
            }
            12 -> {
                binding.tvCarrera.text = carreras[12]
                binding.imageViewCarrera.setImageResource(R.drawable.mecanica)
            }
            13 -> {
                binding.tvCarrera.text = carreras[13]
                binding.imageViewCarrera.setImageResource(R.drawable.industrial)
            }
            14 -> {
                binding.tvCarrera.text = carreras[14]
                binding.imageViewCarrera.setImageResource(R.drawable.mecanica)
            }
            15 -> {
                binding.tvCarrera.text = carreras[15]
                binding.imageViewCarrera.setImageResource(R.drawable.biomedicos)
            }
        }
    }


}
