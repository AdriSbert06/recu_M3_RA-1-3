package RA_5_6.ex_regex_usuari


import Utils.CYAN
import Utils.RED
import Utils.RESET
import Utils.YELLOW_BOLD_BRIGHT
import Utils.readWord

/**
 * FUNCIONS PER EL FUNCIONAMENT DE LA CONTRASENYA
 */

fun validarContra(contra: String) : Boolean {
    var contraCorrecte: Boolean = false
    //val contraRegex: Regex = Regex("^[a-zA-Z0-9._^:+/*%;&]{6,}$") --> JO HO HE FET AIXI, PERO NO FUNCIONAVA BÉ
    val contraRegex: Regex = Regex("^(?=.*\\d)(?=.*[A-Z])(?=.*[._^:+/*%;&]).{6,}$") //AL PREGUNTAR AL CHAT M'HO HA FET AIXI I FUNCIONA
    contraCorrecte = contra.matches(contraRegex)
    return contraCorrecte
}

fun especificacionsContra() {
    var contra: String
    var contraCorrecte: Boolean = false

    println(""" ${YELLOW_BOLD_BRIGHT}
        *********************REQUISITS CONTRASENYA*********************
        1. Mínim un digit
        2. Mínim té un caràcter de puntuació (._^:+/*%;&)
        3. Mínim té un caràcter en majúscula
        4. Mida mínima de 6 caràcters
        ***************************************************************
    ${RESET}""".trimIndent())

    do {
        contra = readWord("Escriu la teva contrasenya:", "Contrasenya invàlida")
        contraCorrecte = validarContra(contra)

        if (!contraCorrecte) {
            println(RED + "ERROR: La contrasenya que has escrit no és vàlida!" + RESET)
        }else{
            println(CYAN + "Gràcies, la teva contrasenya '$contra' ha estat registrada correctament :)" + RESET)
        }
    }while (!contraCorrecte)
}