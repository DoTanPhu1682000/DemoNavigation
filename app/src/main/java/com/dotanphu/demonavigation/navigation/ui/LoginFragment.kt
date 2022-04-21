package com.dotanphu.demonavigation.navigation.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.dotanphu.demonavigation.R
import com.dotanphu.demonavigation.databinding.FragmentLoginBinding

class LoginFragment : Fragment(R.layout.fragment_login) {
    private lateinit var binding: FragmentLoginBinding
    private val args by navArgs<LoginFragmentArgs>()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        args.user?.let {
            binding.edtUsername.setText(it)
        }

        binding.btnConfirm.setOnClickListener {
            val action = LoginFragmentDirections.actionLoginFragmentToWelcomeFragment(
                binding.edtUsername.text.toString(),
                binding.edtPassword.text.toString()

            )
            findNavController().navigate(action)
        }
        return binding.root
    }
}