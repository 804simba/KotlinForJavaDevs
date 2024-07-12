An inline function is declare with a keyword inline. The use of inline function enhances the performance of higher order function. 
The inline function tells the compiler to copy parameters and functions to the call site.

Everything in Kotlin is public and final by default

To make a class extendable you use the `open` keyword

Object keyword allows us to define this class and instantiate it at the same time,
by default there can only be one instance of an Object
There are 3 use cases:
- Singletons
- Companion objects
- Object expressions

Scope functions 
[link] https://kotlinlang.org/docs/scope-functions.html#function-selection

- `let` To execute a block of code on a nullable object and perform actions on the result.
```bash
data class User(val name: String, val age: Int)

fun main() {
    val user: User? = User("Alice", 25)
        
    user?.let {
        println("User's name is ${it.name}")
        println("User's age is ${it.age}")
    }
        
    // Transformation example
    val nameLength = user?.let { it.name.length }
    println("Name length: $nameLength")
}

```
- `apply` To initialize or configure an object. The receiver is returned after the block execution.
```bash
data class Car(var brand: String, var model: String)

fun main() {
    val car = Car("", "").apply {
        brand = "Toyota"
        model = "Camry"
    }
    println(car) // Car(brand=Toyota, model=Camry)
}

```
- `run` To execute a block of code on an object and return a result. Suitable for lambdas that combine object initialization and computation.
```bash
data class Config(var host: String, var port: Int)

fun main() {
    val config = Config("localhost", 8080)
    
    val result = config.run {
        port += 1
        "Connecting to $host on port $port"
    }
    
    println(result) // Connecting to localhost on port 8081
}

```

- `with` To call multiple methods on the same object without repeating its name. with is not an extension function and the receiver is passed as an argument.
```bash
data class Book(var title: String, var author: String, var price: Double)

fun main() {
    val book = Book("Kotlin Programming", "JetBrains", 29.99)
    
    val bookInfo = with(book) {
        "Title: $title, Author: $author, Price: $$price"
    }
    
    println(bookInfo) // Title: Kotlin Programming, Author: JetBrains, Price: $29.99
}

```

- `also` To perform additional operations on an object, such as logging or validation, while keeping the object itself intact. The receiver is returned after the block execution.
```bash
data class Person(var name: String, var email: String)

fun main() {
    val person = Person("Bob", "bob@example.com").also {
        println("Creating person: ${it.name}")
        it.email = "new.email@example.com"
    }
    
    println(person) // Person(name=Bob, email=new.email@example.com)
}

```