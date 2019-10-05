

fun main(args: Array<String>){
    var a : Int
    var b : Int

    println("Please enter a value")
    a = readLine()!!.toInt()


    println("Please enter a second value")
    b = readLine()!!.toInt()

    // Arithmetic operation
    val sum = a + b
    val product = a * b
    val modulus = a % b

    println("Sum of $a and $b is $sum")
    println("Product of $a and $b is $product")
    println("Modulus of $a and $b is $modulus")

    println("Assignment")
    //Assignment
    a+=b
    println("a is now $a")

    a /= 2
    println("a is now $a")

    println("Increment")
    //Increment/Decrement
    ++a
    println("a is now $a")

    --a
    println("b is now $a")

    println("Unary")
    var likesCandy = true
    println("Do you like candy : $likesCandy")
    likesCandy = !likesCandy
    println("I dont like candy : $likesCandy")

    //Comparison
    println("Comparison")
    println("a > b : ${a > b}")
    println("a < b : ${a < b}")
    println("a >= b : ${a >= b}")
    println("a == b : ${a == b}")

    //Logical
    println("Logical")
    val c = true;
    val d = true;
    println("c or d is or a > b ${c || d || a>b}")
    println("c and d is and a is less than b : ${c && d && a<b}")


}