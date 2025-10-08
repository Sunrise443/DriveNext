package com.example.drivenext.presentation.screens.signUp

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.res.stringResource

import com.example.drivenext.R
import com.example.drivenext.ui.theme.DriveNextTheme
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignUpThirdScreen(
    onNextButtonClick: () -> Unit,
    onBackButtonClick: () -> Unit,
) {
    var driversLicenseNumber by remember { mutableStateOf("") }


    // date of issue field
    val datePickerState = rememberDatePickerState()
    var showDatePickerDialog by rememberSaveable { mutableStateOf(false) }

    if (showDatePickerDialog) {
        DatePickerDialog(
            onDismissRequest = { showDatePickerDialog = false },
            confirmButton = {
                TextButton(onClick = { showDatePickerDialog = false }) {
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

    val selectedDateMillis = datePickerState.selectedDateMillis
    val formattedDate = remember(selectedDateMillis) {
        if (selectedDateMillis != null) {
            val formatter = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
            formatter.format(Date(selectedDateMillis))
        } else ""
    }

    Scaffold(
        topBar = {
            Row(
                modifier = Modifier
                    .padding(top = 50.dp)
                    .fillMaxWidth()
            ) {
                IconButton(
                    onClick = {}
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
                onClick = onNextButtonClick,
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

            IconButton(
                onClick = onBackButtonClick,
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
                value = driversLicenseNumber,
                onValueChange = { driversLicenseNumber = it },
                placeholder = { Text(stringResource(R.string.drivers_license_number_placeholder)) },
                singleLine = true,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 24.dp)
            )

            Text(
                text = stringResource(R.string.date_of_issue),
                style = MaterialTheme.typography.bodyLarge,
            )
            OutlinedTextField(
                value = formattedDate,
                onValueChange = {},
                readOnly = true,
                placeholder = { Text(stringResource(R.string.date_placeholder)) },
                singleLine = true,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 24.dp),
                leadingIcon = {
                    IconButton(onClick = { showDatePickerDialog = true }) {
                        Icon(
                            painter = painterResource(R.drawable.calendar),
                            contentDescription = null,
                        )
                    }
                }
            )

            Text(
                text = stringResource(R.string.drivers_license_photo),
                style = MaterialTheme.typography.bodyLarge,
            )
            Row(
                modifier = Modifier
                    .padding(top = 8.dp, bottom = 16.dp)
            ) {
                Image(
                    painter = painterResource(R.drawable.upload),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                )
                Text(
                    text = stringResource(R.string.upload_photo),
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier
                        .align(Alignment.CenterVertically)
                        .padding(start = 8.dp)
                )
            }

            Text(
                text = stringResource(R.string.passport_photo),
                style = MaterialTheme.typography.bodyLarge,
            )
            Row(
                modifier = Modifier
                    .padding(top = 8.dp)
            ) {
                Image(
                    painter = painterResource(R.drawable.upload),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                )
                Text(
                    text = stringResource(R.string.upload_photo),
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier
                        .align(Alignment.CenterVertically)
                        .padding(start = 8.dp)
                )
            }
        }

    }
}

@Preview(showBackground = true)
@Composable
fun SignUpThirdScreenPreview() {
    DriveNextTheme {
        SignUpThirdScreen(
            onNextButtonClick = {},
            onBackButtonClick = {},
        )
    }
}
