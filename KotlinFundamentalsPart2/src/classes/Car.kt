package classes

class Car(val color: String, val make: String) {
    var seatCount = 4

    var rpm = 0
        private set(value) {
            field = value
            println("rpm was updated to $value")
        }

    var rpm1 = 0

    constructor(color: String, make: String, seatCount: Int) : this(color, make) {
        this.seatCount = seatCount
    }

    fun describe(): String {
        val type = if (seatCount <= 4) {
            "sedan"
        } else {
            "mini-van"
        }
        return "$make $type is $color"
    }

    fun pressGasPedal() {
        rpm += 100
    }

    fun pressBreakPedal() {
        rpm -= 20
    }

//    fun getRPM():Int{
//        return rpm
//    }
}