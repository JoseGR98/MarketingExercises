package com.example.marketingexercisee.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun KotlinSecondScreen(navController: NavHostController) {
    val inputText = remember { mutableStateOf("") }
    val resultText = remember { mutableStateOf("") }

    Column(modifier = Modifier.padding(20.dp)) {
        TextField(
            modifier = Modifier.fillMaxWidth(),
            placeholder = { Text(text = "Insert your numbers (comma-separated)") },
            value = inputText.value,
            onValueChange = { newText ->
                inputText.value = newText
            }
        )
        Button(
            modifier = Modifier
                .padding(top = 10.dp)
                .fillMaxWidth(),
            onClick = {
                val inputArray = parseInput(inputText.value)
                val secondLargest = findSecondLargest2(inputArray)
                if (secondLargest != null) {
                    resultText.value = "Second largest number: $secondLargest"
                } else {
                    resultText.value =
                        "Invalid input. Please enter valid integers separated by commas."
                }
            }
        ) {
            Text(text = "Execute")
        }
        Text(
            text = resultText.value,
            modifier = Modifier.padding(top = 16.dp)
        )

        Button(
            modifier = Modifier.padding(top = 50.dp),
            onClick = {
                navController.popBackStack()
            }
        ) {
            Text(text = "Go Back")
        }
    }
}

fun parseInput(input: String): List<Int> {
    return input.split(",").mapNotNull { it.trim().toIntOrNull() }
}

fun findSecondLargest2(array: List<Int>): Int? {
    if (array.size < 2) {
        return null
    }

    val sortedArray = array.sortedDescending()
    return sortedArray[1]
}