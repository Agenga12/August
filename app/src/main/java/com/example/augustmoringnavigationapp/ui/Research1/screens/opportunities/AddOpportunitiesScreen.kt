package com.example.augustmoringnavigationapp.ui.Research1.screens.opportunities

import android.content.res.Configuration
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.augustmoringnavigationapp.data.OpportunityViewmodel
import com.example.augustmoringnavigationapp.ui.Research1.AugustMoringNavigationAppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddOpportunitiesScreen(navController: NavHostController,modifier: Modifier = Modifier) {
    Column(modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally) {
        var context = LocalContext.current
        Text(
            text = "Add opportunity",
            fontSize = 30.sp,
            fontFamily = FontFamily.Cursive,
            color = Color.Red,
            modifier = Modifier.padding(20.dp),
            fontWeight = FontWeight.Bold,
            textDecoration = TextDecoration.Underline
        )

        var funderName by remember { mutableStateOf("") }
        var opportunityTitle by remember { mutableStateOf("") }
        var opportunityDeadline by remember { mutableStateOf("") }
        var opportunityDescription by remember { mutableStateOf("") }
        var opportunityAmount by remember { mutableStateOf("") }

        OutlinedTextField(
            value = funderName,
            onValueChange = { funderName = it },
            label = { Text(text = "Funder name *") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
        )

        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            value = opportunityTitle,
            onValueChange = { opportunityTitle = it },
            label = { Text(text = "Opportunity title *") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
        )
        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            value = opportunityDescription,
            onValueChange = { opportunityDescription = it },
            label = { Text(text = "Opportunity description *") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
        )

        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            value = opportunityDeadline,
            onValueChange = { opportunityDeadline = it },
            label = { Text(text = "Opportunity deadline *") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
        )

        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            value = opportunityAmount,
            onValueChange = { opportunityAmount = it },
            label = { Text(text = "Opportunity amount *") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
        )

        Spacer(modifier = Modifier.height(20.dp))

        Button(onClick = {
            var productRepository = OpportunityViewmodel(navController,context)
            productRepository.saveOpportunity(funderName.trim(),opportunityTitle.trim(),
                opportunityDeadline.trim(),opportunityDeadline.trim(),opportunityAmount.trim())


        }) {
            Text(text = "Save opportunity")
        }

        Spacer(modifier = Modifier.height(20.dp))


    }
}


@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_NO)

@Composable
fun AddOpportunitiesScreenPreview() {
    AugustMoringNavigationAppTheme {
        AddOpportunitiesScreen(rememberNavController())
    }
}