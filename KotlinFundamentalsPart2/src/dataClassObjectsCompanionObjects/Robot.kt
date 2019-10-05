package dataClassObjectsCompanionObjects

open class Robot(val robotType: Int) {
    companion object{
        var robotCount : Int = 0
        const val robot_type_builder = 0
        const val robot_type_fighter = 1
        const val robot_type_pilot = 2

        fun formatName(robot: Robot): String{
            val typeName = when(robot.robotType){
                robot_type_builder ->{
                    "b"
                }
                robot_type_fighter ->{
                    "f"
                }
                robot_type_pilot ->{
                    "p"
                }
                else->{
                    "x"
                }
            }
            return "Robot_${robot.id}_$typeName"
        }
    }

    private var id: Int = robotCount ++

    open fun getName():String{
        return formatName(this)
    }

}