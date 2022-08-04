package com.flobiz.android.partyshared.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.flobiz.android.core.domain.handle
import com.flobiz.android.coreui.viewBinding
import com.flobiz.android.partyshared.R
import com.flobiz.android.partyshared.databinding.FragmentPartiesBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PartiesFragment : Fragment(R.layout.fragment_parties) {

    private val binding by viewBinding(FragmentPartiesBinding::bind)
    private val viewModel by viewModels<PartiesViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.tvTitle.text = getString(R.string.all_parties)

        val partyAdapter = PartyAdapter()
        binding.rvRecentTransactions.adapter = partyAdapter

        viewModel.parties.observe(viewLifecycleOwner) { result ->
            result.handle(
                onSuccess = {
                    partyAdapter.submitList(it)
                }
            )
        }
    }
}