package com.example.drivenext.presentation.screens.signUp.third

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class SignUpThirdViewModel : ViewModel() {
    var driversLicenseNumber = mutableStateOf("")

    var driversLicenseNumberError = mutableStateOf<String?>(null)

    val isThirdFormValid: Boolean
        get() = driversLicenseNumberError.value == null &&
                driversLicenseNumber.value.isNotBlank()

    fun onDriversLicenseNumberChange(newDriversLicenseNumber: String) {
        driversLicenseNumber.value = newDriversLicenseNumber
        driversLicenseNumberError.value = validateDriversLicenseNumber(newDriversLicenseNumber)
    }

    fun validateDriversLicenseNumber(value: String): String? {
        val driversLicenseNumberRegex = Regex("^\\d{10}$")
        return if (!driversLicenseNumberRegex.matches(value)) "Введите корректный номер водительского удостоверения." else null
    }
}