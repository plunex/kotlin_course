package inheritance

class Athlete(firstName: String, lastName: String) : Person(firstName, lastName) {

    var isRunning: Boolean = false
        private set

    override fun walk() {
        run()
    }

    private fun run() {
        isMoving = true
        isRunning = true
    }

    override fun stop() {
        super.stop()
        isRunning = false
    }
}