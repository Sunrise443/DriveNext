package com.example.drivenext.data.remote.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class UserDto(
    val email: String,
    val password: String,
    val name: String,
    val surname: String,
    val patronymic: String?,
    val sex: String,
    @SerialName("date_of_birth") val dateOfBirth: String,
    @SerialName("profile_picture") val profilePicture: String,
    @SerialName("drivers_license_number") val driversLicenseNumber: String,
    @SerialName("date_of_issue") val dateOfIssue: String,
    @SerialName("drivers_license_photo") val driversLicensePhoto: String,
    @SerialName("passport_photo") val passportPhoto: String,
)