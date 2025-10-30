package com.example.drivenext

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.drivenext.ui.theme.DriveNextTheme
import com.example.drivenext.core.Route
import com.example.drivenext.presentation.screens.*
import com.example.drivenext.presentation.screens.homepage.HomepageScreen
import com.example.drivenext.presentation.screens.login.LoginScreen
import com.example.drivenext.presentation.screens.signUp.SharedSignUpViewModel
import com.example.drivenext.presentation.screens.signUp.first.SignUpFirstScreen
import com.example.drivenext.presentation.screens.signUp.fourth.SignUpFourthScreen
import com.example.drivenext.presentation.screens.signUp.second.SignUpSecondScreen
import com.example.drivenext.presentation.screens.signUp.third.SignUpThirdScreen
import io.github.jan.supabase.createSupabaseClient
import io.github.jan.supabase.postgrest.Postgrest

val supabase = createSupabaseClient(

    // DO NOT SAVE TO GIT
    supabaseUrl = "https://ecgpouokhnxcrbrdyszj.supabase.co",
) {
    install(Postgrest)
}

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val sharedSignUpViewModel = SharedSignUpViewModel()

        enableEdgeToEdge()
        setContent {
            DriveNextTheme {
                val navController = rememberNavController()
                NavHost(
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
                                navController.navigate(Route.HomepageScreen)
                            },
                            onSkipButtonClick = {
                                navController.navigate(Route.HomepageScreen)
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
                            onLoginClick = { navController.navigate(Route.OnboardingScreen) },
                        )
                    }

                    composable<Route.SignUpFirstScreen> {
                        SignUpFirstScreen(
                            onNextButtonClick = { navController.navigate(Route.SignUpSecondScreen) },
                            onBackButtonClick = { navController.navigate(Route.GettingStartedScreen) },
                            sharedSignUpViewModel
                        )
                    }

                    composable<Route.SignUpSecondScreen> {
                        SignUpSecondScreen(
                            onNextButtonClick = { navController.navigate(Route.SignUpThirdScreen) },
                            onBackButtonClick = { navController.navigate(Route.SignUpFirstScreen) },
                            sharedSignUpViewModel
                        )
                    }

                    composable<Route.SignUpThirdScreen> {
                        SignUpThirdScreen(
                            onNextButtonClick = { navController.navigate(Route.SignUpFourthScreen) },
                            onBackButtonClick = { navController.navigate(Route.SignUpSecondScreen) },
                            sharedSignUpViewModel
                        )
                    }

                    composable<Route.SignUpFourthScreen> {
                        SignUpFourthScreen(
                            onNextButtonClick = { navController.navigate(Route.OnboardingScreen) }
                        )
                    }

                    composable<Route.HomepageScreen> {
                        HomepageScreen(
                            onHomeScreenClick = { navController.navigate(Route.HomepageScreen) },
                            onFavoritesClick = {},
                            onSettingsClick = { navController.navigate(Route.SettingsScreen) },
                        )
                    }

                    composable<Route.SearchResultScreen> {
                        SearchResultScreen(
                            onHomeScreenClick = { navController.navigate(Route.HomepageScreen) },
                            onFavoritesClick = {},
                            onSettingsClick = { navController.navigate(Route.SettingsScreen) },
                        )
                    }

                    composable<Route.SettingsScreen> {
                        SettingsScreen(
                            onProfileCLick = { navController.navigate(Route.ProfileScreen) },
                            onHomeScreenClick = { navController.navigate(Route.HomepageScreen) },
                            onFavoritesClick = {},
                            onSettingsClick = { navController.navigate(Route.SettingsScreen) },
                        )
                    }

                    composable<Route.ProfileScreen> {
                        ProfileScreen(
                            onHomeScreenClick = { navController.navigate(Route.HomepageScreen) },
                            onFavoritesClick = {},
                            onSettingsClick = { navController.navigate(Route.SettingsScreen) },
                        )
                    }
                }
            }
        }
    }
}
