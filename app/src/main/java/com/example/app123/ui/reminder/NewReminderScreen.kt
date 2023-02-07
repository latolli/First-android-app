package com.example.app123.ui.reminder

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.app123.ui.BottomNavBar
import com.example.app123.ui.theme.App123Theme
import com.example.code.domain.entity.Payment
import dagger.hilt.android.lifecycle.HiltViewModel
import java.time.LocalDateTime

@Composable
fun NewReminderScreen(
    modifier: Modifier,
    navHostController: NavHostController,
    viewModel: ReminderViewModel
){
    App123Theme(darkTheme = true) {
        Scaffold(
            bottomBar = { BottomNavBar(navController = navHostController) },
            content = { NewReminderScreenContent(viewModel = viewModel, modifier = modifier) }
        )
    }
}

@Composable
fun NewReminderScreenContent(viewModel: ReminderViewModel, modifier: Modifier) {
    val title = remember { mutableStateOf("") }
    val amount = remember { mutableStateOf("") }

    Column (modifier = modifier.padding(20.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally)
    {
        Spacer(modifier = Modifier.height(30.dp))

        OutlinedTextField(
            value = title.value,
            modifier = Modifier.fillMaxWidth(),
            onValueChange = { title.value = it },
            label = { Text(text = "Title") },
            shape = RoundedCornerShape(corner = CornerSize(50.dp))
        )

        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            value = amount.value,
            modifier = Modifier.fillMaxWidth(),
            onValueChange = { amount.value = it },
            label = { Text(text = "Amount") },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number
            ),
            shape = RoundedCornerShape(corner = CornerSize(50.dp))
        )

        Spacer(modifier = Modifier.height(30.dp))

        Button(
            onClick = {
                     viewModel.savePayment(
                         Payment(
                             title = title.value,
                             categoryId = 1,
                             amount = amount.value.toDouble(),
                             date = LocalDateTime.now()
                         )
                     )
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            shape = RoundedCornerShape(corner = CornerSize(50.dp))
        ) {
            Text(text = "Save reminder")
        }
    }
}