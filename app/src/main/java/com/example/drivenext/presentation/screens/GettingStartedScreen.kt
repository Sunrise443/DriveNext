package com.example.drivenext.presentation.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

import com.example.drivenext.R
import androidx.compose.ui.res.stringResource
import com.example.drivenext.ui.theme.DriveNextTheme

@Composable
fun GettingStartedScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp, 8.dp),
    ) {
        Column(
            modifier = Modifier
                .padding(top = 40.dp)
        ) {
            Text(
                text = stringResource(R.string.app_name),
                style = MaterialTheme.typography.titleLarge,
            )
            Text(
                text = stringResource(R.string.app_description),
                style = MaterialTheme.typography.bodyLarge
            )
        }

        Image(
            painter = painterResource(R.drawable.loading_screen_img),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.Center)
        )

        Column (
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 50.dp, start = 8.dp),
            verticalArrangement = Arrangement.Bottom
        ) {
            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 8.dp)
                    .height(52.dp),
                shape = RoundedCornerShape(8.dp),
                onClick = {},
            ) {
                Text(
                    text = stringResource(R.string.log_in),
                    style = MaterialTheme.typography.bodyLarge,
                    textAlign = TextAlign.Center,
                )
            }

            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(52.dp),
                shape = RoundedCornerShape(8.dp),
                onClick = {},
            ) {
                Text(
                    text = stringResource(R.string.sign_in),
                    style = MaterialTheme.typography.bodyLarge,
                    textAlign = TextAlign.Center,
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GettingStartedScreenPreview() {
    DriveNextTheme {
        GettingStartedScreen()
    }
}
