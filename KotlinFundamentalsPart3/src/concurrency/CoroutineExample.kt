package concurrency

import kotlinx.coroutines.experimental.async
import kotlinx.coroutines.experimental.delay
import kotlinx.coroutines.experimental.launch
import kotlinx.coroutines.experimental.runBlocking
import java.util.concurrent.atomic.AtomicBoolean


fun main(args: Array<String>) {
    runBlocking {
        val timerBool = startTimer()
        val sum = (0..1_000_000).map {
            async {
                doWork()
            }
        }.sumBy { it.await().age }

        val average = sum / 1_000_000
        timerBool.set(false)
        println("Average age is $average")
    }
}

suspend fun startTimer(): AtomicBoolean {
    val boolean = AtomicBoolean(true)
    var count = 0
    launch {
        do {
            delay(1000)
            println(count++)
        } while (boolean.get())
    }
    return boolean
}

suspend fun doWork(): Human {
    delay(2000)
    return Human("Ollie", (0..90).shuffled().last())
}

data class Human(val name: String, val age: Int)