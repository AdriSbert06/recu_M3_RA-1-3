package RA_5_6

import Utils.RESET
import Utils.WHITE_BRIGHT
import Utils.readInt
import Utils.readWord

fun Glossari() {

    println("""
        *********************MENÚ*********************
        1. Veure tot el glossari
        2. Afegir una entrada al glossari
        3. Modificar una entrada al glossari
        4. Eliminar una entrada del glossari
        5. Sortir
        ***********************************************
    """.trimIndent())

    do {
        val opcio: Int =
            readInt("${WHITE_BRIGHT}Escriu una opció del menu${RESET}", "Error", "Ha de ser un numero", 1, 5)

        when (opcio) {
            1->{
                println("HAS ESCOLLIT LA OPCIÓ 1:")
                opcio1()
            }
            2->{
                println("HAS ESCOLLIT LA OPCIÓ 2:")
                opcio2(llistaGlosariM)
            }
            3->{
                println("HAS ESCOLLIT LA OPCIÓ 3:")
                opcio3(llistaGlosariM)
            }
            4->{
                println("HAS ESCOLLIT LA OPCIÓ 4:")
                opcio4(llistaGlosariM)
            }
            5->{
                println("Sortint...")
            }
        }
    }while (opcio != 5)
}

val llistaGlosari: Map<Int,String> = mapOf(
    1 to "Pelotón → Grupo principal de ciclistas en una carrera. Rodar en el pelotón ayuda a reducir la resistencia al viento.",
    2 to "Escapada → Grupo pequeño o ciclista que se adelanta al pelotón en un intento de ganar ventaja.",
    3 to "Rebufo → Beneficio aerodinámico que se obtiene al rodar detrás de otro ciclista, reduciendo la resistencia al viento.",
    4 to "Sprint → Aceleración máxima en los últimos metros de una etapa o carrera para disputar la victoria.",
    5 to "Gregario → Ciclista cuyo trabajo es ayudar a su líder, protegiéndolo del viento, marcando el ritmo o proporcionándole asistencia.",
    6 to "Líder → Ciclista que encabeza la clasificación general de una carrera y suele contar con el apoyo de su equipo.",
    7 to "Pájara → Estado de agotamiento extremo debido a la falta de energía, que hace que el ciclista pierda rendimiento drásticamente.",
    8 to "Demarraje → Ataque explosivo en carrera con la intención de dejar atrás a los rivales.",
    9 to "Lanzador → Ciclista encargado de preparar el sprint final para su compañero, dándole la mejor posición para lanzar su ataque.",
    10 to "Rodador → Ciclista especializado en mantener alta velocidad en terrenos llanos y en contrarreloj.",
    11 to "Escalador → Ciclista con habilidades destacadas en subidas y puertos de montaña.",
    12 to "Contrarreloj → Modalidad en la que cada ciclista compite en solitario contra el tiempo en un recorrido determinado.",
    13 to "Pico de forma → Momento en el que un ciclista alcanza su mejor estado físico en la temporada.",
    14 to "Desarrollo → Relación entre plato y piñón que define la resistencia del pedaleo y la velocidad alcanzada.",
    15 to "Fuga → Grupo pequeño o ciclista que se adelanta al pelotón en un intento de ganar ventaja."

)
val llistaGlosariM: MutableMap<Int,String> = mutableMapOf()

fun opcio1(){

    for (i in llistaGlosari) {
        llistaGlosariM.put(i.key, i.value)
    }
    println(llistaGlosariM)
}

fun opcio2(glossari: MutableMap<Int, String>) {
    val novaDef = readWord("Escriu la nova entrada per afegir:", "")
    val novaClau = if (glossari.isEmpty()) 1 else glossari.keys.max()!! + 1
    glossari[novaClau] = novaDef
    println("S'ha afegit l'entrada amb clau $novaClau.")
}

fun opcio3(glossari: MutableMap<Int, String>) {
    val clau = readInt("Escriu el número de l'entrada a modificar:", "Ha de ser un número")
    if (glossari.containsKey(clau)) {
        val novaDef = readWord("Escriu el nou text de l’entrada:", "")
        glossari[clau] = novaDef
        println("Entrada modificada correctament.")
    } else {
        println("No existeix cap entrada amb aquesta clau.")
    }
}

fun opcio4(glossari: MutableMap<Int, String>) {
    val clau = readInt("Escriu el número de l'entrada a eliminar:", "Ha de ser un número")
    if (glossari.remove(clau) != null) {
        println("Entrada eliminada correctament.")
    } else {
        println("No existeix cap entrada amb aquesta clau.")
    }
}

fun main(){
    Glossari()
}