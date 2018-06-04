
abstract class CodeTree

case class Fork(left: CodeTree, right: CodeTree, chars: List[Char], weight: Int) extends CodeTree

case class Leaf(char: Char, weight: Int) extends CodeTree

def times(chars: List[Char]): List[(Char, Int)] = {
  val list = chars.map(x => (x, chars.count(_ == x)))
  list.distinct
}

times(List('a', 'b', 'a'))

def makeOrderedLeafList(freqs: List[(Char, Int)]): List[Leaf] = {
  freqs.sortBy(_._2).map((x) => Leaf(x._1, x._2))
}

def makeOrderedLeafList2(freqs: List[(Char, Int)]): List[Leaf] = {
  freqs.sortWith((x,y) => x._2 < y._2).map((x) => Leaf(x._1, x._2))
}

makeOrderedLeafList(List(('a', 2), ('b', 1),('c',34)))