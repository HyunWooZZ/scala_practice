// note that in Funtional Programming, Data and operation are two seperate Thing!
// 1. Describe our set of value.
// 2. Describe our operation that work on those value.(function)

// Modeling the Data
// enum > if we have alternatives use enum! (when you choose option!!)
// Case > use when you group Things! (or need more fine grained control!!)

// Describing Alternatives!
enum CrustSize:
  case Small, Medium, Large

enum CrustType:
  case Thin, Thick, Regular

enum Topping:
  case Cheese, Pepperoni, BlackOlives, GreenOlives, Onions

// Describing Compound Data(Grouping Things!!!)

import CrustSize.*
import CrustType.*
import Topping.*

case class Pizza(
  crustType: CrustSize,
  crustSize: CrustType,
  topping: Seq[Topping]
)

val myPizza = Pizza(Small, Regular, Seq(Cheese, Pepperoni))

// modeling the operation
def pizzaPrice(p: Pizza): Double = p match
  case Pizza(crustSize, crustType, toppings) =>
    val base = 6.00
    val crust = crustPrice(crustSize, crustType)
    val tops = toppings.map(toppingPrice).sum
    base + crust + tops

def toppingPrice(t: Topping): Double = t match
  case Cheese | Onions => 0.5
  case Pepperoni | BlackOlives | GreenOlives => 0.75

def crustPrice(s: CrustSize, t: CrustType): Double =
  (s, t) match
    case (Small | Medium, _) => 0.25
    case (Large, Thin) => 0.5
    case (Large, Regular) => 0.75
    case (Large, Thick) => 1.00

// note that all function the above is they are pure fuction
// they do not mutate any data or gave other side-effect
// they just recive values and compute the result!!

// How to Organize Functionality

// 1. Companion object
// Define the behavior- the function-- in a companion object!
case class Pizza(
                  crustSize: CrustSize,
                  crustType: CrustType,
                  toppings: Seq[Topping]
                )

// the companion object of case class Pizza
object Pizza:
  // the implementation of `pizzaPrice` from above
  def price(p: Pizza): Double = ...

enum Topping:
  case Cheese, Pepperoni, BlackOlives, GreenOlives, Onions

// the companion object of enumeration Topping
object Topping:
  // the implementation of `toppingPrice` above
  def price(t: Topping): Double = t match
    case Cheese | Onions => 0.5
    case Pepperoni | BlackOlives | GreenOlives => 0.75

val pizza1 = Pizza(Small, Thin, Seq(Cheese, Onions))
Pizza.price(pizza1)
//
//Grouping functionality this way has a few advantages:
//
//  It associates functionality with data and makes it easier to find for programmers (and the compiler).
//It creates a namespace and for instance lets us use price as a method name without having to rely on overloading.
//  The implementation of Topping.price can access enumeration values like Cheese without having to import them.
//However, there are also a few tradeoffs that should be considered:
//
//  It tightly couples the functionality to your data model. In particular, the companion object needs to be defined in the same file as your case class.
//It might be unclear where to define functions like crustPrice that could equally well be placed in a companion object of CrustSize or CrustType.


// 2. modules
// Creating a pizzasevice interface
trait PizzaServiceInterface:

  def price(p: Pizza): Double

  def addTopping(p: Pizza, t: Topping): Pizza
  def removeAllTopings(p: Pizza): Pizza

  def updateCrustSize(p: Pizza, cs: CrustSize): Pizza
  def updateCrustType(p: Pizza, ct: CrustType): Pizza

// Create concrete implementation

object PizzaService extends PizzaServiceInterface:
  def price(p: Pizza): Double = p match
    case Pizza(crustSize, crustType, toppings) =>
      val base = 6.00
      val crust = crustPrice(crustSize, crustType)
      val tops = toppings.map(toppingPrice).sum
      base + crust + tops

  def toppingPrice(t: Topping): Double = t match
    case Cheese | Onions => 0.5
    case Pepperoni | BlackOlives | GreenOlives => 0.75

  def crustPrice(s: CrustSize, t: CrustType): Double =
    (s, t) match
      case (Small | Medium, _) => 0.25
      case (Large, Thin) => 0.5
      case (Large, Regular) => 0.75
      case (Large, Thick) => 1.00

  def addTopping(p: Pizza, t: Topping): Pizza =
    p.copy(toppings = p.toppings :+ t)

  def removeAllToppings(p: Pizza): Pizza =
    p.copy(toppings = Seq.empty)

  def updateCrustSize(p: Pizza, cs: CrustSize): Pizza =
    p.copy(crustSize = cs)

  def updateCrustType(p: Pizza, ct: CrustType): Pizza =
    p.copy(crustType = ct)

end PizzaService

import PizzaService.*

val p = Pizza(Small, Thin, Seq(Cheese))

// use the PizzaService methods
val p1 = addTopping(p, Pepperoni)
val p2 = addTopping(p1, Onions)
val p3 = updateCrustType(p2, Thick)
val p4 = updateCrustSize(p3, Large)

println(price(p4)) // prints 8.75


//FP model


case class Pizza(
                  crustSize: CrustSize,
                  crustType: CrustType,
                  toppings: Seq[Topping]
                ):

  // the operations on the data model
  def price: Double =
    pizzaPrice(this) // implementation from above

  def addTopping(t: Topping): Pizza =
    this.copy(toppings = this.toppings :+ t)

  def removeAllToppings: Pizza =
    this.copy(toppings = Seq.empty)

  def updateCrustSize(cs: CrustSize): Pizza =
    this.copy(crustSize = cs)

  def updateCrustType(ct: CrustType): Pizza =
    this.copy(crustType = ct)

  def pizzaPrice(p: Pizza): Double = p match
    case Pizza(crustSize, crustType, toppings) =>
      val base = 6.00
      val crust = crustPrice(crustSize, crustType)
      val tops = toppings.map(toppingPrice).sum
      base + crust + tops

  def toppingPrice(t: Topping): Double = t match
    case Cheese | Onions => 0.5
    case Pepperoni | BlackOlives | GreenOlives => 0.75

  def crustPrice(s: CrustSize, t: CrustType): Double =
    (s, t) match
      case (Small | Medium, _) => 0.25
      case (Large, Thin) => 0.5
      case (Large, Regular) => 0.75
      case (Large, Thick) => 1.00
