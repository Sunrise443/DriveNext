package com.example.drivenext.data.remote.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CarDto(
    val id: Int,
    val name: String,
    val brand: String,
    val picture: String,
    @SerialName("daily_price") val dailyPrice: String,
    @SerialName("gearbox_type") val gearboxType: String,
    @SerialName("fuel_type") val fuelType: String,
)