fun main(args: Array<String>) {

    print("please enter your age ")
    val age: Short = readLine()!!.toShort()
    println("Your age is $age")

    print("please enter your name ")
    val name = readLine()
    println("Your name is $name")

    print("Number to add to your age ")
    val number: Short = readLine()!!.toShort()
    println("Your age in $number years will be ${age + number}")

    
}