package com.example.dersee.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.BlendMode.Companion.Screen
import androidx.compose.ui.input.pointer.PointerEventPass
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.splashscreen.SplashScreen
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.dersee.MainScreen
import com.example.dersee.R
import com.example.dersee.ui.theme.DerSeeTheme
import kotlinx.coroutines.delay

class SplashScreen : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DerSeeTheme {
                SplashContent()
            }
        }
    }
}


//Composable to handle Navigation
@Composable
fun Navigation() {

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screen.Splash.route) {

        composable(Screen.Splash.route) {
            SplashScreen(navController = navController)
        }

        composable(PointerEventPass.Main.route) {
            MainScreen(navController = navController)
        }

        composable(Screen.UserProfile.route) {
            UserProfileScreen(navController = navController)
        }
    }
}

@Composable
fun SplashContent(navController: NavController) {
    LaunchedEffect(key1 = true) {
        delay(3000L)
        // Handle navigation or any other logic after the splash screen delay
        navController.navigate(PointerEventPass.Main.route) {
            popUpTo(Screen.Splash.route) {
                inclusive = true
            }
        }
        SplashContent()
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.primary)
    ) {
        // Display the ocean waves image
        Image(
            painter = painterResource(id = R.drawable.oceania),
            contentDescription = "Protect our Planet",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )

        // Text or logo overlay
        Text(
            text = "DerSee",
            modifier = Modifier
                .wrapContentSize(Alignment.TopCenter)
                .padding(16.dp),
            style = MaterialTheme.typography.displayLarge,
            color = MaterialTheme.colorScheme.onBackground,
        )
    }
}

@Preview(showBackground = true)
@Composable
fun SplashPreview() {
    DerSeeTheme {
        SplashContent()
    }
}