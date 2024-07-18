import java.util.*

fun main() {
    // Listas para almacenar las palabras ingresadas
    val words = mutableListOf<String>()

    // Solicitar al usuario que ingrese palabras
    println("Ingrese palabras una por una (escriba 'salir' para terminar):")
    while (true) {
        val input = readlnOrNull()
        if (input.equals("salir", ignoreCase = true)) {
            break
        } else if (!input.isNullOrEmpty()) {
            words.add(input)
        }
    }

    // Contadores para los diferentes tipos de palabras
    var palindromeCount = 0
    var wordsWithTwoVowelsCount = 0
    var wordsStartingWithConsonantCount = 0

    // Procesar cada palabra ingresada
    for (word in words) {
        if (isPalindrome(word)) {
            palindromeCount++
        }
        if (hasAtLeastTwoDistinctVowels(word)) {
            wordsWithTwoVowelsCount++
        }
        if (startsWithConsonant(word)) {
            wordsStartingWithConsonantCount++
        }
    }

    // Mostrar los resultados
    println("Cantidad de palabras palíndromas: $palindromeCount")
    println("Cantidad de palabras con al menos 2 vocales distintas: $wordsWithTwoVowelsCount")
    println("Cantidad de palabras que inician con una consonante: $wordsStartingWithConsonantCount")
}

// Función para verificar si una palabra es un palíndromo
fun isPalindrome(word: String): Boolean {
    val cleanedWord = word.lowercase(Locale.getDefault()).filter { it.isLetterOrDigit() }
    return cleanedWord == cleanedWord.reversed()
}

// Función para verificar si una palabra contiene al menos 2 vocales distintas
fun hasAtLeastTwoDistinctVowels(word: String): Boolean {
    val vowels = setOf('a', 'e', 'i', 'o', 'u')
    val distinctVowels = word.lowercase(Locale.getDefault()).filter { it in vowels }.toSet()
    return distinctVowels.size >= 2
}

// Función para verificar si una palabra inicia con una consonante
fun startsWithConsonant(word: String): Boolean {
    val consonants = "bcdfghjklmnñpqrstvwxyz"
    return word.isNotEmpty() && word[0].lowercaseChar() in consonants
}
