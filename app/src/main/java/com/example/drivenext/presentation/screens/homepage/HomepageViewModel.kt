package com.example.drivenext.presentation.screens.homepage

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.drivenext.data.remote.model.CarDto
import com.example.drivenext.data.remote.repository.CarRepository
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {

    private val repository = CarRepository()
    val cars = mutableStateListOf<CarDto>()
    val isLoading = mutableStateOf(false)

    init {
        loadCars()
    }

    fun loadCars() {
        viewModelScope.launch {
            isLoading.value = true
            val result = repository.getCars()
            cars.clear()
            cars.addAll(result)
            isLoading.value = false
        }
    }
}
