package apps.game

import javafx.application.Application
import javafx.scene.input.KeyCode
import javafx.scene.input.KeyEvent
import javafx.scene.paint.Color
import javafx.scene.shape.Circle
import javafx.stage.Stage
import kotlinx.coroutines.experimental.delay
import kotlinx.coroutines.experimental.launch
import tornadofx.*

fun main(args: Array<String>) {
    Application.launch(GameApp::class.java)
}

const val screenWidth = 700.0
const val screenHeight = 500.0

class GameApp : App(MainView::class) {
    override fun start(stage: Stage) {
        super.start(stage)
        stage.width = screenWidth
        stage.height = screenHeight
    }
}


class MainView : View("Game") {
    val initialRadius = 10.0
    lateinit var player: Circle
    lateinit var food: Circle
    val keysMap = hashMapOf<KeyCode, Boolean>()
    override val root = hbox {
        canvas {
            player = circle {
                radius = initialRadius
                fill = Color.DARKVIOLET
            }
            food = circle {
                radius = initialRadius
                fill = Color.LIGHTGREEN
                translateX = strokeWidth / 2
                translateY = screenHeight / 2
            }
        }
        addEventFilter(KeyEvent.ANY) {
            keysMap[it.code] = it.eventType == KeyEvent.KEY_PRESSED
        }
    }

    fun respawnFood(){
        val randX = (Math.random()* screenWidth/2)-food.translateX
        val randY = (Math.random()* screenHeight/2)-food.translateY
        food.translateX+=randX
        food.translateY+=randY

    }

    fun update() {
        var dX = 0.0
        var dY = 0.0

        if (keysMap[KeyCode.UP] == true) dY -= 10.0
        if (keysMap[KeyCode.DOWN] == true) dY += 10.0
        if (keysMap[KeyCode.LEFT] == true) dX -= 10.0
        if (keysMap[KeyCode.RIGHT] == true) dX += 10.0

        if(player.boundsInParent.intersects(food.boundsInParent)){
            respawnFood()
            player.radius+=food.radius/2
        }
        player.translateX+=dX
        player.translateY+=dY

    }

    override fun onDock() {
        super.onDock()
        root.requestFocus()
        launch {
            while (true) {
                update()
                delay(30)
            }
        }
    }
}