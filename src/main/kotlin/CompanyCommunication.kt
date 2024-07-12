package com.sankore

import java.time.Year
// jvm annotations for kotlin: https://www.baeldung.com/kotlin/jvm-annotations

fun main() {
    println(CompanyCommunication.getTagLine())
    println(CompanyCommunication.getCopyRightLine())

    println(CoreUtils.accessCompanyServiceField())
    val core = CoreUtils.coreFactory("Hailey")

    serviceCaller(object: Caller {
        override fun handleCall(number: Int): String = "This is the number $number"
    })

    val department = Department.HR.fullName
    println(Department.HR.fullDetails())

    LaserPrinter.printStuff()

    val range = 1..5
    val charRange = 'a'..'z'
    val stringRange = "ABC".."XYZ"

    for (i in range) {
        println("index = $i")
        jLoop@ for (j in charRange) {
            println("j = $j")
            for (k in 5..10) {
                println("k = $k")
                if (k == 7) {
                    break@jLoop // breaks the names loop
                }
            }
        }
    }
}
/* this is a singleton

Object declarations can extend classes and implement interfaces

Type aliases using `as`

 */
object CompanyCommunication {
    private val currentYear = Year.now().value
    fun getTagLine() = "Our company rocks"
    fun getCopyRightLine() = "Copyright \u00A9 $currentYear Our Company. All rights reserved."
}

/*
* companion objects is similar to static declarations
* allowing us to access properties and functions with creating
* an instance of the class
*
*
* you can use companions to access private constructors, for example impl the
* factory pattern
* */

class CoreUtils private constructor(name: String) {
    companion object HandleServiceLocator {
        private const val SERVICE_NAME = "CompanyCommunication"
        fun accessCompanyServiceField() = SERVICE_NAME
        fun coreFactory(name: String) = CoreUtils(name) // factory pattern with a private constructor
    }
}

/*
* Companion objects are used to create anonymous objects which are also called
* Object expressions in Kotlin just anonymous classes in Java
* */

interface Caller {
    fun handleCall(number: Int): String
}

fun serviceCaller(service: Caller) {
    println("Calling Service via Caller ${service.javaClass.name}, ::: ${service.handleCall(20)}")
}

enum class Department(val fullName: String, private val numberOfEmployees: Int) {
    HR("Human Resources", 40),
    IT("Information Technology", 20);

    fun fullDetails() = "$fullName $numberOfEmployees"
}

// internal modifier allows functions to be only visible within same module,