package org.example.exercici6.controllers

import RA_5_6.ex_regex_usuari.validarContra
import RA_5_6.ex_regex_usuari.validarEmail
import org.example.exercici6.models.Usuari
import Utils.*

fun crearUsuari(): Usuari {
    println("${CYAN}Començarem a registrar el teu usuari...$RESET")

    // VALIDAR EMAIL
    var email: String
    do {
        email = readWord("Introdueix el teu email:", "Error")
        if (!validarEmail(email)) {
            println(RED + "Email invàlid, torna-ho a intentar." + RESET)
        }
    } while (!validarEmail(email))

    // VALIDAR CONTRASENYA
    var contra: String
    do {
        contra = readWord("Escriu la teva contrasenya:", "Error")
        if (!validarContra(contra)) {
            println(RED + "Contrasenya invàlida, torna-ho a provar." + RESET)
        }
    } while (!validarContra(contra))

    // CREAR OBJECTE USUARI
    val usuari = Usuari(email, contra)
    println(CYAN + "Usuari registrat correctament!" + RESET)
    return usuari
}

fun main() {
    val nouUsuari = crearUsuari()

    println("Dades usuari creat:")
    println("Email: ${nouUsuari.getMail()}")
    println("Contrasenya: ${nouUsuari.getContra()}")
}
