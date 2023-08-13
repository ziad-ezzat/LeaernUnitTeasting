package com.example.learnteasting

import androidx.lifecycle.LiveData

class UserRepository(private val userDao: UserDao) {
    val allUsers: LiveData<List<User>> = userDao.getUsers()

    fun insert(users: List<User>) {
        userDao.insertUsers(users)
    }
}