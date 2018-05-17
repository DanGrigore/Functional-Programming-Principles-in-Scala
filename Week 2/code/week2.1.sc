//Part 1 -- basic concepts

def sumInts(a: Int, b: Int): Int = {
  if (a > b) 0
  else
    a + sumInts(a + 1, b)
}

sumInts(3, 4)
sumInts(3, 6)
sumInts(1, 4)

def cube(x: Int): Int = x * x * x

def sumCubes(x: Int, y: Int): Int = {
  if (x > y) 0
  else
    cube(x) + sumCubes(x + 1, y)
}

sumCubes(2, 4)

def factorial(a: Int): Int = {
  if (a == 0) return 1
  else a * factorial(a - 1)
}

def sumFactorials(x: Int, y: Int): Int = {
  if (x > y) 0
  else
    factorial(x) + sumFactorials(x + 1, y)
}

factorial(2)
factorial(4)

sumFactorials(2, 4)

//Part2 -- functions as parameters
def sum(f: Int => Int, x: Int, y: Int): Int = {
  if (x > y) 0
  else
    f(x) + sum(f, x + 1, y)
}
def id(x: Int) = x

def sumInts2(a: Int, b: Int) = sum(id, a, b)
def sumCubes2(a: Int, b: Int) = sum(cube, a, b)
def sumFactorials2(a: Int, b: Int) = sum(factorial, a, b)

sumInts2(3, 4)
sumCubes2(2, 4)
sumFactorials(2, 4)

//Part 3 -- anonymus functions

def sumInts3(a: Int, b: Int) = sum(x => x, a, b)
def sumCubes3(a: Int, b: Int) = sum(x => x * x * x, a, b)
//can't be done on factorial

//Part 4 - tail recursion for sum
// my version
def sum2(f: Int => Int)(a: Int, b: Int): Int = {
  def loop(a: Int, acc: Int): Int = {
    if (a == b) acc + f(a)
    else loop(a + 1, acc + f(a))
  }

  loop(a, 0)
}

sum2(x => x * x * x)(1, 4)
1 + 2 * 2 * 2 + 3 * 3 * 3 + 4 * 4 * 4

