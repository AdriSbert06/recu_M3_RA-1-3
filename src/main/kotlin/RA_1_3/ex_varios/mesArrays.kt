package RA_1_3.ex_varios

import java.util.Scanner

fun main(){
    arrays()
}

fun arrays(){
    val lector: Scanner = Scanner(System.`in`)

    val llistaTemp: Int = 8760
    val temperatures: IntArray = IntArray(llistaTemp)
    var valorEnter: Boolean = false

    for (i in 1 until llistaTemp) {
        val numAleatori = (-20..45).random()
        temperatures[i] = numAleatori
        valorEnter = true
    }

    do {
        var opcio = 0
        print("""
        1. Veure les dades.
        2. Mostrar la temperatura mitjana.
        3. Mostrar quants cops s’ha estat per sota de 0º i el % que això ha suposat del total.
        4. Mostrar quants cops s’ha estat per sobre de 30º i el % que això ha suposat del total.
        5. Mostrar el % de cops que s’ha estat:
            i. entre -20º i -5º (temperatures extremes)
            ii. entre -4º i +4º (molt fred)
            iii. entre +5º i +14º (fred)
            iv. entre +15º i +29º (rang idoni)
            v. entre +30º i +45º (molta calor)
        6. Demanar un rang a l’usuari (Tmin i Tmax) i mostrar el % que això ha suposat del total (sobra dir que s’haurà de fer un control de l’entrada de les dades per part de l’usuari, no?).
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
                print("Has escollit - 1. Veure les dades.")
                for (i in 0 until temperatures.size) {

                    print(temperatures[i].toString() + "º, ")
                }
                println()
            }
            2 ->{
                var sumTemperatures = 0
                var quantTemp = 0
                var tempMitjana = 0

                for (j in 0 until temperatures.size) {
                    sumTemperatures += temperatures[j]
                    quantTemp++
                }
                if (quantTemp > 0) {
                    val tempMitjana = sumTemperatures / quantTemp
                    println("La temperatura mitjana és: $tempMitjana")
                }
            }
            3 ->{
                var perSota = 0
                for (x in 0 until llistaTemp){
                    if (temperatures[x] < 0){
                        perSota++
                    }
                    println("Temperatures per sota de 0: ${perSota}")
                }
            }
            4 ->{
                var perSobre = 0
                for (x in 0 until llistaTemp){
                    if (temperatures[x] > 30){
                        perSobre++
                    }
                    println("Temperatures per sota de 0: ${perSobre}")
                }
            }
            5 ->{
                var tempExtr = 0
                var moltFred = 0
                var fred = 0
                var rangIdoni = 0
                var moltaCalor = 0

                println("Has escollit l'opció 5:")

                for (i in 0 until llistaTemp) {
                    when (temperatures[i]) {
                        in -20..-5 -> tempExtr++
                        in -4..4 -> moltFred++
                        in 5..14 -> fred++
                        in 15..29 -> rangIdoni++
                        in 30..45 -> moltaCalor++
                    }
                }
                val percentExtremes = (tempExtr.toDouble() / llistaTemp) * 100
                val percentMoltFred = (moltFred.toDouble() / llistaTemp) * 100
                val percentFred = (fred.toDouble() / llistaTemp) * 100
                val percentRangIdoni = (rangIdoni.toDouble() / llistaTemp) * 100
                val percentMoltaCalor = (moltaCalor.toDouble() / llistaTemp) * 100

                println("Percentatge de temperatures en cada rang:")
                println("Temperatures extremes (-20º a -5º): ${tempExtr} cops (${"%.2f".format(percentExtremes)}%)")
                println("Molt fred (-4º a 4º): ${moltFred} cops (${"%.2f".format(percentMoltFred)}%)")
                println("Fred (5º a 14º): ${fred} cops (${"%.2f".format(percentFred)}%)")
                println("Rang idoni (15º a 29º): ${rangIdoni} cops (${"%.2f".format(percentRangIdoni)}%)")
                println("Molta calor (30º a 45º): ${moltaCalor} cops (${"%.2f".format(percentMoltaCalor)}%)")
            }

            6 ->{
                var tempMin: Int = 0
                var tempMax: Int = 0
                println("Has escollit l'opció 6:")

                do {
                    println("Introdueix una temperatura mínima (Tmin): ")
                    tempMin = lector.nextInt()
                    if (tempMin < -20 || tempMin > 45) {
                        println("ERROR: El valor introduït per Tmin no és correcte. Ha de ser entre -20 i 45.")
                    }
                } while (tempMin < -20 || tempMin > 45)

                do {
                    println("Introdueix una temperatura màxima (Tmax): ")
                    tempMax = lector.nextInt()
                    if (tempMax < -20 || tempMax > 45) {
                        println("ERROR: El valor introduït per Tmax no és correcte. Ha de ser entre -20 i 45.")
                    } else if (tempMax <= tempMin) {
                        println("ERROR: La temperatura màxima ha de ser més gran que la mínima. Torna-ho a provar.")
                    }
                } while (tempMax < -20 || tempMax > 45 || tempMax <= tempMin)

                println("La temperatura mínima és: $tempMin i la temperatura màxima és: $tempMax")

                var countRangUsuari = 0
                for (i in 0 until llistaTemp) {
                    if (temperatures[i] in tempMin..tempMax) {
                        countRangUsuari++
                    }
                }

                val percentRangUsuari = (countRangUsuari.toDouble() / llistaTemp) * 100

                println("Percentatge de temperatures dins del rang $tempMin a $tempMax:")
                println("$countRangUsuari cops (${"%.2f".format(percentRangUsuari)}%)")
            }

            7 ->{ print("Sortint...")}
        }
    } while (opcio < 1 || opcio > 7 || opcio == 7)

}
