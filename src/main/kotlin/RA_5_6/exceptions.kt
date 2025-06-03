package RA_5_6

fun main(){
    //llegirNumero()
    //dividirNums()
    inputMail()

}
// 1
class OutOfRangeException(message: String): Exception(message)

fun llegirNumero(){
    try {
        val numero = readInt("Introdueix un numero del 1 al 10:", "")
        if (numero < 1 || numero > 10) {
            throw OutOfRangeException("El numero esta fora de rang")

        }else{
            println("Has introduït el número correcte: $numero")
        }
    }catch (e: OutOfRangeException){
        println(e.message)
        e.printStackTrace()

    }
}



// 2

class ArithmeticException(message: String): Exception(message)

fun dividirNums(){
    try {
        val num1 = readInt("Escriu el num1", "")
        val num2 = readInt("Escriu el num2", "")

        if (num2 == 0){
            throw ArithmeticException("No pot ser aquesta divisió")
        }

        val resultat = num1 / num2
        println(resultat)

    }catch (e: ArithmeticException){
        println(e.message)
        e.printStackTrace()
    }
}

// 3

class ValidarCorreu(message: String): Exception(message)

fun validarMail(correu: String): Boolean {
        val mail: Regex = Regex("^[a-zA-Z0-9]+@[a-z]+.[a-z]{2,}$")
        return correu.matches(mail)
}

fun inputMail(){
    try {
        val correu = readSentence("Escriu el teu correu","")
        if (!validarMail(correu)){
            throw ValidarCorreu("No es pot validar el correu")
        }
        println("Correu valid $correu")
    }catch (e: ValidarCorreu){
        println(e.message)
        e.printStackTrace()
    }
}