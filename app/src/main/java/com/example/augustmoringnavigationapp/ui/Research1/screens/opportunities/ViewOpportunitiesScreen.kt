package com.example.augustmoringnavigationapp.ui.Research1.screens.opportunities

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.augustmoringnavigationapp.data.OpportunityViewmodel
import com.example.augustmoringnavigationapp.models.Opportunity
import com.example.augustmoringnavigationapp.navigation.ROUTE_UPDATE_OPPS


@Composable
fun ViewOpportunitiesScreen(navController:NavHostController) {
    Column(modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally) {

        var context = LocalContext.current
        var productRepository = OpportunityViewmodel(navController, context)


        val emptyOpportunityState = remember { mutableStateOf(Opportunity("","","","","","")) }
        var emptyOpportunitiesListState = remember { mutableStateListOf<Opportunity>() }

        var opportunities = productRepository.viewOpportunities(emptyOpportunityState, emptyOpportunitiesListState)


        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "All opportunities",
                fontSize = 30.sp,
                fontFamily = FontFamily.Cursive,
                color = Color.Red)

            Spacer(modifier = Modifier.height(20.dp))

            LazyColumn(){
                items(opportunities){
                    OpportunityItem(
                        funderName = it.funderName,
                        opportunityTitle = it.opportunityTitle,
                        opportunityDescription = it.opportunityDescription,
                        opprtunityDeadline = it.opportunitydeadline,
                        opportunityAmount = it.opportunityAmount,
                        id = it.id,
                        navController = navController,
                        productRepository = productRepository
                    )
                }
            }
        }
    }
}


@Composable
fun OpportunityItem(funderName:String, opportunityTitle:String,opportunityDescription:String, opprtunityDeadline:String,
                    opportunityAmount:String, id:String,
                    navController:NavHostController, productRepository:OpportunityViewmodel) {

    Column(modifier = Modifier.fillMaxWidth()) {
        Text(text = funderName)
        Text(text = opportunityTitle)
        Text(text = opportunityDescription)
        Text(text = opprtunityDeadline)
        Text(text = opportunityAmount)
        Button(onClick = {
            productRepository.deleteOpportunity(id)
        }) {
            Text(text = "Delete")
        }
        Button(onClick = {
            navController.navigate(ROUTE_UPDATE_OPPS+"/$id")
        }) {
            Text(text = "Update")
        }
    }
}

