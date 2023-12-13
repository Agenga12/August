package com.example.augustmoringnavigationapp.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.augustmoringnavigationapp.ui.Research1.screens.about.AboutScreen
import com.example.augustmoringnavigationapp.ui.Research1.screens.home.HomeScreen
import com.example.augustmoringnavigationapp.ui.Research1.screens.login.LoginScreen
import com.example.augustmoringnavigationapp.ui.Research1.screens.opportunities.AddOpportunitiesScreen
import com.example.augustmoringnavigationapp.ui.Research1.screens.opportunities.UpdateOpportunitiesScreen
import com.example.augustmoringnavigationapp.ui.Research1.screens.opportunities.ViewOpportunitiesScreen
import com.example.augustmoringnavigationapp.ui.Research1.screens.signup.SignupScreen

@Composable
fun AppNavHost(modifier: Modifier = Modifier,
               navController: NavHostController = rememberNavController(),
               startDestination:String = ROUTE_HOME){
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestination){
        composable(ROUTE_LOGIN){
            LoginScreen(navController)
        }
        composable(ROUTE_SIGNUP){
            SignupScreen(navController)
        }
        composable(ROUTE_HOME){
            HomeScreen(navController)
        }
        composable(ROUTE_ABOUT){
            AboutScreen(navController)
        }
        composable(ROUTE_ADD_OPPS){
            AddOpportunitiesScreen(navController)
        }
        composable(ROUTE_VIEW_OPPS){
            ViewOpportunitiesScreen(navController)
        }
        composable(ROUTE_UPDATE_OPPS+"/{id}"){ passedData->
            UpdateOpportunitiesScreen(navController,passedData.arguments?.getString("id")!!)
        }

    }

}