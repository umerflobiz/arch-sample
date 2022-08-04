package com.flobiz.android.payment.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.hilt.navigation.fragment.hiltNavGraphViewModels
import androidx.navigation.fragment.findNavController
import com.flobiz.android.core.domain.handle
import com.flobiz.android.coreui.viewBinding
import com.flobiz.android.partyshared.databinding.FragmentPartiesBinding
import com.flobiz.android.partyshared.domain.Party
import com.flobiz.android.partyshared.ui.PartyAdapter
import com.flobiz.android.payment.R
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import dagger.hilt.android.AndroidEntryPoint
import com.flobiz.android.partyshared.R as PartyR

@AndroidEntryPoint
class SelectPartyBottomSheet : BottomSheetDialogFragment() {

    private val paymentViewModel
            by hiltNavGraphViewModels<PaymentViewModel>(R.id.new_payment_nav_graph)
    private val binding by viewBinding(FragmentPartiesBinding::bind)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = inflater.inflate(PartyR.layout.fragment_parties, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        updateSheetHeight()

        binding.tvTitle.text = getString(R.string.select_party)

        val onPartyClick = { party: Party ->
            paymentViewModel.selectedParty = party
            findNavController().navigate(
                SelectPartyBottomSheetDirections.toNewPayment()
            )
        }
        val partyAdapter = PartyAdapter(onPartyClick)
        binding.rvRecentTransactions.adapter = partyAdapter

        paymentViewModel.parties.observe(viewLifecycleOwner) { result ->
            result.handle(
                onSuccess = {
                    partyAdapter.submitList(it)
                }
            )
        }
    }

    private fun updateSheetHeight() {
        dialog?.findViewById<View>(com.google.android.material.R.id.design_bottom_sheet)
            ?.let { view ->
                view.layoutParams?.height = ViewGroup.LayoutParams.MATCH_PARENT

                val sheetBehavior = BottomSheetBehavior.from(view)
                sheetBehavior.isFitToContents = true
                sheetBehavior.state = BottomSheetBehavior.STATE_HALF_EXPANDED
            }
    }
}
