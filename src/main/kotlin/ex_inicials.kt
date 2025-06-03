package org.example

import java.util.Scanner

fun main() {
    val lector: Scanner = Scanner(System.`in`)

//    Algoritme que mostra els números del 10 al 0, i al final, BOOOOOM!!
    for (i in 10 downTo 0){
        println("${i}")
    }
    println("BOOM")
//    Algoritme que demana una paraula a l'usuari i la mostra 100 vegades.
    println("Escriu una paraula:")
    val paraula = lector.nextLine()

    for (i in 0..100 -1){
        println("${i}. ${paraula}")

    }
//    Algoritme que demana l'edat i mostra els anys que aquest ha anat complint (1, 2, 3...).

    println("Escriu la teva edat: ")
    val edat = lector.nextInt()

    for (i in 1..edat){
        println("${i}, ")
    }

//    Algoritme que demana un número, i mostra seqüencialment des d'aquest número fins al 0 (inclòs).

    println("Escriu un numero:")
    val num = lector.nextInt()

    for (i in num downTo 0){
        println("${i}, ")

    }

//    Algoritme que mostra la taula de multiplicar del 3.


//    Algoritme que demana un número i mostra per pantalla la seva taula de multiplicar.

//
//
//    Extres que podeu fer:
//    Fer menús principals amb opció de sortida als programes usant el when() i do-while()
//        Afegir control d’input de dades: domini de valors
//    Fer ús de variables constants de lectura per al text dels menús, màxim i mínims, etc


}