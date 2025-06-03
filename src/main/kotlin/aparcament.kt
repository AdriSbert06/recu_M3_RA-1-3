package org.example

import java.util.Scanner

fun main(){
    val lector: Scanner = Scanner(System.`in`)
    var opcio: String
    var opcioNum: Int?

    val taula: Array<Array<String>> = Array(4) { Array(3) {" "} }
    taula[0] = arrayOf("O","L","L")
    taula[1] = arrayOf("R","R","L")
    taula[2] = arrayOf("O","L","R")
    taula[3] = arrayOf("L","L","O")


    do {

        //MENU
        println("""
            MENU:
            1. Veure l’estat de totes les places.

            2. Consultar una plaça específica.

            3. Reservar una plaça.

            4. Alliberar una plaça.

            5. Mostrar quantes places hi ha lliures, ocupades i reservades.
            
            6. Sortir
        """.trimIndent())

        //COMPROVAR QUE S'ESCULL UNA OPCIO
        do {
            println("Escull una opcio (num)")
            opcio = lector.nextLine()
            opcioNum = opcio.toIntOrNull()

            if (opcioNum == null || (opcioNum < 1 || opcioNum > 6)) {
                println("ERROR: Has d'introduir un número entre 1 i 6.")
            }else {
                println("OK!")
            }

        } while (opcioNum == null || (opcioNum < 1 || opcioNum > 6))


        when(opcio){

            "1"-> {
                println("Has escollit - Veure l’estat de totes les places.")

                for (i in taula.indices){
                    println("${i + 1}")
                    for (j in taula[i].indices){
                        println("${taula[i][j]}")
                    }
                }
            }

            "2"-> {
                println("Has escollit - Consultar una plaça específica.")

                println("Quina fila vols consultar")
                val fila = lector.nextLine()

                println("Quina columna vols consultar")
                val col = lector.nextLine()

                val placaFila = fila.toIntOrNull()
                val placaColumna = col.toIntOrNull()

                if (placaFila == null || placaColumna == null || placaFila < 1 || placaFila > 6 || placaColumna < 1 || placaColumna > 6) {
                    println("ERROR: Fila o columna fora de rang o no vàlida.")
                } else if (taula[placaFila - 1][placaColumna - 1] == "L") {

                    println("Aqueste plaça esta lliure (L)")
                } else if (taula[placaFila - 1][placaColumna - 1] == "O"){

                    println("Aqueste plaça esta ocupada (O)")
                }else if (taula[placaFila - 1][placaColumna - 1] == "R") {
                    println("Aqueste plaça esta reservada (R)")
                }
            }

            "3"->{
                println("Has escollit - Consultar una plaça específica.")

                println("Quina fila vols reservar")
                val fila = lector.nextLine()

                println("Quina columna vols reservar")
                val col = lector.nextLine()

                val placaFila = fila.toIntOrNull()
                val placaColumna = col.toIntOrNull()

                if (placaFila == null || placaColumna == null || placaFila < 1 || placaFila > 6 || placaColumna < 1 || placaColumna > 6) {
                    println("ERROR: Fila o columna fora de rang o no vàlida.")
                } else {


                    taula[placaFila - 1][placaColumna - 1] = "R"
                    println("Casella modificada: ara està reservada.")
                }
            }

            "4"->{
                println("Has escollit - Alliberar una plaça.")

                println("Quina fila vols alliberar")
                val fila = lector.nextLine()

                println("Quina columna vols alliberar")
                val col = lector.nextLine()

                val placaFila = fila.toIntOrNull()
                val placaColumna = col.toIntOrNull()

                if (placaFila == null || placaColumna == null || placaFila < 1 || placaFila > 6 || placaColumna < 1 || placaColumna > 6) {
                    println("ERROR: Fila o columna fora de rang o no vàlida.")
                } else {
                    taula[placaFila - 1][placaColumna - 1] = "L"
                    println("Casella modificada: ara està lliure.")
                }

            }

            "5" -> {
                println("Has escollit - Comptar l’estat de les places.")

                var lliures = 0
                var ocupades = 0
                var reservades = 0

                for (fila in taula) {
                    for (placa in fila) {
                        when (placa) {
                            "L" -> lliures++
                            "O" -> ocupades++
                            "R" -> reservades++
                        }
                    }
                }

                println("Places lliures: $lliures")
                println("Places ocupades: $ocupades")
                println("Places reservades: $reservades")
            }
        }

    } while (opcio != "6")
}