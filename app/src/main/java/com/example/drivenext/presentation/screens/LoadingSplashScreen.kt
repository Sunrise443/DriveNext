package com.example.drivenext.presentation.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

import com.example.drivenext.R
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import com.example.drivenext.core.AppPreferences
import com.example.drivenext.core.Route
import com.example.drivenext.ui.theme.DriveNextTheme
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.first

@Composable
fun LoadingSplashScreen(
    navController: NavController,
) {
    val context = LocalContext.current
    val prefs = remember { AppPreferences(context) }

    LaunchedEffect(Unit) {
        delay(2000)

        val isFirstLaunch = prefs.isFirstLaunch.first()
        val token = prefs.token.first()

        if (isFirstLaunch || token.isNullOrEmpty()) {
            navController.navigate(Route.GettingStartedScreen) {
                popUpTo(Route.GettingStartedScreen) { inclusive = true }
            }
        } else {
//            TODO load to the main screen
//            navController.navigate(Route.) {
//                popUpTo(Route.) {inclusive = true}
//            }
        }

//        if (isFirstLaunch) {
//            prefs.setFirstLaunchDone()
//        }
    }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .systemBarsPadding(),
    ) {
        Column(
            modifier = Modifier
                .padding(top = 40.dp, start = 24.dp)
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

//@Preview(showBackground = true)
//@Composable
//fun LoadingSplashScreenPreview() {
//    DriveNextTheme {
//        LoadingSplashScreen()
//    }
//}
