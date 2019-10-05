package inheritance

fun main(args: Array<String>) {
    var people = mutableListOf<Person>()
    val simplePerson = Person("Joe", "Smith")
    val student = Student("Bob", "Doe")
    val athlete = Athlete("Tom", "Smith")

    people.add(simplePerson)
    people.add(student)
    people.add(athlete)

    for (person in people) {
        when (person) {
            is Student -> println("${person.firstName} is a Student")
            is Athlete -> println("${person.firstName} is a an Athlete")
            else -> println("${person.firstName} is a regular person")
        }
        person.walk()
        println(if (person.isMoving) "Person is moving" else "person is stopped")
        if (person is Athlete) {
            println(if (person.isMoving) "Person is running" else "person is stopped")
        } else {
            println(if (person.isMoving) "Person is running" else "person is stopped")
        }
        person.stop()
    }


}