val n: Int = 6
def isPrime(n: Int): Boolean = (2 until n) forall (d => n % d != 0)
//Method 1
(1 until n) flatMap (i => (1 until i)
                    map (j => (i, j))) filter (x => isPrime(x._1 + x._2))
//Method 2
for {
  i <- 1 until n
  j <- 1 until i
  if isPrime(i + j)
} yield (i, j)
