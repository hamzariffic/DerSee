@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.dersee

import SplashScreen
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.dersee.ui.theme.DerSeeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            NavHost(navController = navController,
                startDestination = "SplashScreen")
            {
                composable("MainScreen"){
                    MainScreen()
                }
                composable("SplashScreen"){
                    SplashScreen(navController = navController)
                }
            }
        }
    }
}

@Composable
fun MainScreen() {
    Box(modifier = Modifier.fillMaxSize().background(color = Color.Cyan)) {
            TopAppBar(
                title = {
                    Text(text = "DerSee")
                },
                navigationIcon = {
                    IconButton(onClick = { /* TODO: Open drawer */ }) {
                        Icon(imageVector = Icons.Default.Menu, contentDescription = "Menu")
                    }
                }
            )

            //Main screen content
            Spacer(modifier = Modifier.height(56.dp)
                .fillMaxSize())

        Box(modifier = Modifier.fillMaxSize()) {

            Text(
                text = "Welcome to DerSee!",
                modifier = Modifier
                    .align(Alignment.Center)
            )

        }
            FloatingActionButton(
                onClick = { /* TODO: Handle button click */ },
                modifier = Modifier.padding(16.dp).align(alignment = Alignment.BottomEnd).clickable{},
            ) {
                Icon(imageVector = Icons.Default.AddCircle, contentDescription = "Add image")
            }

            // Button in the bottom right corner
    }
}

@Preview
@Composable
fun MainScreenPreview() {
    DerSeeTheme {
        MainScreen()
    }
}
