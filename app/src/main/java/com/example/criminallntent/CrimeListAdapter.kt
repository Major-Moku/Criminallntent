package com.example.criminallntent

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.criminallntent.databinding.ListItemCrimeBinding

class CrimeHolder(private val binding: ListItemCrimeBinding) : RecyclerView.ViewHolder(binding.root){
    fun bind(crime: Crime){
        binding.crimeTitle.text = crime.title
        binding.crimeDate.text = crime.date.toString()

        binding.root.setOnClickListener{
            Toast.makeText(
                binding.root.context,
                "${crime.title} clicked",
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}

class CrimeListAdapter(private val crimes: List<Crime>) : RecyclerView.Adapter<CrimeHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CrimeHolder { // 负责承载每个子项的布局。
        val inflater = LayoutInflater.from(parent.context)
        val binding = ListItemCrimeBinding.inflate(inflater, parent,false)
        return CrimeHolder(binding)
    }

    override fun onBindViewHolder(holder: CrimeHolder, position: Int) { // 负责将每个子项holder绑定数据。
        val crime = crimes[position]
//        holder.apply {
//            binding.crimeTitle.text = crime.title
//            binding.crimeDate.text = crime.date.toString()
//        }
        holder.bind(crime)
    }

    override fun getItemCount() = crimes.size
}
