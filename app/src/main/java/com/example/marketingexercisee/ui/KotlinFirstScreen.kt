package com.example.marketingexercisee.ui

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun KotlinFirstScreen(context: Context, navController: NavHostController) {
    var array: IntArray
    val inputText = remember { mutableStateOf("") }

    Column(modifier = Modifier.padding(20.dp)) {
        Text(text = "Find the second largest number")
        TextField(
            modifier = Modifier.fillMaxWidth(),
            placeholder = { Text(text = "Insert your numbers") },
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
                array = inputProvided(inputText)
                val value = findSecondLargest(array)
                if (value == 0)
                    Toast.makeText(context, "Invalid input :(", Toast.LENGTH_SHORT).show()
                else {
                    Toast.makeText(context, "$value", Toast.LENGTH_SHORT).show()
                }
            }
        ) {
            Text(text = "Find it!")
        }

        Button(
            modifier = Modifier
                .padding(top = 50.dp)
                .fillMaxWidth(),
            onClick = {
                navController.navigate("kotlinSecondScreen")
            }
        ) {
            Text(text = "Go to New Screen")
        }

    }
}

fun inputProvided(input: MutableState<String>): IntArray {
    if (input.value.isNotEmpty()) {
        val numberStrings = input.value.split(",")
        val numbers = IntArray(numberStrings.size)
        return try {
            for (i in numberStrings.indices) {
                numbers[i] = numberStrings[i].trim().toInt()
            }
            numbers
        } catch (e: NumberFormatException) {
            println("Invalid input. Please enter valid integers separated by commas.")
            IntArray(0)
        }
    } else {
        println("No input provided.")
        return IntArray(0)
    }
}

fun findSecondLargest(array: IntArray): Int {
    if (array.size < 2) {
        return 0
        //throw IllegalArgumentException("Array must have at least two elements")
    }

    var largestNum = Int.MIN_VALUE
    var secondLargestNum = Int.MIN_VALUE

    for (number in array) {
        if (number > largestNum) {
            secondLargestNum = largestNum
            largestNum = number
        } else if (number > secondLargestNum && number != largestNum) {
            secondLargestNum = number
        }
    }

    if (secondLargestNum == Int.MIN_VALUE) {
        return 0
        //throw IllegalArgumentException("There is no second largest element")
    }

    return secondLargestNum
}
