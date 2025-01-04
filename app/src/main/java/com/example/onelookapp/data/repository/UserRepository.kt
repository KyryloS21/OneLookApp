package com.example.onelookapp.data.repository

import com.example.onelookapp.data.database.dao.UserDao
import com.example.onelookapp.data.database.entity.UserEntity

class UserRepository(private val userDao: UserDao) {

    suspend fun insert(user: UserEntity) {
        userDao.insert(user)
    }
    suspend fun getUserByEmailAndPassword(email: String, password: String): UserEntity? {
        return userDao.getUserByEmailAndPassword(email, password)
    }

    suspend fun getUserByUsernameAndPassword(username: String, password: String): UserEntity? {
        return userDao.getUserByUsernameAndPassword(username, password)
    }
    suspend fun deleteAllUsers(){
        return userDao.deleteAllUsers()
    }
}