package utils

fun printLessonSectionName(name: String) {
    println(formatSection(formatSection(name)))
}

fun formatSection(name: String): String {
    return "=====$name====="
}