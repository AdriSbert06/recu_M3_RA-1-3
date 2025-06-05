package org.example.exercici6.models

class Usuari(
    private var email: String,
    private var contrasenya: String
) {
    fun getMail(): String = email
    fun getContra(): String = contrasenya
    fun setMail(newMail: String) { this.email = newMail }
    fun setContra(newContra: String) { this.contrasenya = newContra }
}
