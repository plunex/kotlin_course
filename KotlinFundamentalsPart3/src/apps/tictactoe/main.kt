package apps.tictactoe

import javafx.application.Application
import javafx.scene.Group
import javafx.scene.paint.Color
import javafx.scene.shape.Circle
import tornadofx.*
import javax.swing.text.html.CSS

fun main(args: Array<String>) {
    Application.launch(TicTacToe::class.java, *args)
}

var currentPlayer = CellState.CROSS

class TicTacToe : App(MainView::class)

class MainView : View("Tic Tac Toe") {
    override val root = gridpane {
        (1..3).forEach {
            row {
                (1..3).forEach {
                    opcr(this, tornadofx.find(TicTacToeCell::class).root, {})
                }
            }
        }
    }
}

enum class CellState {
    EMPTY, CROSS, CIRCLE
}

class TicTacToeCell : ItemFragment<CellState>() {
    lateinit var cross: Group
    lateinit var circle: Circle
    var cellState = CellState.EMPTY
    set(value) {
        field = value
        cross.isVisible = value == CellState.CROSS
        circle.isVisible = value == CellState.CIRCLE

    }

    override val root = button {
        prefWidth = 80.0
        prefHeight = 80.0
        graphic = group {
            rectangle {
                prefWidth = 80.0
                prefHeight = 80.0
                fill = Color.WHITE

            }
            cross = group {
                line {
                    startX = 10.0
                    startY = 10.0
                    endX = 70.0
                    endY = 70.0
                    stroke = Color.BLUE
                    strokeWidth = 4.0

                }
                line {
                    startX = 10.0
                    startY = 70.0
                    endX = 70.0
                    endY = 10.0
                    stroke = Color.BLUE
                    strokeWidth = 4.0
                }
                isVisible = false
            }
            circle = circle {
                centerX = 40.0
                centerY = 40.0
                radius = 30.0
                stroke = Color.RED
                fill = Color.WHITE
                strokeWidth = 4.0
                isVisible = false
            }
        }
        setOnMouseClicked {
            if (cellState == CellState.EMPTY){
                cellState = currentPlayer
                currentPlayer = when(currentPlayer){
                    CellState.EMPTY -> CellState.EMPTY
                    CellState.CROSS -> CellState.CIRCLE
                    CellState.CIRCLE -> CellState.CROSS
                }
            }
        }
    }
}