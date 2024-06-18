package org.unifacs

import Calculator
import CalculatorService
import java.util.Scanner

fun main() {
    val scanner = Scanner(System.`in`)
    val calculator = Calculator()
    val calculatorService = CalculatorService(calculator)

    println("Welcome to the Calculator Service!")
    println("Please enter two numbers:")

    print("Enter the first number: ")
    val a = scanner.nextDouble()

    print("Enter the second number: ")
    val b = scanner.nextDouble()

    println("Choose an operation:")
    println("1. Addition")
    println("2. Subtraction")
    println("3. Multiplication")
    println("4. Division")
    println("5. Power")
    println("6. Square root (only first number will be considered)")
    println("7. Modulus")

    print("Enter your choice: ")
    val choice = scanner.nextInt()

    val result = when (choice) {
        1 -> calculatorService.performAddition(a, b)
        2 -> calculatorService.performSubtraction(a, b)
        3 -> calculatorService.performMultiplication(a, b)
        4 -> calculatorService.performDivision(a, b)
        5 -> calculatorService.performPower(a, b)
        6 -> calculatorService.performSqrt(a)
        7 -> calculatorService.performModulus(a, b)
        else -> {
            println("Invalid choice.")
            return
        }
    }

    println("The result is: $result")
}