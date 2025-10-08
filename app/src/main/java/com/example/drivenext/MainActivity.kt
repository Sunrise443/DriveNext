package com.example.drivenext

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.lifecycle.lifecycleScope
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.drivenext.ui.theme.DriveNextTheme

import com.example.drivenext.core.Route
import com.example.drivenext.presentation.screens.*
import com.example.drivenext.presentation.screens.login.LoginScreen
import com.example.drivenext.presentation.screens.signUp.*
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()
        setContent {
            DriveNextTheme {
                val navController = rememberNavController()
                NavHost (
                    navController = navController,
                    startDestination = Route.LoadingSplashScreen
                ) {
                    composable<Route.LoadingSplashScreen> {
                        LoadingSplashScreen(
                            navController = navController
                        )
                    }

                    composable<Route.NoConnectionScreen> {
                        NoConnectionScreen(
                            onTryAgainButtonClick = { navController.navigate(Route.LoadingSplashScreen) }
                        )
                    }

                    composable<Route.OnboardingScreen> {
                        OnboardingScreen(
                            onLetsGoButtonClick = {
                                lifecycleScope.launch {

                                }
                                navController.navigate(Route.GettingStartedScreen)
                            }
                        )
                    }

                    composable<Route.GettingStartedScreen> {
                        GettingStartedScreen(
                            onLogInButtonClick = { navController.navigate(Route.LoginScreen) },
                            onSignUpButtonClick = { navController.navigate(Route.SignUpFirstScreen) }
                        )
                    }

                    composable<Route.LoginScreen> {
                        LoginScreen(
                            onSignUpButtonClick = { navController.navigate(Route.SignUpFirstScreen) },
                            onLoginCLick = { navController.navigate(Route.OnboardingScreen) }
                        )
                    }

                    composable<Route.SignUpFirstScreen> {
                        SignUpFirstScreen(
                            onNextButtonClick = { navController.navigate(Route.SignUpSecondScreen) },
                            onBackButtonClick = { navController.navigate(Route.GettingStartedScreen) }
                        )
                    }

                    composable<Route.SignUpSecondScreen> {
                        SignUpSecondScreen(
                            onNextButtonClick = { navController.navigate(Route.SignUpThirdScreen) },
                            onBackButtonClick = { navController.navigate(Route.SignUpFirstScreen) }
                        )
                    }

                    composable<Route.SignUpThirdScreen> {
                        SignUpThirdScreen(
                            onNextButtonClick = { navController.navigate(Route.SignUpFourthScreen) },
                            onBackButtonClick = { navController.navigate(Route.SignUpSecondScreen) }
                        )
                    }

                    composable<Route.SignUpFourthScreen> {
                        SignUpFourthScreen()
                    }
                }
            }
        }
    }
}
