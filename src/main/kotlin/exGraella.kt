package org.example

import java.util.Scanner

fun main(){
    val lector: Scanner = Scanner(System.`in`)
    var correcte: Boolean = false

    var opcio: String = ""

    val taula: Array<Array<String>> = Array(4) { Array(4) {" "} }
    taula[0] = arrayOf("vermell", "verd", "blau", "vermell")
    taula[1] = arrayOf("blau", "verd", "blau", "verd")
    taula[2] = arrayOf("vermell", "verd", "blau", "verd")
    taula[3] = arrayOf("vermell", "blau", "blau", "vermell")

    do {
        println("""
            1.Pintar una casella amb un color.
            2.Esborrar una casella (tornar-la a "buit").
            3.Mostrar tota la graella.
            4.Sortir
        """.trimIndent())

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
            "1" ->{
                println("PINTAR UNA CASELLA")


                println("Quina fila vols pintar (1-4):")
                val filaInput = lector.nextLine()
                println("Quina butaca (columna) vols pintar (1-4):")
                val columnaInput = lector.nextLine()

                val seientFila = filaInput.toIntOrNull()
                val seientColumna = columnaInput.toIntOrNull()

                if (seientFila == null || seientColumna == null || seientFila !in 1..5 || seientColumna !in 1..6) {
                    println("ERROR: Fila o columna fora de rang o no vàlida.")
                } else {
                    println("Quin color vols: vermell, blau, verd")
                    val colorButaca = lector.nextLine()

                    taula[seientFila - 1][seientColumna - 1] = colorButaca
                    println("Casella modificada: ara és de color ${colorButaca}.")
                }
            }

            "2"->{
                println("ESBORRAR CASELLA")
                println("Quina fila vols esborrar (1-4):")
                val filaInput = lector.nextLine()
                println("Quina butaca (columna) vols esborrar (1-4):")
                val columnaInput = lector.nextLine()

                val seientFila = filaInput.toIntOrNull()
                val seientColumna = columnaInput.toIntOrNull()

                if (seientFila == null || seientColumna == null || seientFila !in 1..5 || seientColumna !in 1..6) {
                    println("ERROR: Fila o columna fora de rang o no vàlida.")
                } else {
                    val esborrar = "buit"

                    taula[seientFila - 1][seientColumna - 1] = esborrar
                    println("La casella ${taula[seientFila - 1][seientColumna - 1]} s'ha esborrat")
                }
            }

            "3"->{
                println("MOSTRAR GRAELLA")
                for (i in taula.indices) {
                    println("Fila ${i +1}: ")
                    for (j in taula[i].indices) {
                        println("${taula[i][j]}\t")
                    }
                    println()
                }
            }

            "4" ->{
                println("Sortint...")
            }
        }

    } while (opcio != "4")
}