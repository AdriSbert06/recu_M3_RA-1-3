package RA_1_3.ex_varios

import java.util.Scanner
import kotlin.Array

fun main(){
    val lector: Scanner = Scanner(System.`in`)

    val files = 9
    val columnes = 8
    val matriu: Array<Array<String>> = Array(files) { Array(8) {" "} }

    matriu[0] = arrayOf("R", "R", "R", "R", "R", "R", "R", "R")
    matriu[1] = arrayOf(".", "O", "O", ".", ".", ".", ".", ".")
    matriu[2] = arrayOf(".", ".", ".", ".", ".", ".", ".", ".")
    matriu[3] = arrayOf(".", ".", ".", "O", "O", ".", ".", ".")
    matriu[4] = arrayOf(".", ".", ".", ".", ".", ".", ".", ".")
    matriu[5] = arrayOf(".", "O", "O", ".", "O", "O", "O", "O")
    matriu[6] = arrayOf(".", ".", ".", ".", ".", ".", ".", ".")
    matriu[7] = arrayOf(".", ".", ".", ".", ".", ".", ".", ".")
    matriu[8] = arrayOf("R", "R", "R", ".", ".", ".", ".", ".")

    do {
        var opcio = 0
        print("""
        Volem que l’aplicació permeti les operacions:
        1. Ocupar un seient
        2. Reservar un seient
        3. Alliberar un seient
        4. Reservar una fila
        5. Veure sala
        6. Veure ocupació actual de la sala
        7. Sortir

        """.trimIndent())

        opcio = lector.nextInt()
        if (opcio < 1 || opcio > 7){
            print("Escull una opcio viable")
        }else{
            print("Correcte!")
        }

        when(opcio){
            1 ->{
                println("Has escollit - Ocupar un seient")
                println("Quina fila vols ocupar (1-9): ")
                val filaOcupar = lector.nextInt()

                println("Quina columna (1-8): ")
                val columnaO = lector.nextInt()

                if (filaOcupar < 1 || filaOcupar > 9 || columnaO < 1 || columnaO > 8){
                    println("Error.")
                }else {
                    matriu[filaOcupar -1][columnaO -1] = "O"
                    println("Casella = ocupada")
                }
            }
            2 ->{
                println("Has escollit - Reservar un seient")

                println("Quina fila vols reservar (1-9): ")
                val filaReserva = lector.nextInt()

                println("Quina columna (1-8): ")
                val columnaR = lector.nextInt()

                if (filaReserva < 1 || filaReserva > 9 || columnaR < 1 || columnaR > 8){
                    println("Error.")
                }else {
                    matriu[filaReserva -1][columnaR -1] = "R"
                    println("Casella = reservada")
                }
            }
            3 ->{
                println("Has escollit - Alliberar un seient")
                println("Quina fila vols alliberar (1-9): ")
                val filaLliure = lector.nextInt()

                println("Quina columna (1-8): ")
                val columnaL = lector.nextInt()

                if (filaLliure < 1 || filaLliure > 9 || columnaL < 1 || columnaL > 8){
                    println("Error.")
                }else {
                    matriu[filaLliure -1][columnaL -1] = "O"
                    println("Casella = lliure")
                }
            }
            4 ->{
                println("Has escollit - Reservar una fila")

                println("Quina fila vols reservar (1-9): ")
                val resFila = lector.nextInt()
                val resColumna = 0
                if (resFila < 1 || resFila > 9){
                    println("Error.")
                }else {
                    for (columna in 0 until columnes) {
                        matriu[resFila - 1][columna] = "R"
                    }
                }
            }
            5 ->{
                println("Has escollit - Veure Sala")
                for (fila in matriu.indices){
                    print("Fila: ${fila + 1} ")
                    for (j in matriu[fila].indices){
                        print("${matriu[fila][j]}")
                    }
                    println()
                }
            }

            6 ->{
                var sumaO = 0
                var sumaR = 0
                var sumaL = 0
                println("Has escollit - Veure ocupació actual de la sala")

                for (fila in matriu){
                    for (seient in fila){
                        when(seient){
                            "O"-> sumaO++
                            "R"-> sumaR++
                            "."-> sumaL++
                        }
                    }
                }
                println("Seients ocupats ${sumaO}")
                println("Seients reservats ${sumaR}")
                println("Seients lliures ${sumaL}")

            }

            7->{ print("Sortint...")}
        }
    } while (opcio != 7)
}