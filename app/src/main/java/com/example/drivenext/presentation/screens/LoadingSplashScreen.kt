package com.example.drivenext.presentation.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

import com.example.drivenext.R
import androidx.compose.ui.res.stringResource
import com.example.drivenext.ui.theme.DriveNextTheme

@Composable
fun LoadingSplashScreen() {
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
    }
}

@Preview(showBackground = true)
@Composable
fun LoadingSplashScreenPreview() {
    DriveNextTheme {
        LoadingSplashScreen()
    }
}
