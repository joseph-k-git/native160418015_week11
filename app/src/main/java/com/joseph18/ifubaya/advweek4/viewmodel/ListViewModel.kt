package com.joseph18.ifubaya.advweek4.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.joseph18.ifubaya.advweek4.model.Student

class ListViewModel: ViewModel()
{
    val studentsLD = MutableLiveData<List<Student>>()
    val loadingErrorLD = MutableLiveData<Boolean>()
    val loadingDoneLD = MutableLiveData<Boolean>()

    fun refresh() {
        val student1 = Student("001", "Ani", "2000/01/01", "123456789", "http")
        val student2 = Student("002", "Budi", "2000/01/02", "123456789", "http")
        val student3 = Student("003", "Cici", "2000/01/03", "123456789", "http")
        val studentList = arrayListOf<Student>(student1, student2, student3)

        studentsLD.value = studentList
        loadingErrorLD.value = false;
        loadingDoneLD.value = true;
    }
}