import forcomp.Anagrams._
import forcomp.loadDictionary

val dictionary: List[Word] = loadDictionary
lazy val dictionaryByOccurrences: Map[Occurrences, List[Word]] = dictionary groupBy (wordOccurrences)

dictionaryByOccurrences(List(('a', 1), ('e', 1), ('t', 1)))

def subtract(x: Occurrences, y: Occurrences): Occurrences =
  y.toMap.foldLeft(x.toMap)((yelem, xelem) =>
    if (xelem._2 == yelem(xelem._1)) yelem - xelem._1
    else yelem updated(xelem._1, yelem(xelem._1) - xelem._2)).toList


//subtract(List(('x', 3), ('y', 1)), List(('x', 2), ('y', 1), ('z', 3)))

val lard = List(('a', 1), ('d', 1), ('l', 1), ('r', 1))
val r = List(('r', 1))
val lad = List(('a', 1), ('d', 1), ('l', 1))
subtract(lard, r)