package generics

fun main(args: Array<String>) {
    val cup = Cup<Coffee>(Coffee(6f), 7f)
    val anotherCup = Cup(Tea(8f), 10f)


}

class Cup<T:Liquid>(val content: T, volume: Float)

class Coffee(volume: Float): Liquid(volume)

class Tea(volume: Float): Liquid(volume)

class Candy

abstract class Liquid(var volume: Float)