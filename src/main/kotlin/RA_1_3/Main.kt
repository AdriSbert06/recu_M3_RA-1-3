package org.example.RA_1_3

import java.util.Scanner

fun main() {
    val lector: Scanner = Scanner(System.`in`)
    var correcte: Boolean = false

    var opcio: String = ""

    val taula: Array<Array<String>> = Array(5) { Array<String>(6) { "L" } }
    //Si volguesim fer arrayOf seria aixi:
    //taula[0]= arrayOf("L", "L", "L", "O", "L", "O")
    //taula[1]= arrayOf("L", "L", "L", "O", "L", "O")
    //taula[2]= arrayOf("L", "L", "L", "O", "L", "O")
    //taula[3]= arrayOf("L", "L", "L", "O", "L", "O")
    //taula[4]= arrayOf("L", "L", "L", "O", "L", "O")

    do {

        println("""
        1. Mostrar el estado de todos los asientos (matriz).
        2. Consultar si un asiento concreto está libre u ocupado, introduciendo fila y columna.
        3. Ocupar un asiento, si está libre.
        4. Salir.
        """.trimIndent()
        )

        do {
            println("Introdueix una opcio del menú: ")
            correcte = lector.hasNextInt()
            if (correcte == false) {
                println("ERROR: Introdueix una opcio que existeixi al menu")
                lector.nextLine()
            } else {
                opcio = lector.nextLine().lowercase()
            }
        } while (correcte == false)

        when (opcio) {
            "1" -> {
                println("Has escollit la opcio 1:")
                for (i in 0 until taula.size) {
                    print("Fila ${i + 1}:")
                    for (j in taula[i].indices) {
                        print("${taula[i][j]} ")
                    }
                    println()
                }
            }

            "2" -> {
                println("Has escollit la opció 2:")
                println("Quina fila vols consultar (1-5):")
                val filaInput = lector.nextLine()
                println("Quina butaca (columna) vols consultar (1-6):")
                val columnaInput = lector.nextLine()

                val seientFila = filaInput.toIntOrNull()
                val seientColumna = columnaInput.toIntOrNull()

                if (seientFila == null || seientColumna == null || seientFila !in 1..5 || seientColumna !in 1..6) {
                    println("ERROR: Fila o columna fora de rang o no vàlida.")
                } else {
                    val estat = taula[seientFila - 1][seientColumna - 1]
                    if (estat == " L ") {
                        println("El seient està LLIURE.")
                    } else {
                        println("El seient està OCUPAT.")
                    }
                }
            }

            "3" -> {
                println("Has escollit la opció 3: Ocupar un seient")
                println("Introdueix el número de fila (1-5):")
                val filaInput = lector.nextLine()
                println("Introdueix el número de columna (1-6):")
                val columnaInput = lector.nextLine()

                val seientFila = filaInput.toIntOrNull()
                val seientColumna = columnaInput.toIntOrNull()

                if (seientFila == null || seientColumna == null || seientFila !in 1..5 || seientColumna !in 1..6) {
                    println("ERROR: coordenades no vàlides.")
                } else {
                    val estat = taula[seientFila - 1][seientColumna - 1]
                    if (estat == "L") {
                        taula[seientFila - 1][seientColumna - 1] = "O"
                        println("Seient ocupat correctament.")
                    } else {
                        println("El seient ja està ocupat.")
                    }
                }
            }

            "4" -> {
                println("Sortint del programa...")
            }

            else -> {
                println("Opció no vàlida. Torna-ho a intentar.")
            }
        }
    }while(opcio != "4")
}