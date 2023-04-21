package com.third.gbp_ejercicio1_computo_movil_2023_2

import android.app.DatePickerDialog
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.widget.DatePicker
import androidx.fragment.app.DialogFragment
import java.util.*

class DatePickerFragment(val listener: (day:Int, month:Int, year:Int) -> Unit): DialogFragment(),
    DatePickerDialog.OnDateSetListener {
    override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
        listener(dayOfMonth, month, year)
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val c = Calendar.getInstance()
        val day:Int = c.get(Calendar.DAY_OF_MONTH)
        val month:Int = c.get(Calendar.MONTH)
        val year:Int = c.get(Calendar.YEAR)

        val picker = DatePickerDialog(activity as Context, this, day, month, day)
        c.add(Calendar.YEAR, - 18)
        c.add(Calendar.MONTH, - month)
        c.add(Calendar.DAY_OF_MONTH, - day + 1)
        picker.datePicker.maxDate = c.timeInMillis
        c.add(Calendar.YEAR, - 62)
        picker.datePicker.minDate = c.timeInMillis
        return picker
    }
}