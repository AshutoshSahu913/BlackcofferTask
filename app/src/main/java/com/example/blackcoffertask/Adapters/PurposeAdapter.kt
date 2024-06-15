package com.example.blackcoffertask.Adapters

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.blackcoffertask.Model.PurposeModel
import com.example.blackcoffertask.R
import com.example.blackcoffertask.databinding.PurposeListItemsBinding

class PurposeAdapter(var purposeList: ArrayList<PurposeModel>, var context: Context) :
    RecyclerView.Adapter<PurposeAdapter.viewHolder>() {
    private var selectedPositions: MutableList<Int> = mutableListOf()

    inner class viewHolder(var binding: PurposeListItemsBinding) :
        RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("ResourceAsColor")
        fun bind(position: Int) {
            val item = purposeList[position]
            binding.purpose.text = item.name


            // Update the UI based on the selected state
            if (selectedPositions.contains(position)) {
                binding.purpose.setTextColor(ContextCompat.getColor(context, R.color.white))
                binding.purpose.setBackgroundResource(R.drawable.circle2)
            } else {
                binding.purpose.setTextColor(ContextCompat.getColor(context, R.color.appColor))
                binding.purpose.setBackgroundResource(R.drawable.search_back) // Use your default background
            }

            binding.purpose.setOnClickListener {
                toggleSelection(position)
            }

        }

    }

    private fun toggleSelection(position: Int) {
        if (selectedPositions.contains(position)) {
            selectedPositions.remove(position)
        } else {
            selectedPositions.add(position)
        }
        notifyItemChanged(position)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PurposeAdapter.viewHolder {
        val binding = PurposeListItemsBinding.inflate(LayoutInflater.from(context), parent, false)
        return viewHolder(binding)
    }

    override fun onBindViewHolder(holder: PurposeAdapter.viewHolder, position: Int) {
        holder.bind(position)

    }

    override fun getItemCount(): Int {
        return purposeList.size
    }
}