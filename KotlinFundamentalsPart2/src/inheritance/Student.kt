package inheritance

class Student(firstName: String, lastName: String ) :Person(firstName, lastName){

    fun goToSchool(){
        wakeUp()
        walk()
        stop()
        study()
    }

    fun goHome(){
        walk()
        stop()
        sleep()
    }

}