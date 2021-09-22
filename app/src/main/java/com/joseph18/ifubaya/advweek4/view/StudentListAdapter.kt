package com.joseph18.ifubaya.advweek4.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.joseph18.ifubaya.advweek4.R
import com.joseph18.ifubaya.advweek4.model.Student
import com.joseph18.ifubaya.advweek4.model.util.loadImage
import kotlinx.android.synthetic.main.student_list_item.view.*

class StudentListAdapter(val studentList :ArrayList<Student>): RecyclerView.Adapter<StudentListAdapter.StudentViewHolder>()
{
    class StudentViewHolder(val view: View): RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val _v = inflater.inflate(R.layout.student_list_item, parent, false)

        return StudentViewHolder(_v)
    }

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        holder.view.txtId.text = studentList[position].id
        holder.view.txtName.text = studentList[position].name
        holder.view.imageView.loadImage(studentList[position].photoUrl.toString(), holder.view.progressBar)

        holder.view.btnDetail.setOnClickListener() {
            val action = StudentListFragmentDirections.actionStudentListFragmentToStudentDetailFragment(studentId = holder.view.txtId.text.toString())
            Navigation.findNavController(it).navigate(action)
        }
    }

    override fun getItemCount(): Int {
        return studentList.size
    }

    fun updateStudentList(newStudentList :List<Student>) {
        studentList.clear()
        studentList.addAll(newStudentList)

        notifyDataSetChanged()
    }
}