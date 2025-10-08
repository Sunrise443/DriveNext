package com.example.drivenext.presentation.screens.signUp

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.res.stringResource

import com.example.drivenext.R
import com.example.drivenext.ui.theme.DriveNextTheme

enum class Gender {
    Male, Female
}

@Composable
fun SignUpSecondScreen(
    onNextButtonClick: () -> Unit,
    onBackButtonClick: () -> Unit,
) {
    var surname by remember { mutableStateOf("") }
    var name by remember { mutableStateOf("") }
    var patronymic by remember { mutableStateOf("") }
    var dateOfBirth by remember { mutableStateOf("") }
    var selectedGender by remember { mutableStateOf<Gender?>(null) }

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
            Text(
                text = stringResource(R.string.surname),
                style = MaterialTheme.typography.bodyLarge,
            )
            OutlinedTextField(
                value = surname,
                onValueChange = { surname = it },
                placeholder = { Text(stringResource(R.string.surname_placeholder)) },
                singleLine = true,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 24.dp)
            )

            Text(
                text = stringResource(R.string.name),
                style = MaterialTheme.typography.bodyLarge,
            )
            OutlinedTextField(
                value = name,
                onValueChange = { name = it },
                placeholder = { Text(stringResource(R.string.name_placeholder)) },
                singleLine = true,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 24.dp),
            )

            Text(
                text = stringResource(R.string.patronymic),
                style = MaterialTheme.typography.bodyLarge,
            )
            OutlinedTextField(
                value = patronymic,
                onValueChange = { patronymic = it },
                placeholder = { Text(stringResource(R.string.patronymic_placeholder)) },
                singleLine = true,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 24.dp),
            )

            Text(
                text = stringResource(R.string.date_of_birth),
                style = MaterialTheme.typography.bodyLarge,
            )
            OutlinedTextField(
                value = dateOfBirth,
                onValueChange = { dateOfBirth = it },
                placeholder = { Text(stringResource(R.string.date_placeholder)) },
                singleLine = true,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 24.dp),
            )

            Text(
                text = stringResource(R.string.sex),
                style = MaterialTheme.typography.bodyLarge,
            )

            Row(verticalAlignment = Alignment.CenterVertically) {
                RadioButton(
                    selected = selectedGender == Gender.Male,
                    onClick = { selectedGender = Gender.Male }
                )
                Text(
                    text = stringResource(R.string.male),
                    style = MaterialTheme.typography.bodyLarge,
                )

                RadioButton(
                    selected = selectedGender == Gender.Female,
                    onClick = { selectedGender = Gender.Female }
                )
                Text(
                    text = stringResource(R.string.female),
                    style = MaterialTheme.typography.bodyLarge,
                )
            }
        }

    }
}

@Preview(showBackground = true)
@Composable
fun SignUpSecondScreenPreview() {
    DriveNextTheme {
        SignUpSecondScreen(
            onNextButtonClick = {},
            onBackButtonClick = {},
        )
    }
}
