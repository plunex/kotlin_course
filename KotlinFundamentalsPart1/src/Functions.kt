import utils.printLessonSectionName

var count: Int = 0
fun main(args: Array<String>) {
    printLessonName()
    printLessonName()
    printLessonSectionName("Functions returning nothing")

    val sum = sum(sum(11, 5), 2)
    println("Sum function result is $sum")

    incrementCount()
    incrementCount()
    println(complexMath(3, 7))

}

fun complexMath(a: Int, b: Int): String {
    var output = 0
    output = sum(a, b)
    println(output)
    output = sum(output, output)
    println(output)
    incrementCount()
    output = sum(output, output)
    println(output)
    output = multiply(output, 4)
    println(output)

    return "Output line count :$output"
}

fun multiply(a: Int, b: Int): Int {
    return a * b
}

fun incrementCount() {
    count++
}

fun sum(a: Int, b: Int): Int {
    return a + b;
}

fun printLessonName() {
    println("Functions")
}

