val s = Vector(1, 2, 3, 4, 5)
val t = Vector(6, 7, 8, 9)
s exists (x => x % 2 == 0)
s forall (x => x % 2 == 0)
val x = s zip t
val (a, b) = x.unzip
println("a = " + a)
s.sum

def isPrime(n: Int): Boolean = (2 until n) forall (d => n % d != 0)


isPrime(29)

