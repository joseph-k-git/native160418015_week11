package com.joseph18.ifubaya.advweek4.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.joseph18.ifubaya.advweek4.model.Student

class DetailViewModel: ViewModel()
{
    val studentLD = MutableLiveData<Student>()

    fun fetch() {
        val student = Student("004", "Dedi", "2000/01/04", "08123456789", "http")
        studentLD.value = student
    }
}