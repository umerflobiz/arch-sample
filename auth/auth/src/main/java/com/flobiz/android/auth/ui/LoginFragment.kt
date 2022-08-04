package com.flobiz.android.auth.ui

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.navOptions
import com.example.android.navigation.Dashboard
import com.flobiz.android.auth.R
import com.flobiz.android.auth.databinding.FragmentLoginBinding
import com.flobiz.android.core.domain.TextResource
import com.flobiz.android.core.domain.getAppMessage
import com.flobiz.android.core.domain.getString
import com.flobiz.android.core.domain.handle
import com.flobiz.android.core.shortSnackBar
import com.flobiz.android.coreui.viewBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginFragment : Fragment(R.layout.fragment_login) {

    private val binding by viewBinding(FragmentLoginBinding::bind)
    private val viewModel by viewModels<LoginViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // TODO: Validation check
        val idTr = TextResource.ofId(R.string.you_have_n_credits, 5.toString())
        binding.btnLogin.setOnClickListener {
            Toast.makeText(requireContext(), idTr.getString(requireContext()), Toast.LENGTH_SHORT).show()
            return@setOnClickListener
            val phoneNumber = binding.etUsername.text.toString()
            val password = binding.etUsername.text.toString()
            viewModel.login(phoneNumber, password)
        }

        // TODO: Loading
        // TODO: Navigate
        viewModel.loginResult.observe(viewLifecycleOwner) {
            it.handle(
                onError = { error ->
                    requireView().shortSnackBar(error.getAppMessage(requireContext()))
                }
            ) {
                findNavController().navigate(
                    Dashboard.uri,
                    navOptions {
                        popUpTo(R.id.loginFragment) { inclusive = true }
                    }
                )
            }
        }
    }
}
