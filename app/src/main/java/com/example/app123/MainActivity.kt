package com.example.app123

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.app123.ui.HomeScreen
import com.example.app123.ui.ProfileScreen
import com.example.app123.ui.login.LoginScreen
import com.example.app123.ui.reminder.NewReminderScreen
import com.example.app123.ui.reminder.ReminderViewModel
import com.example.app123.ui.theme.App123Theme
import com.example.code.domain.repository.PaymentRepository
import dagger.hilt.android.AndroidEntryPoint

sealed class Destination(val route: String) {
    object Home: Destination("home")
    object Login: Destination("login")
    object Profile: Destination("profile")
    object NewReminder: Destination("newreminder")
}

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @SuppressLint("CoroutineCreationDuringComposition")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            App123Theme (darkTheme = true){
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val navController = rememberNavController()
                    val viewModel = viewModel<ReminderViewModel>()
                    NavigationAppHost(navController = navController, viewModel = viewModel)
                }
            }
        }
    }
}

@Composable
fun NavigationAppHost(navController: NavHostController, viewModel: ReminderViewModel) {
    NavHost(navController = navController, startDestination = "login") {
        composable(Destination.Login.route) {
            LoginScreen(modifier = Modifier.fillMaxSize(), navHostController = navController)
        }
        composable(Destination.Home.route) {
            HomeScreen(navHostController = navController)
        }
        composable(Destination.Profile.route) {
            ProfileScreen(navHostController = navController, modifier = Modifier)
        }
        composable(Destination.NewReminder.route) {
            NewReminderScreen(modifier = Modifier.fillMaxSize(), navHostController = navController, viewModel = viewModel)
        }
    }
}
/*
@Composable
fun Greeting(name: String) {
    Text(text = "Helou mai frend $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    App123Theme {
        Greeting("Android")
    }
}*/