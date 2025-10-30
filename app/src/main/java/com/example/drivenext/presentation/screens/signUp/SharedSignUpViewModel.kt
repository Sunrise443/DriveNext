package com.example.drivenext.presentation.screens.signUp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.drivenext.data.remote.model.UserDto
import com.example.drivenext.supabase
import io.github.jan.supabase.postgrest.from
import kotlinx.coroutines.launch

class SharedSignUpViewModel() : ViewModel() {
    var email: String = ""
    var password: String = ""
    var name: String = ""
    var surname: String = ""
    var patronymic: String? = null
    var birthDate: String = ""
    var gender: String = ""
    var driversLicenseNumber: String = ""
    var licenseIssueDate: String = ""

    fun saveEmailAndPassword(email: String, password: String) {
        this.email = email
        this.password = password
    }

    fun savePersonalInfo(name: String, surname: String, patronymic: String?, birthDate: String, gender: String) {
        this.name = name
        this.surname = surname
        this.patronymic = patronymic
        this.birthDate = birthDate
        this.gender = gender
    }

    fun saveLicenseInfo(number: String, issueDate: Long?) {
        this.driversLicenseNumber = number
        this.licenseIssueDate = issueDate.toString()
    }

    fun submitUser() {
        viewModelScope.launch {
            try {
                val user = UserDto(
                    email = email,
                    password = password,
                    name = name,
                    surname = surname,
                    patronymic = patronymic,
                    dateOfBirth = birthDate,
                    sex = gender,
                    driversLicenseNumber = driversLicenseNumber,
                    dateOfIssue = licenseIssueDate,
                    profilePicture = "",
                    driversLicensePhoto = "",
                    passportPhoto = "",
                )
                val response = supabase.from("users").insert(user)
                println(response)
            } catch (e: Exception) {
                println(e)
            }
        }
    }
}
