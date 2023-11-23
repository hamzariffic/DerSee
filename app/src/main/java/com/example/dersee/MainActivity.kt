package com.example.dersee

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.dersee.ui.theme.DerSeeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DerSeeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainScreen()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .fillMaxHeight()
            .padding(16.dp)
    ) {
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

        // Content of your main screen
        Spacer(modifier = Modifier.height(16.dp)
            .fillMaxSize())

        Text(
            text = "Welcome to DerSee!",
            style = MaterialTheme.typography.labelMedium,
            modifier = Modifier.padding(16.dp)
        )

        // more UI components

        // Button in the bottom right corner
        Row(
            modifier = Modifier
                .size(width = 400.dp, height = 100.dp)
                .fillMaxHeight()
                .padding(16.dp),
            horizontalArrangement = Arrangement.End,
            verticalAlignment = Alignment.Bottom
        ) {
            FloatingActionButton(
                onClick = { /* TODO: Handle button click */ },
                modifier = Modifier.padding(16.dp)
            ) {
                Icon(imageVector = Icons.Default.AddCircle, contentDescription = "Add image")
            }
        }
    }
}

@OptIn(ExperimentalComposeUiApi::class)
@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    DerSeeTheme {
        MainContentr()
    }
}
