package com.example.onelookapp.ui.auth

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.onelookapp.data.database.entity.UserEntity
import com.example.onelookapp.data.repository.UserRepository
import kotlinx.coroutines.launch

class AuthViewModel(
    private val userRepository: UserRepository
) : ViewModel() {

    fun registerUser(username: String, email: String, password: String) {
        val user = UserEntity(username = username, email = email, password = password)
        viewModelScope.launch {
            userRepository.insert(user)
        }
    }

    fun getUserByEmailAndPassword(
        email: String,
        password: String,
        callback: (UserEntity?) -> Unit
    ) {
        viewModelScope.launch {
            val user = userRepository.getUserByEmailAndPassword(email, password)
            callback(user)
        }
    }

    fun getUserByUsernameAndPassword(
        username: String,
        password: String,
        callback: (UserEntity?) -> Unit
    ) {
        viewModelScope.launch {
            val user = userRepository.getUserByUsernameAndPassword(username, password)
            callback(user)
        }
    }
}