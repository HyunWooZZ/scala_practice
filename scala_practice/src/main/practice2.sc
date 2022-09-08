// review all object and class
// apply method can make factory method!

class Person:
  var name = ""
  var age = 0
  override def toString: String = f"My name is ${name}, and my age is ${age} years old"

object Person:
  // a one-arg factory method
  def apply(name: String): Person =
    var p = new Person
    p.name = name
    p // return p instance!

  // two-arg factory method
  def apply(name: String, age: Int): Person =
    var p = new Person
    p.name = name
    p.age = age
    p

end Person

val hyunwoo = Person("hyunwoo")
val fred = Person("Fred", 29)

println(fred.name)

// abstract class prior scala3
abstract class Pet(name: String):
  def greeting: String
  def age: Int

  override def toString: String = s"My name is $name, I, say $greeting, and i'm $age"

class Dog(name: String, var age: Int) extends Pet(name):
  val greeting = "Woof"

val d = Dog("Fibo", 1)

trait Pet(name: String):
  def greeting: String
  def age: Int

  override def toString: String = s"My name is $name, I, say $greeting, and i'm $age"

class Dog(name: String, var age: Int) extends Pet(name):
  val greeting = "Wooff hyun"

val d: Dog = Dog("abc", 10)

// Enums!
enum Crustsize:
  case Small, Medium, Large

enum CrustType:
  case Thin, Thick, Regular

enum Topping:
  case Cheese, Pepproni, BlackOlives, GreenOlives, Onions

import Crustsize.*

val currentCrustSize = Small

if currentCrustSize != Large then println("Wrong")

if (currentCrustSize == Large)
  println("Large")

currentCrustSize match
  case Small => println("Small")
  case Medium => println("Medium")
  case Large => println("Large")

enum Color(val rgb: Int):
  case Red extends Color(0xFF0000)
  case Green extends Color(0x00FF00)
  case Blue extends Color(0x0000FF)

enum Planet(mass: Double, radius: Double):
  private final val G = 6.67300E-11
  def surfaceGravity = G * mass / (radius * radius)
  def surfaceWeight(otherMass: Double) =
    otherMass * surfaceGravity

  case Mercury extends Planet(3.303e+23, 2.4397e6)
  case Earth extends Planet(5.976e+24, 6.37814e6)


