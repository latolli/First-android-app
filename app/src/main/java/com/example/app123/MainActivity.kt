package com.example.app123

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.app123.ui.HomeScreen
import com.example.app123.ui.ProfileScreen
import com.example.app123.ui.login.LoginScreen
import com.example.app123.ui.theme.App123Theme

sealed class Destination(val route: String) {
    object Home: Destination("home")
    object Login: Destination("login")
    object Profile: Destination("profile")
}

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
                    NavigationAppHost(navController = navController)
                }
            }
        }
    }
}

@Composable
fun NavigationAppHost(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "login") {
        composable(Destination.Login.route) {
            LoginScreen(modifier = Modifier.fillMaxSize(), navController)
        }
        composable(Destination.Home.route) {
            HomeScreen(navController)
        }
        composable(Destination.Profile.route) {
            ProfileScreen(navController)
        }
    }
}

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
}