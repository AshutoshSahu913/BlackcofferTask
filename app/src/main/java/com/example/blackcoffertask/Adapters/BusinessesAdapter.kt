package com.example.blackcoffertask.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.blackcoffertask.Model.PersonalModel
import com.example.blackcoffertask.databinding.BusinessesRvItemsBinding
import com.example.blackcoffertask.databinding.ServicesRvItemsBinding

class BusinessesAdapter(var businessList: ArrayList<PersonalModel>, var context: Context) :
    RecyclerView.Adapter<BusinessesAdapter.viewHolder>() {

    inner class viewHolder(var binding: BusinessesRvItemsBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(position: Int) {
            val item = businessList[position]
            binding.img.setImageResource(item.image)
            binding.address.text = item.address
            binding.name.text = item.name
            binding.showMsg.text = item.showMessage

            binding.profession.text = item.profession
            binding.profileScore.text = item.score.toString()
        }

    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BusinessesAdapter.viewHolder {
        val binding = BusinessesRvItemsBinding.inflate(LayoutInflater.from(context), parent, false)
        return viewHolder(binding)
    }

    override fun onBindViewHolder(holder: BusinessesAdapter.viewHolder, position: Int) {
        holder.bind(position)

    }

    override fun getItemCount(): Int {
        return businessList.size
    }
}