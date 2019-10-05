import utils.printLessonSectionName

fun main(args: Array<String>) {
    printLessonSectionName("Nulls")
    val input = readLine()
    if (input!=null){
        println(input.toInt())
    }else{
        println("Your input was null!")
    }

    println("Enter another number")
    println(readLine()?.toInt())

    val arr = arrayOf<String?>("One", null, "Two")
    for (item in arr){
          //  println("length is ${item?.length?:0}")
          //  crash app
            println("length is ${item!!.length}")

    }
}