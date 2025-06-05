package RA_1_3

import java.util.*

fun main() {
    val lector = Scanner(System.`in`)
    val taula = arrayOf(
        arrayOf("8:00 - 10:00", "Mat", "Cat", "His", "Mat", "Fis"),
        arrayOf("10:00 - 12:00", "Ang", "Qui", "EF", "Bio", "Fil"),
        arrayOf("12:00 - 14:00", "Bio", "Ang", "Fis", "Qui", "Cat"),
        arrayOf("14:00 - 16:00", "Tec", "Bio", "Cat", "EF", "Ang")
    )
    val dies = arrayOf("Hora", "Dilluns", "Dimarts", "Dimecres", "Dijous", "Divendres")

    do {
        println("\n${dies.joinToString(" | ")}")
        println("---------------------------------------------------------------")
        for (fila in taula) {
            println(fila.joinToString(" | "))
        }

        println(
            """
            ---------------------------------------------
                Horari Escolar
            ---------------------------------------------
                1. Escollir un dia de la setmana
                2. Escollir una franja horària
                3. Escollir una assignatura
                4. Sortir
            ---------------------------------------------
        """.trimIndent()
        )

        print("Introdueix una opció del menú: ")
        val opcio = lector.nextLine().trim()

        when (opcio) {
            "1" -> {
                print("Introdueix un dia de la setmana (Dilluns, Dimarts, Dimecres, Dijous, Divendres): ")
                val dia = lector.nextLine().trim().lowercase()
                val columna = when (dia) {
                    "dilluns", "d" -> 1
                    "dimarts" -> 2
                    "dimecres" -> 3
                    "dijous" -> 4
                    "divendres" -> 5
                    else -> -1
                }

                if (columna == -1) {
                    println("Dia invàlid.")
                } else {
                    println("Assignatures del $dia:")
                    for (i in taula.indices) {
                        println("${taula[i][0]} → ${taula[i][columna]}")
                    }
                }
            }

            "2" -> {
                print("Introdueix una franja horària (exacta com a l'horari, ex: 10:00 - 12:00): ")
                val franja = lector.nextLine().trim()
                val fila = taula.indexOfFirst { it[0] == franja }
                if (fila == -1) {
                    println("Franja no trobada.")
                } else {
                    println("Assignatures de la franja $franja:")
                    for (i in 1..5) {
                        println("${dies[i]} → ${taula[fila][i]}")
                    }
                }
            }

            "3" -> {
                print("Introdueix una assignatura (Mat, Cat, His, Ang, Qui, EF, Bio, Fis, Fil, Tec): ")
                val assignatura = lector.nextLine().trim().capitalize()
                println("L'assignatura $assignatura es troba a:")
                var trobada = false
                for (fila in taula) {
                    for (i in 1..5) {
                        if (fila[i].equals(assignatura, ignoreCase = true)) {
                            println("${fila[0]} - ${dies[i]}")
                            trobada = true
                        }
                    }
                }
                if (!trobada) println("No s'ha trobat l'assignatura.")
            }

            "4" -> println("Sortint del programa. Adéu!")
            else -> println("Opció no vàlida.")
        }

    } while (opcio != "4")
}
