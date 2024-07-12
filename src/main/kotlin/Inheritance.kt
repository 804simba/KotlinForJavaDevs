package com.sankore

fun main() {
    val laserPrinter = LaserPrinter("HP-321", 40)
    println(laserPrinter.printModel())
}

const val PRICE_OF_PRINTER = 1300.34

abstract class Inheritance(val model: String) {
    open fun printModel() = println("This is model $model")
    abstract fun bestSellingPrice(): Double
}

open class LaserPrinter(model: String, numberOfPages: Int) : Inheritance(model) {
    final override fun printModel() { // subclasses will not be able to override this final member function
        println("This Laser printer model is a $model")
    }

    override fun bestSellingPrice(): Double = PRICE_OF_PRINTER

    companion object {
        fun printStuff() {
            println("This Laser printer is printing")
        }
    }
}

class SpecialLaserPrinter(model: String, numberOfPages: Int) : LaserPrinter(model, numberOfPages) {
}

open class Animal(name: String) {
    val name: String = "Lion"
//    constructor(animalName: String) {
//        this.name = animalName
//    }
}

class Dog : Animal {
    constructor(name: String, numberOfLegs: Int) : super(name)
}

interface Constants {
    var number: Int
    var age: Int
}

class RandomValues : Constants {
    override var number: Int
        get() = TODO("Not yet implemented")
        set(value) {}
    override var age: Int
        get() = TODO("Not yet implemented")
        set(value) {}
}