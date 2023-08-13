package com.example.learnteasting

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class UserViewModel(private val repository: UserRepository) : ViewModel() {
    val allUsers: LiveData<List<User>> = repository.allUsers

    fun insert(users: List<User>) = viewModelScope.launch {
        repository.insert(users)
    }
}