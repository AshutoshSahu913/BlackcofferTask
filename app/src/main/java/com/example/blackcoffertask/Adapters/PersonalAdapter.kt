package com.example.blackcoffertask.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.blackcoffertask.Model.PersonalModel
import com.example.blackcoffertask.R
import com.example.blackcoffertask.databinding.PersonalRvItemsBinding

class PersonalAdapter(var personalList: ArrayList<PersonalModel>, var context: Context) :
    RecyclerView.Adapter<PersonalAdapter.viewHolder>() {

    inner class viewHolder(var binding: PersonalRvItemsBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(position: Int) {
            var item = personalList[position]
            binding.img.setImageResource(item.image)
            binding.address.text = item.address
            binding.name.text = item.name
            binding.hobby1.text = item.hobby1
            binding.hobby2.text = item.hobby2
            binding.hobby3.text = item.hobby3
            binding.showMsg.text = item.showMessage
            updateStatusButton(item.status!!)

            binding.status.setOnClickListener {
                item.status = when (item.status!!) {
                    PersonalModel.Status.ACCEPTED -> PersonalModel.Status.PENDING
                    PersonalModel.Status.PENDING -> PersonalModel.Status.INVITED
                    PersonalModel.Status.INVITED -> PersonalModel.Status.ACCEPTED
                }
                updateStatusButton(item.status!!)
            }


        }

        private fun updateStatusButton(status: PersonalModel.Status) {
            binding.status.text = when (status) {
                PersonalModel.Status.ACCEPTED -> "Accepted"
                PersonalModel.Status.PENDING -> "Pending"
                PersonalModel.Status.INVITED -> "+Invite"
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonalAdapter.viewHolder {
        val binding = PersonalRvItemsBinding.inflate(LayoutInflater.from(context), parent, false)
        return viewHolder(binding)
    }

    override fun onBindViewHolder(holder: PersonalAdapter.viewHolder, position: Int) {
        holder.bind(position)

    }

    override fun getItemCount(): Int {
        return personalList.size
    }
}