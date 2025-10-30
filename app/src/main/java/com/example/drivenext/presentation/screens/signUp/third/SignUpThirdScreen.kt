package com.example.drivenext.presentation.screens.signUp.third

import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.compose.foundation.clickable
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import coil.compose.rememberAsyncImagePainter
import com.example.drivenext.R
import com.example.drivenext.presentation.screens.signUp.SharedSignUpViewModel
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignUpThirdScreen(
    onNextButtonClick: () -> Unit,
    onBackButtonClick: () -> Unit,
    sharedSignUpViewModel: SharedSignUpViewModel,
    viewModel: SignUpThirdViewModel = viewModel()
) {
    // image pickers
    val pickProfileImageLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()
    ) { uri: Uri? ->
        viewModel.onProfileImageSelected(uri)
    }

    val pickDriverLicenseImageLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()
    ) { uri: Uri? ->
        viewModel.onDriverLicenseImageSelected(uri)
    }

    val pickPassportImageLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()
    ) { uri: Uri? ->
        viewModel.onPassportImageSelected(uri)
    }

    // date of issue field
    val datePickerState = rememberDatePickerState()
    var showDatePickerDialog by rememberSaveable { mutableStateOf(false) }

    if (showDatePickerDialog) {
        DatePickerDialog(
            onDismissRequest = { showDatePickerDialog = false },
            confirmButton = {
                TextButton(onClick = {
                    viewModel.onDateChanged(datePickerState.selectedDateMillis)
                    showDatePickerDialog = false
                }) {
                    Text("ОК")
                }
            },
            dismissButton = {
                TextButton(onClick = { showDatePickerDialog = false }) {
                    Text("Отмена")
                }
            }
        ) {
            DatePicker(state = datePickerState)
        }
    }

    val formattedDate: String = remember(viewModel.selectedDateMillis.value) {
        val millis = viewModel.selectedDateMillis.value
        if (millis != null) {
            val date = Date(millis)
            SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(date)
        } else {
            ""
        }
    }

    Scaffold(
        topBar = {
            Row(
                modifier = Modifier
                    .padding(top = 50.dp)
                    .fillMaxWidth()
            ) {
                IconButton(
                    onClick = onBackButtonClick
                ) {
                    Icon(
                        painter = painterResource(R.drawable.back_button),
                        contentDescription = null,
                    )
                }
                Text(
                    text = stringResource(R.string.create_account),
                    style = MaterialTheme.typography.titleLarge,
                    modifier = Modifier
                        .align(Alignment.CenterVertically)
                )
            }

        },

        bottomBar = {
            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 8.dp, vertical = 24.dp)
                    .height(52.dp),
                shape = RoundedCornerShape(8.dp),
                enabled = viewModel.isThirdFormValid,
                onClick = { viewModel.onThirdContinueClick(onNextButtonClick, sharedSignUpViewModel) },
            ) {
                Text(
                    text = stringResource(R.string.countinue),
                    style = MaterialTheme.typography.bodyLarge,
                    textAlign = TextAlign.Center,
                )
            }
        },

        modifier = Modifier
            .systemBarsPadding()
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .padding(horizontal = 16.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center
        ) {

            if (viewModel.selectedProfileImageUri.value != null) {
                Image(
                    painter = rememberAsyncImagePainter(viewModel.selectedProfileImageUri.value),
                    contentDescription = null,
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .clickable { pickProfileImageLauncher.launch("image/*") }
                        .clip(CircleShape)
                        .size(128.dp),
                    contentScale = ContentScale.Crop
                )
            } else {
                IconButton(
                    onClick = { pickProfileImageLauncher.launch("image/*") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .size(128.dp)
                ) {
                    Image(
                        painter = painterResource(R.drawable.new_profile_photo),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                    )
                }
            }

            Text(
                text = stringResource(R.string.user_photo_description),
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier
                    .padding(vertical = 40.dp)
            )


            Text(
                text = stringResource(R.string.drivers_license_number),
                style = MaterialTheme.typography.bodyLarge,
            )
            OutlinedTextField(
                value = viewModel.driversLicenseNumber.value,
                onValueChange = { viewModel.onDriversLicenseNumberChange(it) },
                placeholder = { Text(stringResource(R.string.drivers_license_number_placeholder)) },
                isError = viewModel.driversLicenseNumberError.value != null,
                singleLine = true,
                modifier = Modifier
                    .fillMaxWidth()
            )
            viewModel.driversLicenseNumberError.value?.let {
                Text(
                    text = it,
                    color = MaterialTheme.colorScheme.error,
                    style = MaterialTheme.typography.bodySmall,
                    modifier = Modifier
                        .padding(8.dp)
                )
            }

            Text(
                text = stringResource(R.string.date_of_issue),
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier
                    .padding(top = 16.dp)
            )
            OutlinedTextField(
                value = formattedDate,
                onValueChange = {},
                readOnly = true,
                placeholder = { Text(stringResource(R.string.date_placeholder)) },
                isError = viewModel.selectedDateError.value != null,
                singleLine = true,
                modifier = Modifier
                    .fillMaxWidth(),
                leadingIcon = {
                    IconButton(onClick = { showDatePickerDialog = true }) {
                        Icon(
                            painter = painterResource(R.drawable.calendar),
                            contentDescription = null,
                        )
                    }
                }
            )
            viewModel.selectedDateError.value?.let {
                Text(
                    text = it,
                    color = MaterialTheme.colorScheme.error,
                    style = MaterialTheme.typography.bodySmall,
                    modifier = Modifier
                        .padding(8.dp)
                )
            }

            Text(
                text = stringResource(R.string.drivers_license_photo),
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier
                    .padding(top = 24.dp)
            )
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .padding(top = 8.dp)
                    .clickable { pickDriverLicenseImageLauncher.launch("image/*") }
            ) {
                if (viewModel.selectedDriverLicenseImageUri.value != null) {
                    Image(
                        painter = rememberAsyncImagePainter(viewModel.selectedDriverLicenseImageUri.value),
                        contentDescription = null,
                        modifier = Modifier
                            .size(64.dp)
                            .clip(RoundedCornerShape(8.dp)),
                        contentScale = ContentScale.Crop
                    )
                } else {
                    Image(
                        painter = painterResource(R.drawable.upload),
                        contentDescription = null,
                        modifier = Modifier.size(64.dp)
                    )
                }
                Text(
                    text = stringResource(R.string.upload_photo),
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier.padding(start = 8.dp)
                )
            }

            Text(
                text = stringResource(R.string.passport_photo),
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier
                    .padding(top = 24.dp)
            )
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .padding(top = 8.dp, bottom = 16.dp)
                    .clickable { pickPassportImageLauncher.launch("image/*") }
            ) {
                if (viewModel.selectedPassportImageUri.value != null) {
                    Image(
                        painter = rememberAsyncImagePainter(viewModel.selectedPassportImageUri.value),
                        contentDescription = null,
                        modifier = Modifier
                            .size(64.dp)
                            .clip(RoundedCornerShape(8.dp)),
                        contentScale = ContentScale.Crop
                    )
                } else {
                    Image(
                        painter = painterResource(R.drawable.upload),
                        contentDescription = null,
                        modifier = Modifier.size(64.dp)
                    )
                }
                Text(
                    text = stringResource(R.string.upload_photo),
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier.padding(start = 8.dp)
                )
            }
        }

    }
}

