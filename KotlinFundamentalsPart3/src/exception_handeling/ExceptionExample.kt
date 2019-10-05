package exception_handeling

import java.lang.NumberFormatException

fun main(args: Array<String>) {
    println("please enter a number: ")
    var userNum : Int? = null
    try {
         userNum = multiply(readLine()?.toInt())
    }catch (e:NumberFormatException){
        println("Pleases enter number only")
    }
    println("You entered $userNum")
}

fun multiply(inNum:Int?):Int{
    return (inNum?:0)*2
}