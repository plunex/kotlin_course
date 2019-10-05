package inheritance

open class Person(val firstName: String, val lastName: String) {
    private var knowledge: Int = 0
    private var resting = false
    var isMoving: Boolean = false
        protected set

    open fun walk() {
        isMoving = true
    }

    open fun stop() {
        isMoving = false
    }

    fun study() {
        knowledge++
    }

    fun sleep() {
        resting = true
        isMoving = false
    }

    fun wakeUp() {
        resting = false
        isMoving = true
    }

}