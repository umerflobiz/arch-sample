package com.flobiz.android.payment.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.flobiz.android.coreui.viewBinding
import com.flobiz.android.payment.R
import com.flobiz.android.payment.databinding.FragmentNewPaymentBinding

class NewPaymentFragment : Fragment(R.layout.fragment_new_payment) {

    private val binding by viewBinding(FragmentNewPaymentBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.etAmount.requestFocus()
    }
}
