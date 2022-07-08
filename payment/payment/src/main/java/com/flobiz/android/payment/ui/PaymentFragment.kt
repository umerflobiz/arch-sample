package com.flobiz.android.payment.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.flobiz.android.coreui.viewBinding
import com.flobiz.android.payment.R
import com.flobiz.android.payment.databinding.FragmentPaymentBinding

class PaymentFragment : Fragment(R.layout.fragment_payment) {

    private val binding by viewBinding(FragmentPaymentBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.fabPay.setOnClickListener {
            findNavController().navigate(R.id.to_new_payment_flow)
        }
    }
}
