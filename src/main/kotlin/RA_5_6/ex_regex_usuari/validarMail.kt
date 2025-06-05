package RA_5_6.ex_regex_usuari


import Utils.CYAN
import Utils.RED
import Utils.RESET
import Utils.readWord

/**
 * FUNCIONS PER EL FUNCIONAMENT DEL EMAIL
 */
fun validarEmail(email: String): Boolean{
    var emailCorrecte: Boolean = false
    // Definim l'expressió regular Regex que ens permet validar un email per saber si té format correcte
    val emailRegex: Regex = Regex("^[a-zA-Z0-9._%+-]{3,}@[a-zA-Z0-9.-]{3,}\\.[a-zA-Z]{2,5}$")

    emailCorrecte = email.matches(emailRegex)
    return emailCorrecte
}

fun intputEmail(){
    var email: String
    var emailCorrecte: Boolean = false

    do {
        email = readWord("Escriu el teu email:", "Email invàlid")
        emailCorrecte = validarEmail(email)

        if (!emailCorrecte) {
            println(RED + "ERROR: L'email que has escrit no és vàlid!" + RESET)
        }else{
            println(CYAN + "Gràcies, el teu email '$email' ha estat registrat correctament :)" + RESET)
        }
    }while (!emailCorrecte)
}