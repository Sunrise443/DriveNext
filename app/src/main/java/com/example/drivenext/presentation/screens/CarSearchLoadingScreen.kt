package com.example.drivenext.presentation.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.drivenext.R
import com.example.drivenext.ui.theme.DriveNextTheme

@Composable
fun CarSearchLoadingScreen(
) {
    Scaffold(
        content = { paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Image(
                    painter = painterResource(R.drawable.car_loading_picture),
                    contentDescription = null,
                    modifier = Modifier
                        .size(128.dp)
                        .padding(bottom = 24.dp)
                )
                Text(
                    text = "Ищем подходящие автомобили",
                    style = MaterialTheme.typography.titleLarge,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .padding(bottom = 16.dp)
                )
            }
        },

        modifier = Modifier
            .systemBarsPadding()
    )
}

@Preview(showBackground = true)
@Composable
fun CarSearchLoadingScreenPreview() {
    DriveNextTheme {
        CarSearchLoadingScreen()
    }
}
