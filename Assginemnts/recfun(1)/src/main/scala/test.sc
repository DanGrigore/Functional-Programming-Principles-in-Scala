
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

balance("())(".toList)