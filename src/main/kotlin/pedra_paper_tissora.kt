package org.example

import java.util.Scanner
import kotlin.random.Random

fun main(){
    val lector: Scanner = Scanner(System.`in`)
    var pedra:Int =  0
    var paper:Int =  0
    var tisora:Int =  0

    var empat:Int =  0
    var victoria:Int =  0
    var perdut:Int =  0
    var maquina: Int = 0

    var partidaJugada = 0

    var correcte = false


    println("""
        Has d'escollir entre pedra paper o tisora
    """.trimIndent())

    println("Introdueix la teva opcio: 1 per pedra; 2 per paper; 3 per tisora ")
    var tirada = lector.nextInt()

    var jugadaValida: Boolean = false
    val numPersona = lector.nextInt()
    if (numPersona in 1 until 4) {
        jugadaValida = true
        partidaJugada++

    println("Calculant tirada de la maquina...")
    var ia = Random.nextInt(1,4)

    if (tirada == ia){
        println("EMPAT")
        empat++

    } else if (tirada == 1 && ia == 3){
        println("HAS GUANYAT la mauqina ha tirat ${ia}")
        victoria++
        pedra++
    }else if (tirada == 1 && ia == 2){
        println("HAS PERDUT la mauqina ha tirat ${ia}")
        perdut++
        maquina++

    }else if (tirada == 2 && ia == 1){
        println("HAS GUANYAT la mauqina ha tirat ${ia}")
        paper++
        victoria++
    }else if (tirada == 2 && ia == 3){
        println("Has perdut la mauqina ha tirat ${ia}")
        perdut++
        maquina++

    }else if (tirada == 3 && ia == 1){
        println("HAS PERDUT la mauqina ha tirat ${ia}")
        perdut++
        maquina++
    }else if (tirada == 3 && ia == 2){
        println("Ha guanyat la mauqina ha tirat ${ia}")
        victoria++
        tisora++
    }

        val porcentajeVictoriasJugador = if (partidaJugada > 0) (victoria * 100) / partidaJugada else 0
        val porcentajeVictoriasMaquina = if (partidaJugada > 0) (maquina * 100) / partidaJugada else 0
        val porcentajeEmpates = if (partidaJugada > 0) (empat * 100) / partidaJugada else 0

    println("EL % TOTAL ES:")
        println("""
            Victories: ${porcentajeVictoriasJugador}
            Perdudes: ${porcentajeVictoriasMaquina}
            Empats: ${porcentajeEmpates}
        """.trimIndent())



}