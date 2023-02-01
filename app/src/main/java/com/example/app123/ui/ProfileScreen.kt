package com.example.app123.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.app123.Destination
import com.example.app123.R
import com.example.app123.ui.theme.App123Theme
import com.example.app123.ui.theme.GreyLight
import com.example.app123.ui.theme.OrangeBasic
import com.example.app123.ui.theme.OrangeLight

@Composable
fun ProfileScreen(
    navHostController: NavHostController,
    modifier: Modifier
) {
    App123Theme(darkTheme = true) {
        Scaffold(
            bottomBar = { BottomNavBar(navController = navHostController) },
            content = { ProfileScreenContent(modifier) }
        )
    }
}

@Composable
fun ProfileScreenContent(modifier: Modifier) {
    val username = stringResource(id = R.string.username)
    val password = stringResource(id = R.string.password)
    
    Column (modifier = modifier.padding(20.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally)
    {
        Spacer(modifier = Modifier.height(100.dp))

        Image(painter = painterResource(id = R.drawable.orangeuser),
            contentDescription = "Login image",
            modifier = Modifier
                .fillMaxWidth()
                .size(64.dp)
        )

        Spacer(modifier = Modifier.height(100.dp))

        Text(
            text = "Username:   $username",
            modifier = Modifier
                .fillMaxWidth()
                .background(color = GreyLight)
                .border(BorderStroke(2.dp, OrangeBasic), shape = RoundedCornerShape(corner = CornerSize(50.dp)))
                .padding(20.dp)
        )
        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "Email:          example@gmail.com",
            modifier = Modifier
                .fillMaxWidth()
                .background(color = GreyLight)
                .border(BorderStroke(2.dp, OrangeBasic), shape = RoundedCornerShape(corner = CornerSize(50.dp)))
                .padding(20.dp)
        )
        Spacer(modifier = Modifier.height(20.dp))

        Button(onClick = {},
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            shape = RoundedCornerShape(corner = CornerSize(50.dp))) {
            Text(text = "Edit")
        }
    }
}
