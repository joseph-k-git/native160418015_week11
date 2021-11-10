package com.joseph18.ifubaya.advweek4.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.joseph18.ifubaya.advweek4.R
import com.joseph18.ifubaya.advweek4.databinding.FragmentStudentDetailBinding
import com.joseph18.ifubaya.advweek4.model.Student
import com.joseph18.ifubaya.advweek4.model.util.loadImage
import com.joseph18.ifubaya.advweek4.viewmodel.DetailViewModel
import kotlinx.android.synthetic.main.fragment_student_detail.*

class StudentDetailFragment : Fragment() {
    private lateinit var viewModel :DetailViewModel
    private lateinit var dataBinding :FragmentStudentDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        dataBinding = DataBindingUtil.inflate<FragmentStudentDetailBinding>(inflater, R.layout.fragment_student_detail, container, false)
        dataBinding.student = Student("", "", "", "", "https://eitrawmaterials.eu/wp-content/uploads/2016/09/person-icon.png") // Avoid null error
        //return inflater.inflate(R.layout.fragment_student_detail, container, false)
        return dataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(DetailViewModel::class.java)
        viewModel.fetch(StudentDetailFragmentArgs.fromBundle(requireArguments()).studentId)

        observeViewModel()
    }

    fun observeViewModel() {
        viewModel.studentLD.observe(viewLifecycleOwner, Observer {
            dataBinding.student = it
            /*
            txtId.setText(it.id)
            txtName.setText(it.name)
            txtBod.setText(it.bod)
            txtPhone.setText(it.phone)
            imageView2.loadImage(it.photoUrl.toString(), progressBar2)

             */
        })
    }
}