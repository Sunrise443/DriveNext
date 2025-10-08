package com.example.drivenext.presentation.screens.login

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.drivenext.R
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.res.stringResource

@Composable
fun LoginScreen(
    onSignUpButtonClick: () -> Unit,
    onLoginClick: () -> Unit,
    viewModel: LoginViewModel = viewModel(),
) {
    var passwordVisible by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .padding(horizontal = 16.dp)
            .fillMaxSize()
            .systemBarsPadding(),
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = stringResource(R.string.log_in_title),
            style = MaterialTheme.typography.titleLarge,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(bottom = 16.dp)
                .fillMaxWidth()
        )

        Text(
            text = stringResource(R.string.log_in_description),
            style = MaterialTheme.typography.bodyLarge,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(bottom = 50.dp)
                .fillMaxWidth()
        )

        // Email
        Column(
            modifier = Modifier.padding(bottom = 24.dp)
        ) {
            Text(text = stringResource(R.string.email), style = MaterialTheme.typography.bodyLarge)
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
        }

        Column(
            modifier = Modifier.padding(bottom = 24.dp)
        ) {
            Text(
                text = stringResource(R.string.password),
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
        }

        TextButton(
            onClick = {},
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.CenterHorizontally)
        ) {
            Text(
                text = stringResource(R.string.forgot_password),
                style = MaterialTheme.typography.bodyLarge,
            )
        }

        // Login Button
        Button(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp)
                .height(52.dp),
            shape = RoundedCornerShape(8.dp),
            enabled = viewModel.isFormValid,
            onClick = {
                viewModel.onLoginClick(onLoginClick)
            }
        ) {
            Text(
                text = stringResource(R.string.log_in),
                style = MaterialTheme.typography.bodyLarge,
                textAlign = TextAlign.Center,
            )
        }

        // Google Login
        Button(
            modifier = Modifier
                .fillMaxWidth()
                .height(52.dp),
            shape = RoundedCornerShape(8.dp),
            onClick = {},
        ) {
            Icon(
                painter = painterResource(R.drawable.google_icon),
                contentDescription = null,
                modifier = Modifier
                    .padding(end = 16.dp)
            )
            Text(
                text = stringResource(R.string.google_log_in),
                style = MaterialTheme.typography.bodyLarge,
                textAlign = TextAlign.Center,
            )
        }

        // Sign Up Button
        TextButton(
            onClick = onSignUpButtonClick,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
        ) {
            Text(
                text = stringResource(R.string.sign_in),
            )
        }
    }
}
