// list is recursive while array is flat
// list is immutable -- the element can`t be changed
// imagine that binary tree root node is cons
// and all cell has element and has another cell but at the end of node has nil

// list are homogeneous all elements must have same type
// example
val fruit: List[String] = List("apple", "pear", "lemmon")
val nums: List[Int] = List(1, 2, 3, 4)
val diag3: List[List[Int]] = List(List(1, 0, 0), List(0, 1, 0), List(0, 0, 1))
val empty: List[Nothing] = List()

// List can also write this!! head :: (list)
val furit1: List[String] = "Apple" :: ("Orange" :: ("Pear" :: Nil))
val nums1: List[Int] = 1 :: (2 :: (3 :: Nil))
val empty1 = List()

// List operations!!!
fruit.head == "apple"
fruit.tail.tail.head == "lemmon"

def isert(x: Int, xs: List[Int]): List[Int] = xs match
  case List() => List(x)
  case y :: ys => if y >= x then x :: y :: ys else y :: isert(x, ys)


// we can use pattern match in List!!
def isort(xs: List[Int]): List[Int] = xs match
  // when empty
  case List() => List()
  // when not empty decompose list head and tail.
  // until list empty and then insert sort bottom to top
  case y :: ys => isert(y, isort(ys))


val sample: List[Int] = List(5, 3, 2, 8)
isort(sample)







