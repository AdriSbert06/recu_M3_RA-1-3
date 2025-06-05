package RA_5_6

class RepetitException (message: String): Exception(message)
class ForaRangException (message: String): Exception(message)

/* Aquesta es una altre forma de fer una excepció
 class RepetitException : Exception {
 constructor(): this ("Missatge d'error") { }
 constructor(missatge: String): super(missatge) { }
 }
 */

class LlistaDeNoms {
    private val llista: ArrayList<String> = arrayListOf()

    constructor() {}

    fun getNumeroElements(): Int{
        return this.llista.size
    }

    fun afegirNom(nom: String){
        try {
            if (llista.contains(nom)){
                throw RepetitException ("El nom ${nom} no es troba en la llista")
            }
            llista.add(nom)

        }catch (e: RepetitException ){
            println(e.message)
        }
    }

    fun insertarNomEnPosicio(index: Int, nom: String){
        try {
            if (index < 0 || index > llista.size){
                throw ForaRangException("Es troba fora de rang")
            }
            llista.add(index, nom)

        }catch (e: ForaRangException ) {
            println(e.message)
        }
    }

    fun obtenirNom(index: Int): String {
        if (index < 0 || index >= llista.size) {
            throw ForaRangException("La posició $index és fora de rang.")
        }
        return llista[index]
    }

    fun eliminarNom(index: Int){
        if (index < 0 || index >= llista.size) {
            throw ForaRangException("La posició $index no es pot esborrar.")
        }
        llista.removeAt(index)
    }

    fun imprimirNoms(): String {
        var resultat = ""
        for (i in 0 until llista.size) {
            resultat += "$i: ${llista[i]}\n"
        }
        return resultat
    }

    fun buscarNom(nom: String): String? {
        val iterator = llista.iterator()
        var resultat = ""
        var posicio = 0
        var trobat = false

        while (iterator.hasNext()) {
            val actual = iterator.next()
            if (actual.contains(nom, ignoreCase = true)) {
                resultat += "$posicio: $actual\n"
                trobat = true
            }
            posicio++
        }

        return if (trobat) resultat else null
    }

}