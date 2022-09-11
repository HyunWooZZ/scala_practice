// method syntax
//def methodName(param1: Type1, param2: Type2): ReturnType =
//  body
//end methodName  // this is optional!

def add(a: Int, b: Int): Int = a + b

// calling the method!
val x = add(1, 2)

val x = List(1, 2, 3)
x.size
x.contains(1)

x.map(_ * 10)

def addThenDouble(a: Int, b: Int): Int =
  val sum = a + b
  sum * 2

addThenDouble(1, 1)

def addThenDouble(a: Int, b: Int): Int = (a + b) * 2
addThenDouble(1, 1)

class Dog:
  def speak() = println("Woof")

val d = new Dog
d.speak()

class Animal:
  private def breathe() = println("I`m breathing")
  def walk() =
    breathe()
    println("I`m walking")

class Cat extends Animal:
  // this method can`t compile because private method can`t override
  override def breathe() = println("Yo, i`m totally breathing")


class Animal:
  private def breathe() = println("I’m breathing")
  def walk() =
    breathe()
    println("I’m walking")
  protected def speak() = println("Hello?")

class Cat extends Animal:
  override def speak() = println("Meow")

val cat = new Cat
cat.walk()
cat.speak()
cat.breathe()   // won’t compile because it’s private

//
//The protected setting means:
//
//  The method (or field) can be accessed by other instances of the same class
//It is not visible by other code in the current package
//It is available to subclasses


// main method!
