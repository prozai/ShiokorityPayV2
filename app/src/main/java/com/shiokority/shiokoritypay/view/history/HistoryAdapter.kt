package com.shiokority.shiokoritypay.view.history

import HistoryViewHolder
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.shiokority.shiokoritypay.databinding.FragmentHistoryItemBinding
import com.shiokority.shiokoritypay.model.HistoryItem

class HistoryAdapter : RecyclerView.Adapter<HistoryViewHolder>() {
    private var items = listOf<HistoryItem>()
    private var onItemClickListener: ((HistoryItem) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoryViewHolder {
        val binding = FragmentHistoryItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return HistoryViewHolder(binding).apply {
            itemView.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    onItemClickListener?.invoke(items[position])
                }
            }
        }
    }

    override fun onBindViewHolder(holder: HistoryViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size

    fun updateItems(newItems: List<HistoryItem>) {
        items = newItems
        notifyDataSetChanged()
    }

    fun setOnItemClickListener(listener: (HistoryItem) -> Unit) {
        onItemClickListener = listener
    }
}