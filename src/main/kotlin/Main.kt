package com.sankore

import java.math.BigDecimal

fun main() {
    /*println("Hello World!")

    var letter = """
        Hello World!
        
    """.trimIndent()
    println(letter)
    var anything: Any? = null
    // any, unit, nothing (data types)
    var myArray = arrayOf(true, false)
    myArray.forEach { println(it) }*/

    val myText: String? = null
    myText?.let { println(it) } // Safe call operator
    val newName: String = myText ?: "Simba" // Elvis Operator
    println("Name: $newName")
    val myName: Any = "SIMBA TIMTEZ"
    val firstName = myName as? String // safe cast operator use the safe call operator for the return objects
    println("First Name: $firstName")


    val secondName: String? = "Timothy"

    println(secondName!!) // not-null assertion
    /*
    * All classes are public and final by default in Kt
    * */
    var customerOne = Employee(BigDecimal(30000), true)
    var customerTwo = Employee(BigDecimal(40000))
}

fun printEmployeeSalaries(vararg employees: Employee) {
    employees.forEach { employee -> println("Employee salary: $employee.salary") }
}

class Employee(val salary: BigDecimal, isNigerian: Boolean = true) {

}

data class Car(val name: String, val model: String) {
    // data class is used to store state
    // it comes with a custom impl of the hashcode, toString, and copy functions
    // they also come with a destructuring declaration out of the box
    // all the primary constructor signatures must be var, or val
    // data classes cannot be abstract, sealed or inner classes
}

// in Kotlin there is a notion of a primary constructor which is declared outside of the curly braces
// secondary constructors are declared within the class
class Student constructor(name: String, age: Int) {
    val name: String
    val age: Int
    // initializer block runs when an instance is created and it is used in conjunction with the
    // the primary constructor, it is like the body of the primary constructor
    init {
        this.name = name
        this.age = age
    }
}