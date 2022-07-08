package com.flobiz.android.payment.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.navGraphViewModels
import com.flobiz.android.coreui.viewBinding
import com.flobiz.android.partyshared.databinding.FragmentPartiesBinding
import com.flobiz.android.payment.R
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.flobiz.android.partyshared.R as PartyR

class SelectPartyBottomSheet : BottomSheetDialogFragment() {

    private val paymentViewModel by navGraphViewModels<PaymentViewModel>(R.id.new_payment_nav_graph)
    private val binding by viewBinding(FragmentPartiesBinding::bind)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = inflater.inflate(PartyR.layout.fragment_parties, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.tvTitle.text = getString(R.string.select_party)
    }
}
