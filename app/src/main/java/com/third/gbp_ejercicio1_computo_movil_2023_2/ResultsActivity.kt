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

        if (alumno != null) {
            binding.tvNombre.text =
                resources.getString(R.string.nombre) + alumno.nombre + " " + alumno.apellidos
            binding.email.text = resources.getString(R.string.email) + alumno.email
            binding.tvNumCuenta.text = resources.getString(R.string.numCuenta) + alumno.numCuenta
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

        //Obtención de la edad
        var ageDays = actualDays - alumno.day!!.toInt()
        var ageMonths = actualMonths - alumno.month!!.toInt()
        var ageYears = actualYears - alumno.year!!.toInt()

        var age = (ageYears * 365 + ageMonths * 30 + ageDays) / 365
        binding.tvEdad.text =
            resources.getString(R.string.edad) + age.toString() + resources.getString(R.string.anyos)
    }

    private fun zodiacSign(alumno: Student) {
        val signos = resources.getStringArray(R.array.signosZodiacales)
        var signoZodiacal = ""
        if (((alumno.day!! >= 21) && (alumno.month!! == 3)) || ((alumno.day!! <= 20) && (alumno.month!! == 4))) {
            signoZodiacal = signos[0].toString()
        } else if (((alumno.day!! >= 21) && (alumno.month!! == 4)) || ((alumno.day!! <= 21) && (alumno.month!! == 5))) {
            signoZodiacal = signos[1].toString()
        } else if (((alumno.day!! >= 22) && (alumno.month!! == 5)) || ((alumno.day!! <= 21) && (alumno.month!! == 6))) {
            signoZodiacal = signos[2].toString()
        } else if (((alumno.day!! >= 22) && (alumno.month!! == 6)) || ((alumno.day!! <= 23) && (alumno.month!! == 7))) {
            signoZodiacal = signos[3].toString()
        } else if (((alumno.day!! >= 24) && (alumno.month!! == 7)) || ((alumno.day!! <= 23) && (alumno.month!! == 8))) {
            signoZodiacal = signos[4].toString()
        } else if (((alumno.day!! >= 24) && (alumno.month!! == 8)) || ((alumno.day!! <= 23) && (alumno.month!! == 9))) {
            signoZodiacal = signos[5].toString()
        } else if (((alumno.day!! >= 24) && (alumno.month!! == 9)) || ((alumno.day!! <= 23) && (alumno.month!! == 10))) {
            signoZodiacal = signos[6].toString()
        } else if (((alumno.day!! >= 24) && (alumno.month!! == 10)) || ((alumno.day!! <= 22) && (alumno.month!! == 11))) {
            signoZodiacal = signos[7].toString()
        } else if (((alumno.day!! >= 23) && (alumno.month!! == 11)) || ((alumno.day!! <= 21) && (alumno.month!! == 12))) {
            signoZodiacal = signos[8].toString()
        } else if (((alumno.day!! >= 22) && (alumno.month!! == 12)) || ((alumno.day!! <= 20) && (alumno.month!! == 1))) {
            signoZodiacal = signos[9].toString()
        } else if (((alumno.day!! >= 21) && (alumno.month!! == 1)) || ((alumno.day!! <= 19) && (alumno.month!! == 2))) {
            signoZodiacal = signos[10].toString()
        } else if (((alumno.day!! >= 20) && (alumno.month!! == 2)) || ((alumno.day!! <= 20) && (alumno.month!! == 3))) {
            signoZodiacal = signos[11].toString()
        }
        binding.tvSignoZodiacal.text =
            resources.getString(R.string.signoZod) + signoZodiacal.toString()
    }

    private fun chineseSign(alumno: Student) {
        val hChino = resources.getStringArray(R.array.horoscpChino)
        var birthYear = alumno.year
        if (birthYear != null) {
            outer@ while (true) {
                if (birthYear == 1943) {
                    binding.tvHoroscopoChino.text =
                        resources.getString(R.string.horChino) + hChino[0].toString()
                    break@outer
                } else if (birthYear == 1944) {
                    binding.tvHoroscopoChino.text =
                        resources.getString(R.string.horChino) + hChino[1].toString()
                    break@outer
                } else if (birthYear == 1945) {
                    binding.tvHoroscopoChino.text =
                        resources.getString(R.string.horChino) + hChino[2].toString()
                    break@outer
                } else if (birthYear == 1946) {
                    binding.tvHoroscopoChino.text =
                        resources.getString(R.string.horChino) + hChino[3].toString()
                    break@outer
                } else if (birthYear == 1947) {
                    binding.tvHoroscopoChino.text =
                        resources.getString(R.string.horChino) + hChino[4].toString()
                    break@outer
                } else if (birthYear == 1948) {
                    binding.tvHoroscopoChino.text =
                        resources.getString(R.string.horChino) + hChino[5].toString()
                    break@outer
                } else if (birthYear == 1949) {
                    binding.tvHoroscopoChino.text =
                        resources.getString(R.string.horChino) + hChino[6].toString()
                    break@outer
                } else if (birthYear == 1950) {
                    binding.tvHoroscopoChino.text =
                        resources.getString(R.string.horChino) + hChino[7].toString()
                    break@outer
                } else if (birthYear == 1951) {
                    binding.tvHoroscopoChino.text =
                        resources.getString(R.string.horChino) + hChino[8].toString()
                    break@outer
                } else if (birthYear == 1952) {
                    binding.tvHoroscopoChino.text =
                        resources.getString(R.string.horChino) + hChino[9].toString()
                    break@outer
                } else if (birthYear == 1953) {
                    binding.tvHoroscopoChino.text =
                        resources.getString(R.string.horChino) + hChino[10].toString()
                    break@outer
                } else if (birthYear == 1954) {
                    binding.tvHoroscopoChino.text =
                        resources.getString(R.string.horChino) + hChino[11].toString()
                    break@outer
                } else {
                    birthYear -= 12
                }
            }
        }
    }

    private fun career(alumno: Student) {
        val carrera = alumno.carrera?.toInt()
        val carreras = resources.getStringArray(R.array.carreras)
        when (carrera) {
            1 -> {
                binding.tvCarrera.text = carreras[1].toString()
                binding.imageViewCarrera.setImageResource(R.drawable.aeroespacial)
            }
            2 -> {
                binding.tvCarrera.text = carreras[2].toString()
                binding.imageViewCarrera.setImageResource(R.drawable.civil)
            }
            3 -> {
                binding.tvCarrera.text = carreras[3].toString()
                binding.imageViewCarrera.setImageResource(R.drawable.geomatica)
            }
            4 -> {
                binding.tvCarrera.text = carreras[4].toString()
                binding.imageViewCarrera.setImageResource(R.drawable.ambiental)
            }
            5 -> {
                binding.tvCarrera.text = carreras[5].toString()
                binding.imageViewCarrera.setImageResource(R.drawable.geofisica)
            }
            6 -> {
                binding.tvCarrera.text = carreras[6].toString()
                binding.imageViewCarrera.setImageResource(R.drawable.geologica)
            }
            7 -> {
                binding.tvCarrera.text = carreras[7].toString()
                binding.imageViewCarrera.setImageResource(R.drawable.petrolera)
            }
            8 -> {
                binding.tvCarrera.text = carreras[8].toString()
                binding.imageViewCarrera.setImageResource(R.drawable.minas)
            }
            9 -> {
                binding.tvCarrera.text = carreras[9].toString()
                binding.imageViewCarrera.setImageResource(R.drawable.computacion)
            }
            10 -> {
                binding.tvCarrera.text = carreras[10].toString()
                binding.imageViewCarrera.setImageResource(R.drawable.electrica)
            }
            11 -> {
                binding.tvCarrera.text = carreras[11].toString()
                binding.imageViewCarrera.setImageResource(R.drawable.telecom)
            }
            12 -> {
                binding.tvCarrera.text = carreras[12].toString()
                binding.imageViewCarrera.setImageResource(R.drawable.mecanica)
            }
            13 -> {
                binding.tvCarrera.text = carreras[13].toString()
                binding.imageViewCarrera.setImageResource(R.drawable.industrial)
            }
            14 -> {
                binding.tvCarrera.text = carreras[14].toString()
                binding.imageViewCarrera.setImageResource(R.drawable.mecanica)
            }
            15 -> {
                binding.tvCarrera.text = carreras[15].toString()
                binding.imageViewCarrera.setImageResource(R.drawable.biomedicos)
            }
        }
    }
}
