import java.util.Scanner

fun main() {
    val lector = Scanner(System.`in`)

    print("Introdueix un text: ")
    val text = lector.nextLine()

    val paraules = text.split(" ")
    val hashtags = mutableListOf<String>()

    for (paraula in paraules) {
        if (paraula.startsWith("#") && paraula.length > 1) {
            hashtags.add(paraula)
        }
    }

    println("S'han trobat ${hashtags.size} hashtags:")
    for (hashtag in hashtags) {
        println(hashtag)
    }
}

/*
fun main() {
    val lector = Scanner(System.`in`)

    print("Introdueix un text: ")
    val text = lector.nextLine()

    val comodin = '#'
    var hashtagCount = 0
    val hashtagsEncontrats = mutableListOf<Char>()

    for (c in text) {
        if (c == comodin) {
            hashtagCount++
            hashtagsEncontrats.add(c)
        }
    }

    println("S'han trobat $hashtagCount hashtags:")
    for (h in hashtagsEncontrats) {
        println(h)
    }
}*/