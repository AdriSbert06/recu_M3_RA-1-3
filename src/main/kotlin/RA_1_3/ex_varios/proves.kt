package RA_1_3.ex_varios

fun comptarParellsISenars() {
    val nums = IntArray(10)

    // TO DO: llegir 10 números
    println("Escriu 10 numeros:")

    for (i in nums.indices){
        println(i +1)
        nums[i] = readln().toInt()
    }

    var parells = 0
    var senars = 0

    for (num in nums){
        if (num % 2 == 0){
            parells++
        }else{
            senars++
        }
    }

    // TO DO: comptar parells i senars

    println("Parells: $parells")
    println("Senars: $senars")
}

fun analitzarFrase() {
    val frase = readLine() ?: ""

    val longitud = frase.length
    val conteHola = frase.lowercase().contains("hola")

    println("Longitud de la frase: $longitud")

    if (conteHola) {
        println("La frase conté la paraula 'hola'.")
    } else {
        println("La frase NO conté la paraula 'hola'.")
    }
}

fun matriuDiagonal() {
    val matriu = Array(3) { IntArray(3) }

    // Llegir valors de la matriu
    println("Introdueix els valors per a la matriu 3x3:")
    for (i in 0..2) {
        for (j in 0..2) {
            print("Introdueix valor per a [$i][$j]: ")
            matriu[i][j] = readLine()?.toIntOrNull() ?: 0
        }
    }

    var sumaDiagonal = 0

    // Calcular la suma de la diagonal principal
    for (i in 0..2) {
        sumaDiagonal += matriu[i][i]
    }

    println("Suma diagonal principal: $sumaDiagonal")
}



fun main(){
    //RA_1_3.ex_varios.comptarParellsISenars()
    //RA_1_3.ex_varios.analitzarFrase()
    matriuDiagonal()
}