package abstractClassAndInterfaces

interface WithHealth {
    var health: Int
    fun tryDecreaseHealth(powerLevel: Int)
}