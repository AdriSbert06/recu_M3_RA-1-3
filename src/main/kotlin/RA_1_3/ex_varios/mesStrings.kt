package RA_1_3.ex_varios

import java.util.Scanner

fun main(){
    strings()
}

fun strings(){
    val lector: Scanner = Scanner(System.`in`)

    print("Introdueix un text: ")
    val text = lector.nextLine()

    val comodin= "#"
    var hashtag = 0

    for (i in text){
        if (i == '#'){
            hashtag++
            println(i +1)
        }
        var hashtags:String= lector.toString()
        println("S'han trobat ${hashtags} hashtags")
        for (hashtag in hashtags) {
            println(hashtag)
        }
    }


}