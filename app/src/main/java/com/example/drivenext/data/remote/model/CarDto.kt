package com.example.drivenext.data.remote.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CarDto(
    val id: Int,
    val name: String,
    val brand: String,
    val picture: String? = null,
    @SerialName("daily_price") val dailyPrice: Int,
    @SerialName("gearbox_type") val gearboxType: String,
    @SerialName("fuel_type") val fuelType: String,
)