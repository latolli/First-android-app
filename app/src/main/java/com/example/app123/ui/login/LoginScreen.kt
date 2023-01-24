package com.example.app123.ui.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import com.example.app123.R

@Composable
fun LoginScreen(
    modifier: Modifier
) {
    val username = remember { mutableStateOf("") }
    val password = remember { mutableStateOf("") }

    Column (modifier = modifier.padding(20.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally)
    {
        /*
        Image(painter = painterResource(id = R.drawable.ic_launcher_foreground),
            contentDescription = "Login image"
        )
        */

        Icon(
            painter = rememberVectorPainter(Icons.Filled.Person),
            contentDescription = "person icon",
            modifier = Modifier.fillMaxWidth().size(100.dp)
        )

        Spacer(modifier = Modifier.height(30.dp))

        OutlinedTextField(value = username.value,
            modifier = Modifier.fillMaxWidth(),
            onValueChange = { text -> username.value = text},
            label = { Text(text = "Username") },
            shape = RoundedCornerShape(corner = CornerSize(50.dp))
        )

        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(value = password.value,
            modifier = Modifier.fillMaxWidth(),
            onValueChange = {text -> password.value = text},
            label = { Text(text = "Password") },
            visualTransformation = PasswordVisualTransformation(),
            shape = RoundedCornerShape(corner = CornerSize(50.dp))
        )

        Spacer(modifier = Modifier.height(20.dp))

        Button(onClick = { /*TODO*/ },
            modifier = Modifier.fillMaxWidth().height(50.dp),
            shape = RoundedCornerShape(corner = CornerSize(50.dp))) {
            Text(text = "Login")
        }
    }
}