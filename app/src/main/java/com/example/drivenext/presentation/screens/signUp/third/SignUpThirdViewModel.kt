package com.example.drivenext.presentation.screens.signUp.third

import android.net.Uri
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.drivenext.presentation.screens.signUp.SharedSignUpViewModel
import kotlinx.coroutines.launch
import java.util.Calendar
import java.util.Date

class SignUpThirdViewModel : ViewModel() {
    var driversLicenseNumber = mutableStateOf("")
    var selectedDateMillis = mutableStateOf<Long?>(null)
    var selectedProfileImageUri = mutableStateOf<Uri?>(null)
    var selectedPassportImageUri = mutableStateOf<Uri?>(null)
    var selectedDriverLicenseImageUri = mutableStateOf<Uri?>(null)

    var driversLicenseNumberError = mutableStateOf<String?>(null)
    var selectedDateError = mutableStateOf<String?>(null)

    val isThirdFormValid: Boolean
        get() = driversLicenseNumberError.value == null &&
                selectedDateError.value == null &&
                selectedDateMillis.value != null &&
                selectedDriverLicenseImageUri.value != null &&
                selectedProfileImageUri.value != null &&
                selectedPassportImageUri.value != null &&
                driversLicenseNumber.value.isNotBlank()

    fun onDriversLicenseNumberChange(newDriversLicenseNumber: String) {
        driversLicenseNumber.value = newDriversLicenseNumber
        driversLicenseNumberError.value = validateDriversLicenseNumber(newDriversLicenseNumber)
    }
    fun onDateChanged(newDateValue: Long?) {
        selectedDateMillis.value = newDateValue
        selectedDateError.value = validateDate(newDateValue)
    }
    fun onDriverLicenseImageSelected(uri: Uri?) {
        selectedDriverLicenseImageUri.value = uri
    }
    fun onProfileImageSelected(uri: Uri?) {
        selectedProfileImageUri.value = uri
    }
    fun onPassportImageSelected(uri: Uri?) {
        selectedPassportImageUri.value = uri
    }

    fun validateDriversLicenseNumber(value: String): String? {
        val driversLicenseNumberRegex = Regex("^\\d{10}$")
        return if (!driversLicenseNumberRegex.matches(value)) "Введите корректный номер водительского удостоверения." else null
    }
    fun validateDate(value: Long?): String? {
        if (value == null) return "Введите дату выдачи."
        val selectedDate = Date(value)
        val today = Calendar.getInstance().apply {
            set(Calendar.HOUR_OF_DAY, 0)
            set(Calendar.MINUTE, 0)
            set(Calendar.SECOND, 0)
            set(Calendar.MILLISECOND, 0)
        }.time

        return if (selectedDate >= today) {
            "Введите корректную дату выдачи."
        } else {
            null
        }
    }

    fun onThirdContinueClick(
        onSuccess: () -> Unit,
        sharedSignUpViewModel: SharedSignUpViewModel,

    ) {
        viewModelScope.launch {
            if (isThirdFormValid) {
                sharedSignUpViewModel.saveLicenseInfo(
                    number = driversLicenseNumber.value,
                    issueDate = selectedDateMillis.value
                )
                sharedSignUpViewModel.submitUser()
                println("FINISHED")
                onSuccess()
            }
        }
    }
}