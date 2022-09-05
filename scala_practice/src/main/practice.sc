
// class Person(var name: String, var vocation: String)
class Book(var title: String, var author: String, var year: Int)
class Movie(var name: String, var director: String, var year: Int)

/** new keyword to create a new instance!! */
 //val p: Person = new Person(name = "hyunwoo", vocation = "player")

/** in scala3 new keyword isn`t required! */

// val p = Person("hyunwoo", "player")

//println(p.name)
//p.vocation
class Person(var firstName: String, var lastName: String):
  println("init begins!!")
  val fullName: String = firstName + " " + lastName

  def printFullName: Unit =
    println(fullName)

  printFullName
  println("init end!!")


val hyun = Person("Hyunwoo", "Oh")


/** Default parameter */
class Socket(val timeout: Int = 5_000, val linger: Int = 5_000):
  override def toString = s"timeout: $timeout, linger: $linger"

val s = Socket()
val s = Socket(5_123)
val s = Socket(linger=1313)

/** Auxiliary constructor! */
import java.time.*

class Student(
  var name: String,
  var govId: String
):
  private var _applicationDate: Option[LocalDate] = None
  private var _studentId: Int = 0

  def this(
    name: String,
    govId: String,
    applicationDate: LocalDate
  ) =
    this(name, govId)
    _applicationDate = Some(applicationDate)
    println(_applicationDate)

  def this(
    name: String,
    govId: String,
    studentId: Int
  ) =
    this(name, govId)
    _studentId = studentId


val s1 = Student("Hyunwoo", "123")
println(f"student name is ${s1.name}, govId is ${s1.govId}")

/** note that private val can acess just in class!! */
val s2 = Student("hyunwoo", "123", LocalDate.now)
// println(s2._applicationDate)

//1 |println(s2._applicationDate)
//  |        ^^^^^^^^^^^^^^^^^^^
//|variable _applicationDate cannot be accessed as a member of (s2 : Student) from module class rs$line$14$.
//1 error found

// object!

// An object is a class that has exactly one instance.
// It’s initialized lazily when its members are referenced,
// similar to a lazy val. Objects in Scala allow grouping methods and fields under one namespace,
// similar to how you use static members on a class in Java, Javascript (ES6), or @staticmethod in Python.

object StringUtils:
  def truncate(s: String, length: Int): String =
    s.take(length)

  def containWhitespace(s: String): Boolean =
    s.matches(".*\\s.*")

  def isNullOrEmpty(s: String): Boolean =
    s == null || s.trim.isEmpty


