class Rational(x: Int, y: Int) {
  require(y != 0, "can not do division by 0")

  private def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)

  val numer = x / gcd(x, y)
  val denom = y / gcd(x, y)

  def unary_- : Rational = new Rational(-this.numer, this.denom)

  def sub(a: Rational): Rational = {
    new Rational(numer * a.numer - a.numer * denom, denom * a.denom)
  }

  def <(a: Rational): Boolean = numer * a.denom < a.numer * denom

  override def toString = numer + "/" + denom
}


val x = new Rational(6, 7)
-x
x
x.sub(new Rational(3, 2))
