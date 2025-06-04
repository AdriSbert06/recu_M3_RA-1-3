package RA_1_3.ex_varios

import java.util.Scanner

fun main(){
    matrius()
}

fun matrius(){
    val lector: Scanner = Scanner(System.`in`)

    println("Quants alumnes hi ha a l'aula: ")
    val alumnes = lector. nextInt()

    val clase = Array(alumnes){" "}

    for (i in 0 until alumnes) {
        println("Introdueix el nom de l'alumne ${i + 1}: ")
        clase[i] = lector.nextLine()
    }

    val nomA = clase.count { it.startsWith("A", ignoreCase = true) }
    println("Hi ha $nomA alumne/es que comencen amb la lletra 'A'.")

    val nomS = clase.count { it.contains("s", ignoreCase = true) }
    println("Hi ha $nomS alumne/es que contenen la lletra 's'.")

    println("Introdueix una lletra per buscar als noms dels alumnes: ")
    val lletra = lector.nextLine()

    if (lletra.length != 1) {
        println("ERROR: Escriu només una lletra.")
        return
    }

    val comptadorLletra = clase.sumOf { it.count { char -> char.equals(lletra[0], ignoreCase = true) } }
    println("La lletra '$lletra' apareix $comptadorLletra vegades.")

    val conteLletra = clase.filter { it.contains(lletra, ignoreCase = true) }
    println("Els noms que contenen la lletra '$lletra' són: ${conteLletra.joinToString(", ")}")

}
