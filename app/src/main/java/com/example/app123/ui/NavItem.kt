package com.example.app123.ui

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.app123.Destination
import com.example.app123.R

sealed class NavItem(
    @StringRes val title: Int,
    @DrawableRes val icon: Int,
    val navRoute: String
) {
    object Home: NavItem(R.string.home, R.drawable.hut, Destination.Home.route)
    object Profile: NavItem(R.string.profile, R.drawable.user, Destination.Profile.route)
    object Logout: NavItem(R.string.logout, R.drawable.logout, Destination.Login.route)
}