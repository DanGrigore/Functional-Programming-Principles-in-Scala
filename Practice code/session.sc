def abs(x: Double): Double = if (x < 0) -x else x


def sqrt(x: Double) = {
  def sqrtIter(guess: Double, x: Double): Double =
    if (isGoodEnough(guess)) guess
    else sqrtIter(improve(guess), x)

  def isGoodEnough(guess: Double) =
    abs(guess * guess - x) / x < 0.001 //Epsilon value

  def improve(guess: Double) =
    (guess + x / guess) / 2

  sqrtIter(1.0, x)
}

sqrt(2)
sqrt(4)
sqrt(1e-6)
sqrt(1e60)

val x = 0
def f(y: Int) = y + 1
val result = {
  val x = f(3)
  x * x
} + x

//Tail recursion
def gcd(a: Int, b: Int): Int =
  if (b == 0) a else gcd(b, a % b)

gcd(20, 10)


//Not tail recursion
def factorial(n: Int): Int =
  if (n == 0) 1 else n * factorial(n - 1)

//Tail recursion of factorial
def factorial2(n: Int): Int = {
  def loop(acc: Int, n: Int): Int =
    if (n == 0) acc
    else loop(acc * n, n - 1)

  loop(1, n)
}


factorial(5)
factorial(2)
factorial(4)
factorial(3)

factorial2(5)
