def sum(f: Int => Int): (Int, Int) => Int = {
  def sumF(a: Int, b: Int): Int = {
    if (a > b) 0
    else f(a) + sumF(a + 1, b)
  }

  sumF
}

def factorial(a: Int): Int = {
  if (a == 0) return 1
  else a * factorial(a - 1)
}

def sumInts = sum(x => x)
def sumCubes = sum(x => x * x * x)
def sumFactorials = sum(factorial)

sumInts(1, 2)
sumCubes(2, 3)

sum(x => x * x * x)(3, 4)

def sum3(f: Int => Int)(a: Int, b: Int): Int =
  if (a > b) 0 else f(a) + sum3(f)(a + 1, b)

/**
  * Exercises
  */

def product(f: Int => Int)(x: Int, y: Int): Int =
  if (x > y) 1 else f(x) * product(f)(x + 1, y)

def fact(n: Int) = product(x => x)(1, n)

fact(5)

def mapReduce(f: Int => Int, combine: (Int, Int) => Int, zero: Int)(a: Int, b: Int): Int =
  if (a > b) zero
  else combine(f(a), mapReduce(f, combine, 0)(a + 1, b))
