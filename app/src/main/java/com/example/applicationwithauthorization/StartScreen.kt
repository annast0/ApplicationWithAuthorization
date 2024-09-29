package com.example.applicationwithauthorization

import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import kotlinx.coroutines.delay
import com.example.applicationwithauthorization.Onboarding as Onboarding

class StartScreen : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            NavHost(navController = navController, startDestination = "screen_1") {
                composable("screen_1") {
                    SplashScreen {
                        navController.navigate("Onboarding") {
                            popUpTo("screen_1") { inclusive = true }
                        }
                    }
                }
                composable("Onboarding") { Onboarding(navController) }
                composable("Login") { Login(navController) }
                composable("Main") { Main(navController) }
                composable("Profile") { Profile(navController) }
                composable(
                    route = "Photo?photoUri={photoUri}",
                    arguments = listOf(navArgument("photoUri") { type = NavType.StringType })
                ) { backStackEntry ->
                    val photoUri = backStackEntry.arguments?.getString("photoUri")?.let { Uri.parse(it) }
                    Photo(navController = navController, photoUri = photoUri, onDeletePhoto = { /* Удаление фото */ })
                }
                composable("Registration") { Registration(navController) }
                composable("Music") { Music(navController) }
                composable("Menu") { Menu(navController) }
            }
        }
    }


    @Composable
    fun SplashScreen(onTimeout: () -> Unit) {
        var isLoading by remember { mutableStateOf(true) }

        LaunchedEffect(Unit) {
            delay(3000)
            isLoading = false
            onTimeout()
        }

        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.screen),
                contentDescription = "background",
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "",
                modifier = Modifier.align(Alignment.Center)
            )
        }
    }
}


