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

import com.example.drivenext.R
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.drivenext.ui.theme.DriveNextTheme

@Composable
fun SignUpFirstScreen(
    onNextButtonClick: () -> Unit,
    onBackButtonClick: () -> Unit,
    viewModel: SignUpViewModel = viewModel()
) {
    var email by remember { mutableStateOf("") }

    var password by remember { mutableStateOf("") }
    var repeatPassword by remember { mutableStateOf("") }

    var passwordVisible by remember { mutableStateOf(false) }
    var repeatPasswordVisible by remember { mutableStateOf(false) }

    var checked by remember { mutableStateOf(false) }

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
                onClick = {viewModel.onFirstCountinueClick(onNextButtonClick)},
                enabled = viewModel.isFirstFormValid,
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
                text = stringResource(R.string.email),
                style = MaterialTheme.typography.bodyLarge,
            )
            OutlinedTextField(
                value = viewModel.email.value,
                onValueChange = { viewModel.onEmailChanged(it) },
                placeholder = { Text(stringResource(R.string.email_description)) },
                isError = viewModel.emailError.value != null,
                singleLine = true,
                modifier = Modifier
                    .fillMaxWidth()
            )
            viewModel.emailError.value?.let {
                Text(
                    text = it,
                    color = MaterialTheme.colorScheme.error,
                    style = MaterialTheme.typography.bodySmall,
                    modifier = Modifier
                        .padding(8.dp)
                )
            }

            Text(
                text = stringResource(R.string.create_password),
                style = MaterialTheme.typography.bodyLarge,
            )
            OutlinedTextField(
                value = viewModel.password.value,
                onValueChange = { viewModel.onPasswordChanged(it) },
                placeholder = { Text(stringResource(R.string.password_description)) },
                isError = viewModel.passwordError.value != null,
                singleLine = true,
                modifier = Modifier
                    .fillMaxWidth(),

                visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),

                trailingIcon = {
                    IconButton(onClick = { passwordVisible = !passwordVisible }) {
                        Icon(
                            painter = painterResource(R.drawable.password_visibility_off),
                            contentDescription = null,
                        )
                    }
                }
            )
            viewModel.passwordError.value?.let {
                Text(
                    text = it,
                    color = MaterialTheme.colorScheme.error,
                    style = MaterialTheme.typography.bodySmall,
                    modifier = Modifier
                        .padding(8.dp)
                )
            }

            Text(
                text = stringResource(R.string.repeat_password),
                style = MaterialTheme.typography.bodyLarge,
            )
            OutlinedTextField(
                value = viewModel.repeatPassword.value,
                onValueChange = { viewModel.onRepeatPasswordChanged(it) },
                placeholder = { Text(stringResource(R.string.password_description)) },
                isError = viewModel.repeatPasswordError.value != null,
                singleLine = true,
                modifier = Modifier
                    .fillMaxWidth(),
                visualTransformation = if (repeatPasswordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                trailingIcon = {
                    IconButton(onClick = { repeatPasswordVisible = !repeatPasswordVisible }) {
                        Icon(
                            painter = painterResource(R.drawable.password_visibility_off),
                            contentDescription = null,
                        )
                    }
                }
            )
            viewModel.repeatPasswordError.value?.let {
                Text(
                    text = it,
                    color = MaterialTheme.colorScheme.error,
                    style = MaterialTheme.typography.bodySmall,
                    modifier = Modifier
                        .padding(8.dp)
                )
            }

            Row(
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Checkbox(
                    checked = viewModel.termsAndConditionsChecked.value,
                    onCheckedChange = { viewModel.onTermsAndConditionsChanged(it) }
                )
                Text(
                    text = stringResource(R.string.terms_and_conditions)
                )
            }
            viewModel.termsAndConditionsCheckedError.value?.let {
                Text(
                    text = it,
                    color = MaterialTheme.colorScheme.error,
                    style = MaterialTheme.typography.bodySmall,
                    modifier = Modifier
                        .padding(8.dp)
                )
            }
        }

    }
}

@Preview(showBackground = true)
@Composable
fun SignUpFirstScreenPreview() {
    DriveNextTheme {
        SignUpFirstScreen(
            onNextButtonClick = {},
            onBackButtonClick = {},
        )
    }
}
