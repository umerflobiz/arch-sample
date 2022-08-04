package com.flobiz.android.paymentshared.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.flobiz.android.paymentshared.databinding.ItemRecentTransactionBinding
import com.flobiz.android.paymentshared.domain.Transaction

class TransactionsAdapter :
    ListAdapter<Transaction, TransactionsAdapter.PartyViewHolder>(PartyDiffUtil) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = PartyViewHolder(
        ItemRecentTransactionBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: PartyViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class PartyViewHolder(
        private val binding: ItemRecentTransactionBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(transaction: Transaction) {
            binding.tvName.text = transaction.partyName
            binding.tvLetter.text = transaction.partyName.first().uppercaseChar().toString()
            binding.tvDate.text = transaction.date
        }
    }

    companion object {
        val PartyDiffUtil = object : DiffUtil.ItemCallback<Transaction>() {
            override fun areItemsTheSame(oldItem: Transaction, newItem: Transaction) =
                oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem: Transaction, newItem: Transaction) =
                oldItem.id == newItem.id
        }
    }
}
