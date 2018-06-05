def init[T](xs: List[T]): List[T] = xs match {
  case List() => throw new Error("init of empty list")
  case List(x) => Nil
  case y :: ys => List(y) ++ init(ys)
}

init(List(1, 2, 3, 4, 5))

def removeAt[T](n: Int, xs: List[T]) = (xs take n) ::: (xs drop n + 1)
removeAt(1, List('a', 'b', 'c', 'd')) // List(a, c, d)


def flatten(xs: List[Any]): List[Any] = xs match {
  case List() => Nil
  case (x: List[Any]) :: xs => flatten(x) ++ flatten(xs)
  case x :: xs => x :: flatten(xs)

}

flatten(List(List(1, 1), 2, List(3, List(5, 8)))) // List(1, 1, 2, 3, 5, 8)


def msort(xs: List[Int]): List[Int] = {
  val n = xs.length / 2
  if (n == 0) xs
  else {
    def merge(xs: List[Int], ys: List[Int]): List[Int] =
      (xs, ys) match {
        case (Nil, ys) => ys
        case (xs, Nil) => xs
        case (x :: xs1, y :: ys1) =>
          if (x < y) x :: merge(xs1, ys)
          else y :: merge(xs, ys1)

      }
    val (fst, snd) = xs splitAt n
    merge(msort(fst), msort(snd))
  }
}


val nums = List(-4, 20, 1, 3, 20, -3)
msort(nums)

def squareList(xs: List[Int]): List[Int] =
  xs match {
    case Nil => xs
    case y :: ys => y * y :: squareList(ys)
  }

def squareList2(xs: List[Int]): List[Int] =
  xs map ((x: Int) => x * x)


squareList(nums)
squareList2(nums)

def pack[T](xs: List[T]): List[List[T]] = xs match {
  case Nil => Nil
  case x :: xs1 => val (first, rest) = xs span (y => y == x)
    first :: pack(rest)
}

def encode[T](xs: List[T]):List[(T, Int)] =
  pack(xs) map (ys => (ys.head, ys.length))

pack(List("a", "a", "a", "b", "c", "c", "a")) //  List(List("a", "a", "a"), List("b"), List("c", "c"), List("a"))
encode(List("a", "a", "a", "b", "c", "c", "a")) //List(("a", 3), ("b", 1), ("c", 2), ("a", 1))