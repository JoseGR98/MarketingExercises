package com.example.marketingexercisee.ui

fun main() {
    val numbersList = listOf(5,5,5,5,5,5)
    val second = searchSecondLargestNumber(numbersList)

    println("Numbers entered: $numbersList\nThe second largest number is $second")
}

private fun searchSecondLargestNumber(numbersArray: List<Int>): Int {
    var largestNum = 0
    var secondLargestNum = 0

    if (numbersArray.size < 2) {
        println("Array needs at least 2 numbers")
        return 0
    }

    for (number in numbersArray) {
        if (number > largestNum) {
            secondLargestNum = largestNum
            largestNum = number
        } else if (number > secondLargestNum && number != largestNum) {
            secondLargestNum = number
        }
    }

    if (secondLargestNum == 0) {
        println("Not second Largest Number found")
        return 0
    }
    return secondLargestNum
}
