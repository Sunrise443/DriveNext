package com.example.drivenext.presentation.screens.homepage

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
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
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.drivenext.R
import com.example.drivenext.presentation.screens.components.BottomNavBar
import com.example.drivenext.presentation.screens.components.CarCard

@Composable
fun HomepageScreen(
    viewModel: HomeViewModel = viewModel(),
    onHomeScreenClick: () -> Unit = {},
    onFavoritesClick: () -> Unit = {},
    onSettingsClick: () -> Unit = {},
    loadResultScreen: () -> Unit = {},
    onDataLoading: () -> Unit = {}
) {
    val cars = viewModel.cars
    val isLoading = viewModel.isLoading.value

    Scaffold(
        modifier = Modifier
            .systemBarsPadding(),

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
            Column(
                modifier = Modifier
                    .padding(20.dp)
            ) {
                OutlinedTextField(
                    value = viewModel.searchQuery.value,
                    onValueChange = { viewModel.searchQuery.value = it },

                    placeholder = { Text("Выберите марку автомобиля") },
                    singleLine = true,
                    modifier = Modifier
                        .fillMaxWidth(),
                    shape = RoundedCornerShape(8.dp),

                    leadingIcon = {
                        IconButton(
                            onClick = { viewModel.onSearchClick(loadResultScreen, onDataLoading) }
                        ) {
                            Icon(
                                painter = painterResource(R.drawable.search_icon),
                                contentDescription = null,
                            )
                        }
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

            if (isLoading) {
                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    CircularProgressIndicator()
                }
            } else {
                LazyColumn {
                    items(cars) { car ->
                        CarCard(car)
                    }
                }
            }
        }
    }
}

