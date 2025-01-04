package com.example.onelookapp.ui.home.fragments.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.onelookapp.R
import com.example.onelookapp.databinding.ItemHealthStatsBinding
import com.example.onelookapp.ui.home.fragments.home.model.HealthStat

class HealthStatsAdapter(
    private val deleteTextById: (Int) -> Unit
) : ListAdapter<HealthStat, HealthStatsAdapter.TextViewHolder>(TextDiffCallback()) {

    class TextViewHolder(private val binding: ItemHealthStatsBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(healthStat: HealthStat) {
            with(binding) {
                ivTitle.setImageResource(healthStat.icon)
                cvMain.setCardBackgroundColor(ContextCompat.getColor(cvMain.context, healthStat.bg))
                tvValue.text = tvValue.context.getString(R.string.s_brpm, healthStat.value)
                tvTitle.text = healthStat.title
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TextViewHolder {
        val binding =
            ItemHealthStatsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TextViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TextViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}

class TextDiffCallback : DiffUtil.ItemCallback<HealthStat>() {
    override fun areItemsTheSame(oldItem: HealthStat, newItem: HealthStat): Boolean {
        return oldItem.title == newItem.title
    }

    override fun areContentsTheSame(oldItem: HealthStat, newItem: HealthStat): Boolean {
        return oldItem == newItem
    }
}