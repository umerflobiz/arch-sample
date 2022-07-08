package com.flobiz.android.partyshared

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.flobiz.android.coreui.viewBinding
import com.flobiz.android.partyshared.databinding.FragmentPartiesBinding

class PartiesFragment : Fragment(R.layout.fragment_parties) {

    private val binding by viewBinding(FragmentPartiesBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.tvTitle.text = getString(R.string.all_parties)
    }
}