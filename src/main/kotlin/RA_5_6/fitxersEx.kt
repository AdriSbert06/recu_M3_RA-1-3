package RA_5_6

//ex1
import java.io.File

fun main(){
    ex1()
    ex2()
    ex3()
}

fun ex1() {
    val fitxer = File("textos.txt")

    while (true) {
        print("Introdueix una frase (o enter buit per acabar): ")
        val frase = readln()

        if (frase.isBlank()) break

        fitxer.appendText(frase + "\n")
    }

    println("Frases guardades a textos.txt")
}


//ex2

fun ex2() {
    val fitxer = File("textos.txt")

    while (true) {
        print("Introdueix una frase (enter buit per acabar, @ESBORRA per esborrar): ")
        val frase = readln()

        when {
            frase.isBlank() -> break
            frase == "@ESBORRA" -> {
                fitxer.writeText("")
                println("Fitxer esborrat.")
            }
            else -> {
                fitxer.appendText(frase + "\n")
            }
        }
    }

    println("Operació acabada.")
}


//ex3

fun ex3() {
    val fitxer = File("textos.txt")

    // Mostra tot el contingut
    if (fitxer.exists()) {
        println("\n--- Contingut complet del fitxer ---")
        fitxer.readLines().forEachIndexed { i, linia -> println("${i + 1}: $linia") }
    } else {
        println("El fitxer no existeix.")
        return
    }

    // Mostrar línia X
    print("\nIntrodueix el número de línia que vols veure: ")
    val x = readln().toIntOrNull()

    if (x != null && x > 0) {
        val linies = fitxer.readLines()
        if (x <= linies.size) {
            println("Línia $x: ${linies[x - 1]}")
        } else {
            println("ERROR: El fitxer només té ${linies.size} línies.")
        }
    }

    // Inserir al començament del fitxer
    print("\nEscriu una línia per afegir al començament: ")
    val novaLinia = readln()

    val contingutActual = fitxer.readText()
    fitxer.writeText(novaLinia + "\n" + contingutActual)

    println("Línia afegida al començament.")
}

