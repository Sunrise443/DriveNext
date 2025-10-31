package com.example.drivenext.presentation.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview
import com.example.drivenext.R
import com.example.drivenext.presentation.screens.components.BottomNavBar
import com.example.drivenext.ui.theme.DriveNextTheme

@Composable
fun SettingsScreen(
    onProfileCLick: () -> Unit = {},
    onHomeScreenClick: () -> Unit = {},
    onFavoritesClick: () -> Unit = {},
    onSettingsClick: () -> Unit = {},
) {
    Scaffold(
        modifier = Modifier
            .systemBarsPadding(),

        topBar = {
            Text(
                text = "Настройки",
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
            Row(
                modifier = Modifier
                    .clickable { onProfileCLick() }
                    .padding(bottom = 20.dp)
                    .padding(10.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {

                Icon(
                    painter = painterResource(R.drawable.no_profile_picture_icon),
                    contentDescription = null,
                    modifier = Modifier
                        .padding(end = 10.dp)
                )

                Column(
                    modifier = Modifier.weight(1f)
                ) {
                    Text(
                        text = "Silly Dummy DumDum"
                    )
                    Text(
                        text = "mymy@gmail.com"
                    )
                }
                Icon(
                    painter = painterResource(R.drawable.next_button),
                    contentDescription = null,
                )

            }

            Row(
                modifier = Modifier
                    .clickable {}
                    .padding(bottom = 10.dp)
                    .padding(10.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painter = painterResource(R.drawable.taxi_icon),
                    contentDescription = null,
                    modifier = Modifier
                        .padding(end = 10.dp)
                        .size(25.dp)
                )
                Text(
                    text = "Мои бронирования",
                    modifier = Modifier.weight(1f)
                )
                Icon(
                    painter = painterResource(R.drawable.next_button),
                    contentDescription = null,
                )
            }

            Spacer(modifier = Modifier.height(5.dp))

            Row(
                modifier = Modifier
                    .clickable {}
                    .padding(10.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painter = painterResource(R.drawable.theme_icon),
                    contentDescription = null,
                    modifier = Modifier
                        .padding(end = 10.dp)
                        .size(25.dp)
                )
                Text(
                    text = "Тема",
                    modifier = Modifier.weight(1f)
                )
                Icon(
                    painter = painterResource(R.drawable.next_button),
                    contentDescription = null,
                )
            }

            Row(
                modifier = Modifier
                    .clickable {}
                    .padding(10.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painter = painterResource(R.drawable.notifications_icon),
                    contentDescription = null,
                    modifier = Modifier
                        .padding(end = 10.dp)
                        .size(25.dp)
                )
                Text(
                    text = "Уведомления",
                    modifier = Modifier.weight(1f)
                )
                Icon(
                    painter = painterResource(R.drawable.next_button),
                    contentDescription = null,
                )
            }

            Row(
                modifier = Modifier
                    .clickable {}
                    .padding(10.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painter = painterResource(R.drawable.banknotes_icon),
                    contentDescription = null,
                    modifier = Modifier
                        .padding(end = 10.dp)
                        .size(25.dp)
                )
                Text(
                    text = "Получить свой автомобиль",
                    modifier = Modifier.weight(1f)
                )
                Icon(
                    painter = painterResource(R.drawable.next_button),
                    contentDescription = null,
                )
            }

            HorizontalDivider(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp, horizontal = 24.dp),
                thickness = 1.dp,
                color = Color.Gray
            )

            Row(
                modifier = Modifier
                    .clickable {}
                    .padding(10.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painter = painterResource(R.drawable.help_icon),
                    contentDescription = null,
                    modifier = Modifier
                        .padding(end = 10.dp)
                        .size(25.dp)
                )
                Text(
                    text = "Помощь",
                    modifier = Modifier.weight(1f)
                )
                Icon(
                    painter = painterResource(R.drawable.next_button),
                    contentDescription = null,
                )
            }

            Row(
                modifier = Modifier
                    .clickable {}
                    .padding(10.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painter = painterResource(R.drawable.letter_icon),
                    contentDescription = null,
                    modifier = Modifier
                        .padding(end = 10.dp)
                        .size(25.dp)
                )
                Text(
                    text = "Пригласи друга",
                    modifier = Modifier.weight(1f)
                )
                Icon(
                    painter = painterResource(R.drawable.next_button),
                    contentDescription = null,
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SettingsScreenPreview() {
    DriveNextTheme {
        SettingsScreen()
    }
}
