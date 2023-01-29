abstract class IntSet:
  // abstract member of class
  // So Note that we can make instance directly from abstract class! ex: val ins = IntSet  will illegal
  def incl(x: Int): IntSet
  def contains(x: Int): Boolean
  def union(s: IntSet): IntSet

object IntSet:
  def apply(): Empty = Empty
  def apply(x: Int) = Empty.incl(x)
  def apply(x: Int, y: Int) = Empty.incl(x).incl(y)


class Empty() extends IntSet:
  def contains(x: Int): Boolean = false
  def incl(x: Int): IntSet = NonEmpty(x, Empty(), Empty())
  def union(s: IntSet): IntSet = s


class NonEmpty(elem: Int, left: IntSet, right: IntSet) extends IntSet:

  def contains(x: Int): Boolean =
    if x < elem then left.contains(x)
    else if x > elem then right.contains(x)
    else true

  def incl(x: Int): IntSet =
    if x < elem then NonEmpty(elem, left.incl(x), right)
    else if then NonEmpty(elem, left, right.incl(x))
    else this

  def union(s: IntSet): IntSet =
    left.union(right).union(s).incl(elem)