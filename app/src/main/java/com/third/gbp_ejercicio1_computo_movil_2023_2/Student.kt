package com.third.gbp_ejercicio1_computo_movil_2023_2

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
class Student(
    var nombre: String?, var apellidos: String?, var day: Int?, var month: Int?,
    var year: Int?, var email: String?, var numCuenta: String?, var carrera: String?
) : Parcelable


