package com.example.drivenext.presentation.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
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
import com.example.drivenext.ui.theme.DriveNextTheme

@Composable
fun ProfileScreen(
//    navController: NavController,
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
                text = "Иван Иванов",
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center
            )

            Text(
                text = "Присоединился вчера",
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
                        text = "ТУТ ЭЛ ПОЧТА СЕРЫМ",
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
                        text = "ТУТ ПОЛ СЕРЫМ",
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
                        text = "ТУТ ЭЛ ПОЧТА СЕРЫМ",
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
