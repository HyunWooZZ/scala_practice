// Traits
// they can serve to describe abstract interfaces

trait Showable:
  // abstract
  def show: String
  // concrete implement
  def showHtml = "<p>" + show + "</p>"

class Document(text: String) extends Showable:
  def show = text

// Mixin Composition
// Compose mutiple traits af feature which is often reffered to as mixin compositions.

trait GreetingService:
  def translate(text: String): String
  def sayHello = translate("Hello")

trait TranslationService:
  def translate(text: String): String = "..."

// To compose the two services,
trait ComposeService extends GreetingService, TranslationService

// Classes
class MyService(name: String) extends ComposeService, Showable:
  def show = s"$name says $sayHello"

val s1: MyService = MyService("Service 1")
val s2: GreetingService = s1
val s3: TranslationService = s1


// Planing for Extension
// in same file we can do below job..
class Person(name: String)
class softwareDeveloper(name: String, favoriteLang: String)
  extends Person(name)

//but another file in we can`t..
// if we use open we can!!! just in scala 3

open class Person(name: String)

// Instance and Private Mutable state
class Counter:
  private var _currentCount = 0

  def tick(): Unit = _currentCount += 1
  def count: Int = _currentCount

val c1 = Counter()
c1.count
c1.tick()
c1.tick()
// note that we can`t access private val at outside of class.
c1._currentCount
c1.count


// Service Oriented Design!!

trait SubjectObserver:

  type S <: Subject
  type O <: Observer

  trait Subject { self: S =>
    private var observers: List[O] = List()
    def subscribe(obs: O): Unit =
      observers = obs :: observers
    def publish() =
      for obs <- observers do obs.notify(this)
  }

  trait Observer {
    def notify(sub: S): Unit
  }

object SensorReader extends SubjectObserver:
  type S = Sensor
  type O = Display

  class Sensor(val label: String) extends Subject:
    private var currentValue = 0.0
    def value = currentValue
    def changeValue(v: Double) =
      currentValue = v
      publish()

  class Display extends Observer:
    def notify(sub: Sensor) =
      println(s"${sub.label} has value ${sub.value}")

import SensorReader.*

// setting up a network
val s1 = Sensor("sensor1")
val s2 = Sensor("sensor2")
val d1 = Display()
val d2 = Display()

s1.subscribe(d1)
s1.subscribe(d2)
s2.subscribe(d1)

// propagating updates through the network
s1.changeValue(2)
s2.changeValue(3)

// prints:
// sensor1 has value 2.0
// sensor1 has value 2.0
// sensor2 has value 3.0