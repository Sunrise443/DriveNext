package com.example.drivenext.presentation.screens.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.drivenext.R

@Composable
fun BottomNavBar(
    onHomeScreenClick: () -> Unit = {},
    onFavoritesClick: () -> Unit = {},
    onSettingsClick: () -> Unit = {},
) {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ) {
        IconButton(
            onClick = onHomeScreenClick,
            modifier = Modifier
                .padding(horizontal = 15.dp)
        ) {
            Icon(
                painter = painterResource(R.drawable.home_button),
                contentDescription = null
            )
        }

        IconButton(
            onClick = onFavoritesClick,
            modifier = Modifier
                .padding(horizontal = 15.dp)
        ) {
            Icon(
                painter = painterResource(R.drawable.bookmark_button),
                contentDescription = null,
            )
        }

        IconButton(
            onClick = onSettingsClick,
            modifier = Modifier
                .padding(horizontal = 15.dp)
        ) {
            Icon(
                painter = painterResource(R.drawable.settings_button),
                contentDescription = null,
            )
        }
    }
}