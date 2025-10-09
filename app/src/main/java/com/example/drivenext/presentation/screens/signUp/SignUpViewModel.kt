package com.example.drivenext.presentation.screens.signUp

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import java.util.Calendar
import java.util.Date

class SignUpViewModel : ViewModel() {
    // 1st form
    var email = mutableStateOf("")
    var password = mutableStateOf("")
    var repeatPassword = mutableStateOf("")
    var termsAndConditionsChecked = mutableStateOf(false)

    var emailError = mutableStateOf<String?>(null)
    var passwordError = mutableStateOf<String?>(null)
    var repeatPasswordError = mutableStateOf<String?>(null)
    var termsAndConditionsCheckedError = mutableStateOf<String?>(null)

    val isFirstFormValid: Boolean
        get() = emailError.value == null &&
                passwordError.value == null &&
                repeatPasswordError.value == null &&
                email.value.isNotBlank() &&
                password.value.isNotBlank() &&
                repeatPassword.value.isNotBlank() &&
                termsAndConditionsChecked.value

    fun onEmailChanged(newEmail: String) {
        email.value = newEmail
        emailError.value = validateEmail(newEmail)
    }

    fun onPasswordChanged(newPassword: String) {
        password.value = newPassword
        passwordError.value = validatePassword(newPassword)
    }

    fun onRepeatPasswordChanged(newRepeatPassword: String) {
        repeatPassword.value = newRepeatPassword
        repeatPasswordError.value = validateRepeatPassword(newRepeatPassword)
    }

    fun onTermsAndConditionsChanged(newAgreement: Boolean) {
        termsAndConditionsChecked.value = newAgreement
        termsAndConditionsCheckedError.value = validateTermsAndConditions(newAgreement)
    }

    private fun validateEmail(value: String): String? {
        if (value.isBlank()) return "Введите email"
        val emailRegex = Regex("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$")
        return if (!emailRegex.matches(value)) "Введите корректный адрес электронной почты." else null
    }

    private fun validatePassword(value: String): String? {
        return if (value.isBlank()) "Введите пароль" else null
    }

    private fun validateRepeatPassword(value: String): String? {
        if (value.isBlank()) return "Повторите пароль"
        return if (value != password.value) "Пароли не совпадают." else null
    }

    private fun validateTermsAndConditions(value: Boolean): String? {
        return if (value) null else "Необходимо согласиться с условиями обслуживания и политикой конфиденциальности."
    }

    fun onFirstCountinueClick(onSuccess: () -> Unit) {
        viewModelScope.launch {
            if (isFirstFormValid) {
                // TODO server request
                onSuccess()
            }
        }
    }

    // 2nd form
    var surname = mutableStateOf("")
    var name = mutableStateOf("")
    var gender = mutableStateOf<Gender?>(null)
    var selectedDateMillis = mutableStateOf<Long?>(null)

    var surnameError = mutableStateOf<String?>(null)
    var nameError = mutableStateOf<String?>(null)
    var selectedDateError = mutableStateOf<String?>(null)

    val isSecondFormValid: Boolean
        get() = surnameError.value == null &&
                nameError.value == null &&
                selectedDateError.value == null &&
                gender.value != null &&
                selectedDateMillis.value != null &&
                surname.value.isNotBlank() &&
                name.value.isNotBlank()

    fun onSurnameChanged(newSurnameValue: String) {
        surname.value = newSurnameValue
        surnameError.value = validateSurname(newSurnameValue)
    }
    fun onNameChanged(newNameValue: String) {
        name.value = newNameValue
        nameError.value = validateName(newNameValue)
    }
    fun onGenderChanged(newGenderValue: Gender) {
        gender.value = newGenderValue
    }
    fun onDateChanged(newDateValue: Long?) {
        selectedDateMillis.value = newDateValue
        selectedDateError.value = validateDate(newDateValue)
    }

    fun validateSurname(value: String): String? {
        return if (value.isBlank()) "Введите фамилию" else null
    }
    fun validateName(value: String): String? {
        return if (value.isBlank()) "Введите имя" else null
    }
    fun validateDate(value: Long?): String? {
        if (value == null) return "Введите дату рождения."
        val selectedDate = Date(value)
        val today = Calendar.getInstance().apply {
            set(Calendar.HOUR_OF_DAY, 0)
            set(Calendar.MINUTE, 0)
            set(Calendar.SECOND, 0)
            set(Calendar.MILLISECOND, 0)
        }.time

        return if (selectedDate >= today) {
            "Введите корректную дату рождения."
        } else {
            null
        }
    }

    fun onSecondContinueClick(onSuccess: () -> Unit) {
        viewModelScope.launch {
            if (isSecondFormValid) {
                // TODO server request
                onSuccess()
            }
        }
    }
}
