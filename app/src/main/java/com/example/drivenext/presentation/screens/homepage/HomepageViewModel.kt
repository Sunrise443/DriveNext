package com.example.drivenext.presentation.screens.homepage

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.drivenext.data.remote.model.CarDto
import com.example.drivenext.data.remote.repository.CarRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {

    private val repository = CarRepository()
    val cars = mutableStateListOf<CarDto>()
    val isLoading = mutableStateOf(false)
    val searchQuery = mutableStateOf("")
    val searchedCars = mutableStateListOf<CarDto>()

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

    fun onSearchClick(loadResultScreen: () -> Unit, onDataLoading: () -> Unit) {
        onDataLoading()

        CoroutineScope(Dispatchers.Main).launch {
            delay(3000L)
            val filtered = cars.filter {
                it.name.contains(searchQuery.value, ignoreCase = true)
            }
            searchedCars.clear()
            searchedCars.addAll(filtered)

            loadResultScreen()
        }
    }
}
