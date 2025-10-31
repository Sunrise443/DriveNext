package com.example.drivenext.presentation.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview
import com.example.drivenext.R
import com.example.drivenext.presentation.screens.components.BottomNavBar
import com.example.drivenext.ui.theme.DriveNextTheme

@Composable
fun ProfileScreen(
    onHomeScreenClick: () -> Unit = {},
    onFavoritesClick: () -> Unit = {},
    onSettingsClick: () -> Unit = {},
) {
    Scaffold(
        modifier = Modifier
            .systemBarsPadding(),

        topBar = {
            Text(
                text = "Профиль",
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier
                    .fillMaxWidth(),
                textAlign = TextAlign.Center
            )
        },

        bottomBar = {
            BottomNavBar(onHomeScreenClick, onFavoritesClick, onSettingsClick)
        },
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(top = 48.dp)
                .padding(innerPadding)
                .fillMaxWidth(),
        ) {
            IconButton(
                onClick = {},
                modifier = Modifier
                    .fillMaxWidth()
                    .size(128.dp)
                    .padding(10.dp)
            ) {
                Image(
                    painter = painterResource(R.drawable.new_profile_photo),
                    contentDescription = null,
                    contentScale = ContentScale.Fit,
                )
            }


            Text(
                text = "Silly Dummy",
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center
            )

            Text(
                text = "Присоединился в октябре 2025",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 20.dp),
                textAlign = TextAlign.Center
            )

            Row(
                modifier = Modifier
                    .clickable {}
                    .fillMaxWidth()
                    .padding(10.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column {
                    Text(
                        text = "Электронная почта",
                    )
                    Text(
                        text = "mymy@gmail.com",
                    )
                }

            }

            HorizontalDivider(
                modifier = Modifier
                    .fillMaxWidth(),
                thickness = 1.dp,
                color = Color.Gray
            )

            Row(
                modifier = Modifier
                    .clickable {}
                    .fillMaxWidth()
                    .padding(10.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column {
                    Text(
                        text = "Пароль",
                    )
                    Text(
                        text = "Поменять пароль",
                    )
                }

            }

            HorizontalDivider(
                modifier = Modifier
                    .fillMaxWidth(),
                thickness = 1.dp,
                color = Color.Gray
            )

            Row(
                modifier = Modifier
                    .clickable {}
                    .fillMaxWidth()
                    .padding(10.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column {
                    Text(
                        text = "Пол",
                    )
                    Text(
                        text = "Женский",
                    )
                }

            }

            HorizontalDivider(
                modifier = Modifier
                    .fillMaxWidth(),
                thickness = 1.dp,
                color = Color.Gray
            )

            Row(
                modifier = Modifier
                    .clickable {}
                    .fillMaxWidth()
                    .padding(10.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column {
                    Text(
                        text = "Google",
                    )
                    Text(
                        text = "mymy@gmail.com",
                    )
                }

            }

            HorizontalDivider(
                modifier = Modifier
                    .fillMaxWidth(),
                thickness = 1.dp,
                color = Color.Gray
            )

            Row(
                modifier = Modifier
                    .clickable {}
                    .fillMaxWidth()
                    .padding(10.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Выйти из профиля",
                )

            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProfileScreenPreview() {
    DriveNextTheme {
        ProfileScreen()
    }
}
