package classes

fun main(args: Array<String>) {
    val car = Car("Green", "Honda")
    println(car.describe())

    val mainVan = Car("Grey","Dodge", 7)
    println(mainVan.describe())

    car.pressGasPedal()
    car.pressGasPedal()
    car.pressBreakPedal()


}