package RA_1_3.ex_varios

import java.util.Scanner

fun main(){
    array()
}

fun array(){
    val lector: Scanner = Scanner(System.`in`)

    val mida : Int = 1000
    val frequencia : IntArray = IntArray(mida)

    for (i in 1 until mida){
        val numAleatori = (60..200).random()
        frequencia[i] = numAleatori
    }

    var freqMin: Int = 0
    var freqMax: Int = 0
    do {
        do {
            println("Introdueix una freq minima: ")
            freqMin = lector.nextInt()

            if (freqMin < 60 || freqMin > 200){
                println("No pot ser.")
            }

        }while (freqMin < 60 || freqMin > 200)

        do {
            println("Introdueix una freq maxima: ")
            freqMax = lector.nextInt()

            if (freqMax < 60 || freqMax > 200 || freqMax < freqMin){
                println("No pot ser.")
            }
        }while (freqMax < 60 || freqMax > 200)

    }while (freqMin > freqMax)

    println("FreqMin: ${freqMin} - FreqMax: ${freqMax}")

    var dinsInterval = 0
    var sotaInterval = 0
    var sobreInterval = 0

    for (i in frequencia) {
        when {
            i in freqMin..freqMax -> dinsInterval++
            i < freqMin -> sotaInterval++
            else -> sobreInterval++
        }
    }

    val percentatgeDins = (dinsInterval.toDouble() / mida) * 100
    val percentatgeSota = (sotaInterval.toDouble() / mida) * 100
    val percentatgeSobre = (sobreInterval.toDouble() / mida) * 100

    // Mostrar resultats
    println("Quantitat de vegades dins de l'interval: $dinsInterval (${"%.2f".format(percentatgeDins)}%)")
    println("Quantitat de vegades per sota de l'interval: $sotaInterval (${"%.2f".format(percentatgeSota)}%)")
    println("Quantitat de vegades per sobre de l'interval: $sobreInterval (${"%.2f".format(percentatgeSobre)}%)")
}