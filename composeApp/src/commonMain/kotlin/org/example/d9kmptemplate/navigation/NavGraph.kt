package org.example.d9kmptemplate.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import org.example.game.ui.game.GameScreen

@Composable
fun NavGraph(){
    val navController  = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Screens.GameScreen
    ){
        composable<Screens.GameScreen>{
            GameScreen(
                onClick = {},
                onSearchClick = {},
                onFavoriteClick = {}
            )
        }
    }

}