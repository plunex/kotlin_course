package abstractClassAndInterfaces

class Enemy(name: String, override var weapon : Weapon) : PlayerObject(name) {

    override fun interactWith(other: BaseGameObject) {
        if (other is MainPlayer){
            other.tryDecreaseHealth(weapon.powerLevel)
        }
    }

    override fun tryDecreaseHealth(powerLevel: Int) {
        health-=(powerLevel.toFloat()/100f*10f).toInt()
    }

}