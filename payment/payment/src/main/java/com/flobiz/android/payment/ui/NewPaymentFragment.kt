package com.flobiz.android.payment.ui

import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.hilt.navigation.fragment.hiltNavGraphViewModels
import com.flobiz.android.core.domain.getAppMessage
import com.flobiz.android.core.domain.handle
import com.flobiz.android.core.shortSnackBar
import com.flobiz.android.coreui.viewBinding
import com.flobiz.android.payment.R
import com.flobiz.android.payment.databinding.FragmentNewPaymentBinding

class NewPaymentFragment : Fragment(R.layout.fragment_new_payment) {

    private val paymentViewModel
            by hiltNavGraphViewModels<PaymentViewModel>(R.id.new_payment_nav_graph)
    private val binding by viewBinding(FragmentNewPaymentBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.etAmount.requestFocus()
        binding.btnPay.setOnClickListener {
            paymentViewModel.pay(binding.etAmount.text.toString())
        }

        paymentViewModel.selectedParty?.let { party ->
            binding.recipient.text = getString(R.string.recipient_name, party.name)
            binding.acNumber.text = getString(R.string.ac_number, party.acNumber)
        }

        paymentViewModel.paymentResult.observe(viewLifecycleOwner) { result ->
            result.handle(
                onLoading = {
                    binding.btnPay.isLoading = it
                    binding.etAmount.isEnabled = it.not()
                },
                onSuccess = {
                    binding.layoutAmount.isVisible = false
                    binding.imgSuccess.isVisible = true
                },
                onError = {
                    requireView().shortSnackBar(it.getAppMessage(requireContext()))
                }
            )
        }
    }
}
