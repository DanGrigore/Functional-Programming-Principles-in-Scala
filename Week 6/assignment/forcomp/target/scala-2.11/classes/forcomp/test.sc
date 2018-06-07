import forcomp.Anagrams._
import forcomp.loadDictionary

val dictionary: List[Word] = loadDictionary
lazy val dictionaryByOccurrences: Map[Occurrences, List[Word]] = dictionary groupBy (wordOccurrences)

dictionaryByOccurrences(List(('a',1),('e',1),('t',1)))
