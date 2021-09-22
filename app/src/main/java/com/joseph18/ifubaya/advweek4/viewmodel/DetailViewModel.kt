package com.joseph18.ifubaya.advweek4.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.AndroidViewModel
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.joseph18.ifubaya.advweek4.model.Student

class DetailViewModel(application: Application): AndroidViewModel(application)
{
    val studentLD = MutableLiveData<Student>()

    private var TAG = "volleyTag"
    private var queue : RequestQueue?= null

    fun fetch(id:String) {

        queue = Volley.newRequestQueue(getApplication())
        var url = "http://adv.jitusolution.com/student.php/?id=$id"

        val stringRequest = StringRequest(
            Request.Method.GET, url,
            {
                    response ->
                val sType = object: TypeToken<Student>() {}.type
                val result = Gson().fromJson<Student>(response, sType)
                studentLD.value = result

                Log.d("showVolley", response.toString())
            },
            {
                Log.d("showVolley", it.toString())
            })

        stringRequest.tag = TAG
        queue?.add(stringRequest)
    }

    override fun onCleared() {
        super.onCleared()
        queue?.cancelAll(TAG)
    }
}