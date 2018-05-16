package recfun

object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
  }

  /**
    * Exercise 1
    */
  def pascal(c: Int, r: Int): Int = {
    if (c == 0 || r == 0 || c == r) 1
    else
      pascal(c, r - 1) + pascal(c - 1, r - 1)
  }

  /**
    * Exercise 2
    */
  def balance(chars: List[Char]): Boolean = {
    def loop(left: Int, right: Int, chars: List[Char]): Boolean = {
      if (chars.isEmpty)
        if (left == right) true
        else false
      else if (right > left) false
      else
        chars.head match {
          case '(' => loop(left + 1, right, chars.tail)
          case ')' => loop(left, right + 1, chars.tail)
          case _ => loop(left, right, chars.tail)
        }
    }

    loop(0, 0, chars)
  }
  
  // Version 2.0 - better
  def balance(chars: List[Char]): Boolean = {
  def loop(check: Int, chars: List[Char]): Boolean = {
    if (chars.isEmpty && temp == 0)
      true
    else if (check != 0) false
    else
      chars.head match {
        case '(' => loop(check + 1, chars.tail)
        case ')' => loop(check - 1, chars.tail)
        case _ => loop(check, chars.tail)
      }
    }
  
    loop(0, chars)
  }
  balance("((())))(".toList)
  balance("(".toList)
  balance("((".toList)


  // Version 2.0 - better
  def balance2(chars: List[Char]): Boolean = {
    def loop(check: Int, chars: List[Char]): Boolean = {
      if (chars.isEmpty && check == 0)
        true
      else if (check != 0) false
      else
        chars.head match {
          case '(' => loop(check + 1, chars.tail)
          case ')' => loop(check - 1, chars.tail)
          case _ => loop(check, chars.tail)
        }
    }

    loop(0, chars)
  }
  balance("((())))(".toList)
  balance("(".toList)
  balance("((".toList)
  /**
    * Exercise 3
    */
  def countChange(money: Int, coins: List[Int]): Int = {
    if (money < 0 || coins.isEmpty) 0
    else if (money == 0) 1
    else
      countChange(money - coins.head, coins) + countChange(money, coins.tail)
  }
}
