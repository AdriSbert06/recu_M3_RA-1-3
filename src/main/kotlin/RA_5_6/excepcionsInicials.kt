package RA_5_6

import java.util.Scanner

fun main() {
    val lector: Scanner = Scanner(System.`in`)
    var num1: Int = 0
    var num2: Int = 0

    try {
        println("Escriu un num1: ")
        num1 = lector.nextInt()
    } catch (e: NumberFormatException) {
        println("Error")
        println(e.message)
    }

    try {
        println("Escriu un num2: ")
        num2 = lector.nextInt()
    }catch (e: NumberFormatException){
        println("Error")
        println(e.message)
    }

    try {
        val resultat = num1 / num2
        println("El resultat és: $resultat")
    } catch (e: ArithmeticException) {
        println("Error: no es pot dividir entre zero.")
        println(e.message)
    }

}
