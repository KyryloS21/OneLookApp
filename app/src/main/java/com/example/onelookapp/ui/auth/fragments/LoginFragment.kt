package com.example.onelookapp.ui.auth.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.onelookapp.R
import com.example.onelookapp.databinding.FragmentLoginBinding
import com.example.onelookapp.ui.auth.AuthViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel



class LoginFragment : Fragment() {
    private lateinit var binding: FragmentLoginBinding
    private val viewModel: AuthViewModel by viewModel()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setListeners()
    }

    private fun setListeners() {

        binding.tvSingUp.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_singUpFragment)
        }

        binding.tvLogIn.setOnClickListener {
            val email = binding.etMail.text.toString().trim()
            val password = binding.etPassword.text.toString().trim()

            if (email.isNotEmpty() && password.isNotEmpty()) {
                viewModel.getUserByEmailAndPassword(email, password) { userByEmail ->
                    if (userByEmail != null) {
                        Toast.makeText(requireContext(), "Login successful!", Toast.LENGTH_SHORT).show()
                        findNavController().navigate(R.id.action_loginFragment_to_homeActivity)
                    } else {
                        viewModel.getUserByUsernameAndPassword(email, password) { userByUsername ->
                            if (userByUsername != null) {
                                Toast.makeText(requireContext(), "Login successful!", Toast.LENGTH_SHORT).show()
                                findNavController().navigate(R.id.action_loginFragment_to_homeActivity)
                            } else {
                                Toast.makeText(
                                    requireContext(),
                                    "Invalid email/username or password",
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                        }
                    }
                }
            } else {
                Toast.makeText(
                    requireContext(),
                    "Please enter both email/username and password",
                    Toast.LENGTH_SHORT
                ).show()
            }

        }
    }
}