package com.example.augustmoringnavigationapp.ui.Research1.screens.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import com.example.augustmoringnavigationapp.data.OpportunityViewmodel
import com.example.augustmoringnavigationapp.navigation.ROUTE_ADD_OPPS
import com.example.augustmoringnavigationapp.navigation.ROUTE_VIEW_OPPS

@Composable
fun HomeScreen(navController: NavHostController) {
    Column(modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally) {
        var context = LocalContext.current

        var productRepository = OpportunityViewmodel(navController,context)

        Text(text = "Welcome to Research 1")

        Button(onClick = {
            navController.navigate(ROUTE_ADD_OPPS)
        }) {
            Text(text = "Add opportunities")
        }

        Button(onClick = {
            navController.navigate(ROUTE_VIEW_OPPS)
        }) {
            Text(text = "View opportunities")
        }


    }
}
