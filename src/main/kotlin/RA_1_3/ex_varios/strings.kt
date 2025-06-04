package RA_1_3.ex_varios

import java.util.Scanner

fun main(){
    string()
}
fun string(){
    val lector: Scanner = Scanner(System.`in`)
    println("Introdueix una frase: ")
    val frase = lector.nextLine()

    println("Quina paraula vols buscar: ")
    val paraulaBuscada = lector.next()

    val fraseNeta = frase.replace(Regex("[.,!?;:]"), " ")
    val paraulesSeparades = fraseNeta.split(" ").filter { paraula -> paraula.isNotEmpty() }

    var contador = 0
    for (paraula in paraulesSeparades) {
        if (paraula.equals(paraulaBuscada, ignoreCase = true)) {
            contador++
        }
    }

    println("La paraula '$paraulaBuscada' ha aparegut $contador vegada/es.")
}