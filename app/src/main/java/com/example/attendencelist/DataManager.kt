package com.example.attendencelist

object DataManager {  // object = singleton?
    val students = mutableListOf<Student>()


    init {
        createMockData()
    }


    fun createMockData() {
        students.add(Student("David", "APP22", true))
        students.add(Student("Lois", "APP22"))
        students.add(Student("Laura", "APP22"))
        students.add(Student("Susan", "APP22"))
        students.add(Student("Jacob", "APP22", true))
        students.add(Student("Per", "APP22"))

    }

    // Share preferences
}