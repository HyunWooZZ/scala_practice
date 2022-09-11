val ints = List(1, 2, 3)
val lines = (1, 2, 3)

ints(0)
lines._1

// longway
val doubleInts = ints.map(x => x * 2)
val doubleints = ints.map((x: Int) => x * 2)

// short way

val doubleInts = ints.map(_ * 2)

// or use foreach method!
ints.foreach(x => println(x))
ints.foreach((println(_)))
ints.foreach(println)


val double = (i: Int) => i * 2
val x = double(2)

List(1, 2, 3).map(double)

val triple = (i: Int) => i * 3

val functionList = List(double, triple)

val functionMap = Map(
  "2x" -> double,
  "3x" -> triple
)