package com.example.drivenext.presentation.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview
import com.example.drivenext.R
import com.example.drivenext.presentation.screens.components.CarCard
import com.example.drivenext.ui.theme.DriveNextTheme

@Composable
fun HomepageScreen(
//    navController: NavController,
) {
    Scaffold(
        modifier = Modifier
            .systemBarsPadding(),

        bottomBar = {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                IconButton(
                    onClick = {},
                    modifier = Modifier
                        .padding(horizontal = 15.dp)
                ) {
                    Icon(
                        painter = painterResource(R.drawable.home_button),
                        contentDescription = null
                    )
                }

                IconButton(
                    onClick = {},
                    modifier = Modifier
                        .padding(horizontal = 15.dp)
                ) {
                    Icon(
                        painter = painterResource(R.drawable.bookmark_button),
                        contentDescription = null,
                    )
                }

                IconButton(
                    onClick = { },
                    modifier = Modifier
                        .padding(horizontal = 15.dp)
                ) {
                    Icon(
                        painter = painterResource(R.drawable.settings_button),
                        contentDescription = null,
                    )
                }
            }
        },
    ) { innerPadding ->
        Column(
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
        ) {
            Column (
                modifier = Modifier
                    .padding(20.dp)
            ) {
                OutlinedTextField(
                    value = "",
                    onValueChange = { },
                    placeholder = { Text("Выберите марку автомобиля") },
                    singleLine = true,
                    modifier = Modifier
                        .fillMaxWidth(),
                    shape = RoundedCornerShape(8.dp),
                    leadingIcon = {
                        Icon(
                            painter = painterResource(R.drawable.search_icon),
                            contentDescription = null,
                        )
                    }
                )

                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = "Давайте найдем автомобиль",
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier
                        .fillMaxWidth(),
                )
            }
            LazyColumn(
                content = {
                    items(12) { item ->
                        CarCard()
                    }
                }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomepageScreenPreview() {
    DriveNextTheme {
        HomepageScreen()
    }
}
