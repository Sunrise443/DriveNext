package com.example.drivenext.presentation.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview
import com.example.drivenext.R
import com.example.drivenext.presentation.screens.components.BottomNavBar
import com.example.drivenext.presentation.screens.components.CarCard
import com.example.drivenext.ui.theme.DriveNextTheme

@Composable
fun SearchResultScreen(
    onHomeScreenClick: () -> Unit = {},
    onFavoritesClick: () -> Unit = {},
    onSettingsClick: () -> Unit = {},
) {
    Scaffold(
        modifier = Modifier
            .systemBarsPadding(),

        topBar = {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                IconButton(
                    onClick = { }
                ) {
                    Icon(
                        painter = painterResource(R.drawable.back_button),
                        contentDescription = null,
                    )
                }
                Text(
                    text = "Результаты поиска",
                    style = MaterialTheme.typography.titleLarge,
                    modifier = Modifier
                        .align(Alignment.CenterVertically),
                )
            }
        },

        bottomBar = {
            BottomNavBar(onHomeScreenClick, onFavoritesClick, onSettingsClick)
        },
    ) { innerPadding ->
        Column(
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
        ) {
            // lazycolumn
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SearchResultScreenPreview() {
    DriveNextTheme {
        SearchResultScreen()
    }
}
