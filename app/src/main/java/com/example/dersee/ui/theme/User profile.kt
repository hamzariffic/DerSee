@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.dersee.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AccountCircle
import androidx.compose.material.icons.rounded.Create
import androidx.compose.material.icons.rounded.Face
import androidx.compose.material.icons.rounded.Person
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.dersee.ui.theme.DerSeeTheme

class UserProfileActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DerSeeTheme {
                UserProfileScreen()
            }
        }
    }
}

@Composable
fun UserProfileScreen() {
    var userProfile by remember { mutableStateOf(UserProfileData()) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        TopAppBar(
            title = { Text(text = "User Profile") },
            navigationIcon = {
                IconButton(onClick = { /* Handle back navigation */ }) {
                    Icon(imageVector = Icons.Rounded.Face, contentDescription = "Back")
                }
            },
            actions = {
                // Save button to update user profile
                IconButton(onClick = { /* Handle save action */ }) {
                    Icon(imageVector = Icons.Rounded.Create, contentDescription = "Save")
                }
            }
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Avatar Section
        AvatarSection(userProfile.avatar) {
            // Handle avatar selection
        }

        Spacer(modifier = Modifier.height(16.dp))

        // User Information Section
        UserInformationSection(
            userProfile = userProfile,
            onNameChanged = { newName -> userProfile = userProfile.copy(name = newName) },
            onEmailChanged = { newEmail -> userProfile = userProfile.copy(email = newEmail) },
            onPhoneNumberChanged = { newPhoneNumber -> userProfile = userProfile.copy(phoneNumber = newPhoneNumber) }
        )
    }
}

@Composable
fun AvatarSection(avatar: ImageVector, onAvatarSelected: () -> Unit) {
    var isAvatarSelected by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
            .background(MaterialTheme.colorScheme.primary)
            .clickable { onAvatarSelected() }
    ) {
        if (isAvatarSelected) {
            // Load the selected avatar image
            Image(
                painter = rememberVectorPainter(avatar),
                contentDescription = "User Avatar",
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                contentScale = ContentScale.Crop
            )
        } else {
            // Show the "Add a Photo" icon
            Icon(
                imageVector = Icons.Rounded.Person,
                contentDescription = "Add a Photo",
                modifier = Modifier
                    .size(48.dp)
                    .align(Alignment.Center)
            )
        }
    }
}

@Composable
fun UserInformationSection(
    userProfile: UserProfileData,
    onNameChanged: (String) -> Unit,
    onEmailChanged: (String) -> Unit,
    onPhoneNumberChanged: (String) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        // Name Input
        OutlinedTextField(
            value = userProfile.name,
            onValueChange = { onNameChanged(it) },
            label = { Text("Name") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        )

        // Email Input
        OutlinedTextField(
            value = userProfile.email,
            onValueChange = { onEmailChanged(it) },
            label = { Text("Email") },
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Email
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        )

        // Phone Number Input
        OutlinedTextField(
            value = userProfile.phoneNumber,
            onValueChange = { onPhoneNumberChanged(it) },
            label = { Text("Phone Number") },
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Phone
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        )
    }
}

data class UserProfileData(
    val avatar: ImageVector = Icons.Rounded.AccountCircle,
    val name: String = "",
    val email: String = "",
    val phoneNumber: String = ""
)

@Preview(showBackground = true)
@Composable
fun UserProfileScreenPreview() {
    DerSeeTheme {
        UserProfileScreen()
    }
}
