package enumsInnerNestedClass

fun main(args: Array<String>) {
    println("Enum Example: ")
    println("Type 1 for Inner example or 2 for Outer class example")

    val input = readLine()?.toInt()?:0
    when(input){
        Options.INNER_EXAMPLE.id -> {
            println("todo: inner ")
            val outer = Outer()
            var inner = outer.Inner()

            outer.printHello()
            inner.printHello()
        }
        Options.NESTED_EXAMPLE.id -> {
            println("todo: nested ")
        }
        else->{
            println("Sorry, please enter a correct option")
            val nested  = Outer.Nested()
            nested.printHello()
        }

    }
}

enum class Options(val id: Int){
    INNER_EXAMPLE(1),NESTED_EXAMPLE(2)
}

class Outer{

    class Nested{
        fun printHello(){
            println("Hello form nested!")
        }
    }
    inner class Inner{
        fun printHello(){
            println("Hello from inner!")
            this@Outer.printHello()
        }
    }

    fun printHello(){
        println("Hello form outer!")
    }
}