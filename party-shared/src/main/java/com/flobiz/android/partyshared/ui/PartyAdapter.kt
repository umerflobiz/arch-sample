package com.flobiz.android.partyshared.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.flobiz.android.partyshared.databinding.ItemPartyBinding
import com.flobiz.android.partyshared.domain.Party

class PartyAdapter(
    private val partyClickListener: ((Party) -> Unit)? = null
) : ListAdapter<Party, PartyAdapter.PartyViewHolder>(PartyDiffUtil) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = PartyViewHolder(
        ItemPartyBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: PartyViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class PartyViewHolder(
        private val binding: ItemPartyBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        private var partyItem: Party? = null

        init {
            if (partyClickListener != null) {
                binding.root.setOnClickListener {
                    partyItem?.let(partyClickListener)
                }
            }
        }

        fun bind(party: Party) {
            partyItem = party
            if (party.name.isNotBlank()) {
                binding.tvName.text = party.name
                binding.tvLetter.text = party.name.first().uppercaseChar().toString()
            }
        }
    }

    companion object {
        val PartyDiffUtil = object : DiffUtil.ItemCallback<Party>() {
            override fun areItemsTheSame(oldItem: Party, newItem: Party) =
                oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem: Party, newItem: Party) =
                oldItem.name == newItem.name
        }
    }
}
