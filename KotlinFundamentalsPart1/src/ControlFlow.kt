import utils.printLessonSectionName

fun main(args: Array<String>) {
    println("Please type one of the following [if, while, d/w, b/c]")

    val userInput = readLine()
    when (userInput) {
        "if" -> first()
        "while" -> second()
        "d/w" -> third()
        "b/c" -> fourth()
        else -> println("Unknown statement")
    }

}


fun first() {
    printLessonSectionName("IF statement example")
    println("Please enter a number")
    val input = readLine()!!
    if (validateInput(input)) {
        val intInput = input.toInt()
        if (intInput > 0) {
            println("You entered a positive number")
        } else if (intInput < 0) {
            println("You entered a negative number")
        } else {
            println("You entered zero")
        }

    } else {
        println("Your input is not valid number!")
    }
}

fun second() {
    printLessonSectionName("WHILE statement example")
    println("Please enter a number between 1 and 5")
    val rnd = (1..5).shuffled().last()
    var userInput = readLine()!!.toInt()
    while (userInput != rnd) {
        println("Try again")
        userInput = readLine()!!.toInt()
    }
    println("You guessed $rnd!")
}

fun third() {
    printLessonSectionName("DO WHILE loop example")
    val rnd = (1..5).shuffled().last()
    var userInput: Int
    do {
        println("Please enter a number between 1 and 5")
        userInput = readLine()!!.toInt()
    } while (userInput != rnd)
    println("You guessed $rnd!")
}

fun fourth() {
    printLessonSectionName("BREAK CONTINUE example")
    println("Think of a number between 1 and 5!")

    while (true) {
        println("Ready? [y/n]")
        if (readLine() == "y") {
            break
        }
    }

    while (true) {
        val rnd = (1..5).shuffled().last()
        println("is $rnd correct? [y/n]")
        if (readLine() == "y") {
            break
        }
    }
    println("That was fun")
}


fun validateInput(input: String): Boolean {
    val parsedInput = input.toIntOrNull()
    return parsedInput != null
}