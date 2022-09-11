import scala.util.CommandLineParser

given CommandLineParser.FromString[Color] with
  def fromString(value: String): Color =
    Color.valueOf(value)

enum Color:
  case Red, Green, Blue

@main def run(color: Color): Unit =
  println(s"The color is ${color.toString}")
