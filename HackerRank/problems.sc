def nTimesPrint(n: Int): Unit = if (n != 0) {
  printf("Hello World")
  nTimesPrint(n - 1)
}

def repeatElements(num: Int, arr: List[Int]): List[Int] = arr flatMap (x => List.fill(num)(x))

def filterList(delim: Int, arr: List[Int]): List[Int] = arr filter (x => x < delim)

def oddPosition(arr: List[Int]): List[Int] = arr match {
  case _ :: xs => if (!xs.isEmpty) xs.head :: oddPosition(xs.tail) else Nil
  case Nil => Nil
}

def reversePositions(arr: List[Int]): List[Int] = arr.reverse

def sumOfOddElem(arr: List[Int]): Int = arr.filter(x => x % 2 != 0).sum

def absMethod(arr: List[Int]): List[Int] = arr map (x => Math.abs(x))

/* e^x expression
object Object {

  def main(args: Array[String]) {
    val stdin = scala.io.StdIn

    val n = stdin.readLine.trim.toInt

    for (nItr <- 1 to n) {
      val x = stdin.readLine.trim.toDouble
      print(resolve(x, 9))
    }
  }

  def resolve(n: Double, x: Int): Double = x match {
    case 0 => 1
    case 1 => n + resolve(n, 0)
    case x1 => Math.pow(n, x1) / factorial(x1) + resolve(n, x1 - 1)
  }

  def factorial(n: Double): Double = if (n == 1) 1 else n * factorial(n - 1)
}*/
