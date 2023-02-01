package com.example.app123.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.app123.ui.theme.App123Theme
import com.example.app123.ui.theme.GreyDark

@Composable
fun HomeScreen(
    navHostController: NavHostController
) {

    App123Theme(darkTheme = true) {
        Scaffold(
            bottomBar = { BottomNavBar(navController = navHostController)},
            floatingActionButtonPosition = FabPosition.End,
            floatingActionButton = { FloatingActionButton(onClick = {}, backgroundColor = GreyDark){
                Text("+")
            } },
            content = { HomeScreenContent() }
        )
    }
}

@Composable
fun HomeScreenContent () {
    var items by remember {
        mutableStateOf(
            (1..20).map{
                ListItem(
                    title = "Reminder $it",
                    isSelected = false
                )
            }
        )
    }
    LazyColumn(
        modifier = Modifier.fillMaxWidth()
    ) {
        items(items.size) { i ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable {
                        items = items.mapIndexed { j, item ->
                            if (i == j) {
                                item.copy(isSelected = !item.isSelected)
                            } else item
                        }
                    }
                    .padding(5.dp)
                    .clip(shape = RoundedCornerShape(10.dp))
                    .background(MaterialTheme.colors.secondary)
                    .padding(10.dp)
                    .height(50.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = items[i].title, color = Color.Black)
                if(items[i].isSelected) {
                    Icon(
                        painter = rememberVectorPainter(Icons.Filled.CheckCircle),
                        contentDescription = "check icon",
                        tint = MaterialTheme.colors.background,
                        modifier = Modifier.size(20.dp)
                    )
                }
            }
        }
    }
}