package com.example.app123.ui

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.app123.ui.theme.GreyDark
import com.example.app123.ui.theme.OrangeLight

@Composable
fun BottomNavBar(
    navController: NavController
){
    val navItems = listOf(NavItem.Logout, NavItem.Home, NavItem.Profile)
    
    BottomNavigation (
        backgroundColor = GreyDark
            ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route
        navItems.forEach { item ->
            BottomNavigationItem(
                icon = { Icon(painter = painterResource(id = item.icon), contentDescription = "navbar item")},
                label = { Text(text = stringResource(id = item.title))},
                selectedContentColor = OrangeLight,
                unselectedContentColor = Color.White.copy(alpha = 0.8f),
                selected = currentRoute == item.navRoute,
                onClick = { navController.navigate(item.navRoute) })
        }
    }
}