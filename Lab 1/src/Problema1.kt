fun main() {
    while (true) {
        // Solicitar al usuario que ingrese un número decimal
        print("Ingrese un número en base decimal (o 'salir' para terminar): ")
        val input = readlnOrNull()

        // Verificar si el usuario quiere salir
        if (input.equals("salir", ignoreCase = true)) {
            println("¡Hasta luego!")
            break
        }

        // Convertir la entrada a un número entero
        val decimal = input?.toIntOrNull()

        // Validar que el número ingresado sea válido
        if (decimal != null) {
            // Convertir el número decimal a binario
            val binary = decimalToBinary(decimal)
            println("El número $decimal en binario es: $binary")
        } else {
            println("Por favor, ingrese un número válido.")
        }
    }
}

// Función para convertir un número decimal a binario
fun decimalToBinary(number: Int): String {
    if (number == 0) {
        return "0"
    }

    var num = number
    val binary = StringBuilder()

    while (num > 0) {
        val remainder = num % 2
        binary.append(remainder)
        num /= 2
    }

    return binary.reverse().toString()
}
