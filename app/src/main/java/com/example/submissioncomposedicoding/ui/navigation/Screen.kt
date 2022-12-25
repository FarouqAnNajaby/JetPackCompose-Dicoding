package com.example.submissioncomposedicoding.ui.navigation

sealed class Screen(val route: String) {
    object Home: Screen("home")
    object About: Screen("about")
    object DetailCountry : Screen("home/{id}") {
        fun createRoute(id: Long) = "home/$id"
    }
}
