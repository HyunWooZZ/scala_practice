// case classes
// case calsses are used to model immutable data structures.
case class Person(name: String, relation: String)

// declare person!
val hyunwoo = Person("hyun", "niece")

// note that we can`t change!
// hyunwoo.name = "hyunwoo"

// since the fields of case class assumed immutable,
// scala give us many useful methods!

// case classes can be used as patterns!
hyunwoo match
  case Person(n, r) => println(f"name is ${n}, and he is ${r}")

// "equals" and "hashcode" methods will generated!!
val hannah = Person("Hannah", "niece")
hyunwoo == hannah

// toString method!
println(hyunwoo)

// copy method! can make eazy replicate!

case class BalseballTeam(name: String, lastWorldSeriesWin: Int)
val cubs1908 = BalseballTeam("Chicago Cubs", 1908)
val cubs2016 = cubs1908.copy(lastWorldSeriesWin = 2016)

cubs2016

// note that in FP we need to avoid mutating data structure!
// case classes are immuatable!
// copy method can create new instance that is other method without chage value
// unaply ad way with pattern matching!

// Case objects
// case obkects are simillar with case classes but this is
// singleton object

sealed trait Message
case class PlaySong(name: String) extends Message
case class IncreaseVolume(amount: Int) extends Message
case class DecreaseVolume(amount: Int) extends Message
case object StopPlaying extends Message

def handleMessages(message: Message): Unit = message match
  case PlaySong(name) => playSong(name)
  case IncreaseVolume(amount) => changeVolume(amount)
  case DecreaseVolume(amount) => changeVolume(-amount)
  case StopPlaying => stopPlayingSong()
