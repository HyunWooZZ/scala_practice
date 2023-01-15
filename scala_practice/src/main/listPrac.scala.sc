/*
Define abtstract interface of list
**/
trait List[T]:
  def isEmpty: Boolean
  def head: T
  def tail: List[T]

class CONS[T](val head: T, val tail: List[T]) extends List[T]:
  def isEmpty = false

class NILS[T] extends List[T]:
  def isEmpty = true
  def head = throw new NoSuchElementException("Nil.head")
  def tail = throw new NoSuchElementException("nil.tail")

def nth[T](xs: List[T], n: Int): T =
  if xs.isEmpty then throw IndexOutOfBoundsException()
  else if n == 0 then xs.head
  else nth(xs.tail, n-1)


//test

nth(CONS(1, CONS(2, CONS(3, NILS()))), 2)



