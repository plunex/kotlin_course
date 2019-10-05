package abstractClassAndInterfaces

abstract class PlayerObject(name: String): BaseGameObject(name), WithHealth{

    var powerLevel = 10

    override var health: Int = 100

    open var weapon: Weapon = Weapon("Basic Stick", 10)

}