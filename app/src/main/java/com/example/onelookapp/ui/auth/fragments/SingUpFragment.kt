package com.example.onelookapp.ui.auth.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.onelookapp.R
import com.example.onelookapp.databinding.FragmentSingUpBinding
import com.example.onelookapp.ui.auth.AuthViewModel

class SingUpFragment : Fragment() {
    private lateinit var binding: FragmentSingUpBinding
    private val singUpViewModel: AuthViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSingUpBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setListeners()
    }

    private fun setListeners() {

        binding.tvLogin.setOnClickListener {
            findNavController().navigate(R.id.action_singUpFragment_to_loginFragment)
        }

        binding.tvSingUp.setOnClickListener {
            val username = binding.etName.text.toString()
            val email = binding.etMail.text.toString()
            val password = binding.etPassword.text.toString()

            if (username.isNotEmpty() && email.isNotEmpty() && password.isNotEmpty()) {
                singUpViewModel.registerUser(username, email, password)
            } else {
                Toast.makeText(requireContext(), "Fields cannot be empty", Toast.LENGTH_SHORT)
                    .show()
            }
        }
    }
}
