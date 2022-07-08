package com.flobiz.android.auth.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.flobiz.android.auth.R
import com.flobiz.android.auth.databinding.FragmentLoginBinding
import com.flobiz.android.coreui.viewBinding

class LoginFragment : Fragment(R.layout.fragment_login) {

    private val binding by viewBinding(FragmentLoginBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnLogin.setOnClickListener {
            // TODO: Implement onClick
        }
    }
}
