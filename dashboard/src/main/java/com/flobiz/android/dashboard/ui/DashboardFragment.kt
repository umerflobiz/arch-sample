package com.flobiz.android.dashboard.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.flobiz.android.core.domain.handle
import com.flobiz.android.coreui.viewBinding
import com.flobiz.android.dashboard.R
import com.flobiz.android.dashboard.databinding.FragmentDashboardBinding
import com.flobiz.android.paymentshared.ui.TransactionsAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DashboardFragment : Fragment(R.layout.fragment_dashboard) {

    private val viewModel: DashboardViewModel by viewModels()
    private val binding by viewBinding(FragmentDashboardBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val transactionsAdapter = TransactionsAdapter()
        binding.rvRecentTransactions.adapter = transactionsAdapter

        viewModel.dashboardData.observe(viewLifecycleOwner) { result ->
            result.handle(
                onSuccess = {
                    binding.tvAmount.text = getString(R.string.rupee_fs, it)
                }
            )
        }
        viewModel.recentTransactions.observe(viewLifecycleOwner) { result ->
            result.handle(
                onSuccess = {
                    transactionsAdapter.submitList(it)
                }
            )
        }
    }
}
