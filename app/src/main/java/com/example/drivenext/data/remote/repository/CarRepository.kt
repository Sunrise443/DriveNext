package com.example.drivenext.data.remote.repository

import com.example.drivenext.data.remote.model.CarDto
import com.example.drivenext.supabase
import io.github.jan.supabase.postgrest.from

class CarRepository {
    suspend fun getCars(): List<CarDto> {
        return try {
            supabase.from("cars").select().decodeList<CarDto>()
        } catch (e: Exception) {
            println("Error fetching cars: $e")
            emptyList()
        }
    }
}
