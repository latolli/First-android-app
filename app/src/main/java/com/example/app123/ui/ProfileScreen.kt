package com.example.app123.ui

import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.example.app123.ui.theme.App123Theme

@Composable
fun ProfileScreen(
    navHostController: NavHostController
) {
    App123Theme(darkTheme = true) {
        Scaffold(
            bottomBar = { BottomNavBar(navController = navHostController) }
        ) {
            Text(text = "Wow this is profile screen!")
        }
    }
}