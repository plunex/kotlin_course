package abstractClassAndInterfaces

fun main(args: Array<String>) {
    println("Enter your name")
    val name = readLine().toString()
    val mainPlayer = MainPlayer(name)
    var level = 1
    do {

        println("Level: $level: ")
        val powerLevel = (level..mainPlayer.powerLevel).shuffled().last()*level
        val enemy = Enemy("Troll", Weapon("Stone", powerLevel ))
        println("Player encountered a level : $powerLevel troll ")

        enemy.interactWith(mainPlayer)
        mainPlayer.interactWith(enemy)
        println("Player's health decreased to : ${mainPlayer.health} ")

        val gameObject = getRandomGameObject(level)
        mainPlayer.interactWith(gameObject)

        if(gameObject is HealthPotion){
            println("... then player found a potion!")
        }else{
            println("... then player found a weapon!")

        }

        println("Ready for next level")
        readLine()

        level++
    } while (mainPlayer.health > 0)
    println("You lost on level $level")
}


fun getRandomGameObject(level: Int): BaseGameObject {
    return if((0..1).shuffled().shuffled().last() == 0){
       HealthPotion((0..100).shuffled().last())
    }else{
        Weapon("Power Stick", (1..10).shuffled().last()*level)
    }
}