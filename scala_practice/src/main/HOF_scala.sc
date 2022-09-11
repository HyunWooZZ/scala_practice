def sayHello(f: () => Unit): Unit = f()

// using method!
def helloHyun(): Unit = println("Hello, Hyun")

//sayHello(helloHyun)

def bonjourHyun(): Unit = println("Hello scala, Hello Hyun!")

sayHello(bonjourHyun)

// using function!
val printName = () => println("Hello julien")

sayHello(printName)


def executeTimes(f: () => Unit, n: Int): Unit =
  for i <- (1 to n) do f()

executeTimes(printName, 3)

def executeAndPrint(f: (Int, Int) => Int, i: Int, j: Int): Unit =
  println(f(i, j))

val sum: (Int, Int) => Int = (x, y) => x + y
def multiply(x: Int, y: Int) = x * y

executeAndPrint(sum, 3, 11)       // prints 14
executeAndPrint(multiply, 3, 9)   // prints 27

def greet(theGreeting: String): String => Unit =
  (name: String) => println(s"${theGreeting}, ${name}")

val greetFunction = greet("Hello")

greetFunction("Hyunwoo")

val sayCiao = greet("Ciao")
val sayHola = greet("Hola")

sayHola("Carlos")
sayCiao("Isabel")


def createGreetingFunction(desiredLanguage: String): String => Unit =
  val english = (name: String) => println(s"Hello, $name")
  val french = (name: String) => println(s"Bonjour, $name")

  desiredLanguage match
    case "english" => english
    case "french" => french

val greetFrench = createGreetingFunction("french")
greetFrench("Hyunwoo")
